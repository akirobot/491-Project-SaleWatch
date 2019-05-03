const express = require('express');
const app = express();
const router = express.Router();
const mongo = require('mongod');
const assert = require('assert');

const url = 'mongod://localhost:27017/admin';

let Game = require('../../src/app/models/Game');

router.route('/search').post(function (req, res) {
    Game.find(function (err, game){
        if(err){
            console.log(err);
        }
        else {
            res.json(game);
        }
    });
});

router.get('/', function(req, res, next){
    res.render('index');
});

router.get('/get-data', function(req, res, next){
    var resultArray = [];
    mongo.connect(url, function(err, db){
        assert.equal(null, err);
        var cursor = db.collection('games').find({"game_name": "One Finger Death Punch 2"});
        cursor.foreach(function (doc, err){
            assert(null,err);
            resultArray.push(doc);
        }, function() {
            db.close();
            res.render('index', {items: resultArray}); // MIGHT HAVE TO CHANGE INDEX TO THE CHART.HTML OR THE HTML OF THE PAGE THAT IS DISPLAY THE OBJECTS
            
        });
    });

});

router.get('/insert', function(req, res, next){
const item = {
    game_name: "test-name",
    price_: "test-price",
};

    mongo.connect(url, function(err, db){
        assert.equal(NULL, err);
        db.collection('games').insertOne(item, function(err, result){
            assert.equal(NULL, err);
            console.log("Item Inserted");
            db.close();
        });

    })
});

router.post('/update', function(req, res, next){

});

router.post('/delete', function(req, res, next){

});

module.exports = router;
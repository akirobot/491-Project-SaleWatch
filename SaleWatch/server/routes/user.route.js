const express = require('express');
const app = express();
const router = express.Router();
/*const mongo = require('mongod');
const assert = require('assert');

const url = 'mongod://localhost:27017/admin';*/


let User = require('../../src/app/models/User');

router.route('/register').post(function (req, res) {
    let user = new User(req.body);
    user.save()
      .then(user => {
          res.status(200).json({'user': 'user registered successfully'});
      })
      .catch(err => { 
          res.status(400).send("unable to register user to database");
      });
});

router.route('/login').post(function (req, res) {
    User.find(function (err, user){
        if(err){
            res.status(400).send("unable to login user");
        }
        else {
            res.status(200).json(user);
        }
    });
});

router.route('/getAll').get(function (req, res) {
    User.find(function (err, user) {
        if(err) {
            res.status(400).send("unable to get users");
        }
        else {
            res.status(200).json(user);
        }
    })
});
/*
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
    price_: "test-price"
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

});*/

module.exports = router;
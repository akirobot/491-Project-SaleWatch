const express = require('express');
const app = express();
const router = express.Router();

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

module.exports = router;
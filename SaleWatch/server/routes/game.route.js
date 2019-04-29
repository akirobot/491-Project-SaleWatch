const express = require('express');
const app = express();
const router = express.Router();

let Game = require('../../src/app/models/Game');

router.route('/search').post(function (req, res) {
    Game.find(function (err, game){
        if(err){
            res.status(400).send("unable to get games");
        }
        else {
            res.status(200).json(game);
        }
    });
});

module.exports = router;
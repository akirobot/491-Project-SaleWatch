const express = require('express');
const app = express();
const router = express.Router();

let User = require('../../src/app/models/User');

router.route('/register').post(function (req, res) {
    let user = new User(req.body);
    user.save()
      .then(user => {
          res.status(200).json(user);
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
            res.sendStatus(400).send("unable to get users");
        }
        else {
            res.status(200).json(user);
        }
    })
});

router.route('/update').post(function (req, res) {
    User.findById(req.body._id, function(err, user) {
        if(!user)
            return res.status(400).send("Unable to find user.");
        else {
            user.user_email = req.body.user_email;
            user.user_password = req.body.user_password;
            user.user_first_name = req.body.user_first_name;
            user.user_last_name = req.body.user_last_name;
            user.user_birthday = req.body.user_birthday;
            user.user_favorite_game_genre = req.body.user_favorite_game_genre;
            user.user_games = req.body.user_games;

            user.save().then(user => {
                res.json('Update complete');
            })
            .catch(err => {
                res.status(400).send("Unable to update user");
            });
        }
    });
});

module.exports = router;
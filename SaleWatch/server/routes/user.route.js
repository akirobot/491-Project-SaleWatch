const express = require('express');
const app = express();
const router = express.Router();

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
            res.sendStatus(400).send("unable to get users");
        }
        else {
            res.status(200).json(user);
        }
    })
});

router.route('/update/:id').post(function (req, res) {
    User.findById(req.params.id, function(err, next, user) {
        if(!user)
            return next(new Error('Could not load User'));
        else {
            user.user_first_name = req.body.user_first_name;
            user.user_last_name = req.body.user_last_name;
            user.user_password = req.body.user_password;
        }
    })
})

module.exports = router;
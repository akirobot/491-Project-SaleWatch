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
            console.log(err);
        }
        else {
            res.json(user);
        }
    });
});

module.exports = router;
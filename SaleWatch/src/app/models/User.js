
const mongoose = require('mongoose');
const Schema = mongoose.Schema;

let User = new Schema({
    user_email: {
        type: String
    },
    user_password: {
        type: String
    },
    user_first_name: {
        type: String
    },
    user_last_name: {
        type: String
    }
},{
    collection: 'user'
});

module.exports = mongoose.model('User', User);
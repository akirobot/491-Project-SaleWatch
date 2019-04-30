
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
    },
    user_birthday: {
        type: Date
    },
    user_favorite_game_genre: {
        type: String
    },
    user_games: [{
        type: mongoose.Schema.Types.ObjectId,
        ref: 'Game'
    }]
},{
    collection: 'user'
});

module.exports = mongoose.model('User', User);
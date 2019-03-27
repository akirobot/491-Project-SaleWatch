const mongoose = require('mongoose');
const Schema = mongoose.Schema;

let Game = new Schema({
    game_title: {
        type: String
    },
    game_publisher: {
        type: String
    },
    game_developer: {
        type: String
    },
    game_price: {
        type: Schema.Types.Decimal128
    },
    game_release_date: {
        type: Date
    }
},{
    collection: 'game'
});

module.exports = mongoose.model('Game', Game);
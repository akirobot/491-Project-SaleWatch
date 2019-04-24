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
    },
    game_img_src: {
        type: String
    },
    game_ESRB: {
        type: String
    },
    game_tags: [{
        type: String
    }]

},{
    collection: 'game'
});

module.exports = mongoose.model('Game', Game);
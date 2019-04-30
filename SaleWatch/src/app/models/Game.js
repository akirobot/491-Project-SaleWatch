const mongoose = require('mongoose');
const Schema = mongoose.Schema;

let Game = new Schema({
    game_name: {
        type: String
    },
    publisher: {
        type: String
    },
    developer: {
        type: String
    },
    price: {
        type: String
    },
    sale_price: {
        type: String
    },
    release_date: {
        type: Date
    },
    header_image: {
        type: String
    },
    game_tags: [{
        type: String
    }]

},{
    collection: 'game'
});

module.exports = mongoose.model('Game', Game);
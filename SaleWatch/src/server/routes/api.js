import { Router } from 'express';
const router = Router();
import { MongoClient } from 'mongodb';
import { ObjectID } from 'mongodb';

// Connect
const connection = (closure) => {
    return MongoClient.connect('mongodb://localhost:27018/SaleWatch', (err, db) => {
        if (err) return console.log(err);

        closure(db);
    });
};

// Error handling
const sendError = (err, res) => {
    response.status = 501;
    response.message = typeof err == 'object' ? err.message : err;
    res.status(501).json(response);
};

// Response handling
let response = {
    status: 200,
    data: [],
    message: null
};

// Get users
router.get('/users', (req, res) => {
    connection((db) => {
        db.collection('users')
            .find()
            .toArray()
            .then((users) => {
                response.data = users;
                res.json(response);
            })
            .catch((err) => {
                sendError(err, res);
            });
    });
});

export default router;
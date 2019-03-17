// Get dependencies
const express = require('express');
const path = require('path');
const http = require('http');
const bodyParser = require('body-parser');
//import cors from 'cors';
const cors = require('cors');
//import mongoose from 'mongoose';
const mongoose = require('mongoose');

//import user routes
const userRoute = require('./server/routes/user.route');
// Get our API routes
const api = require('./server/routes/api');
const app = express();




mongoose.connect('mongodb://localhost:27017');
const connection = mongoose.connection;

connection.once('open', () => {
  console.log('MongoDB database connection established successfully!');
});

// Parsers for POST data
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: false }));
app.use(cors());
app.use('/user', userRoute);

// Point static path to dist
app.use(express.static(path.join(__dirname, 'dist/SaleWatch')));

// Set our api routes
app.use('/api', api);

// Catch all other routes and return the index file
app.get('*', (req, res) => {
  res.sendFile(path.join(__dirname, 'dist/SaleWatch/index.html'));
});

app.listen(4000, () => console.log(`Express server running on port 4000`));

/**
 * Get port from environment and store in Express.
 */
const port = process.env.PORT || '4200';
app.set('port', port);

/**
 * Create HTTP server.
 */
const server = http.createServer(app);

/**
 * Listen on provided port, on all network interfaces.
 */
server.listen(port, () => console.log(`API running on localhost:${port}`));
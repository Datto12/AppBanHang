var express = require('express');
var router = express.Router();
var api_user = require('../controllers/user.api');


router.get('/', api_user.list );
router.post('/add', api_user.add);



module.exports = router;

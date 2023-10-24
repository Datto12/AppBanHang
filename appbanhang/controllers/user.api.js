var md = require('../models/user')

exports.list = async(req,res,next) =>{

    try {
        const user = await md.UModel.find({});
        res.json(user);
      } catch (err) {
        console.error("Error fetching users:", err);
        res.status(500).send("Internal Server Error");
      }
}
exports.add = async (req, res, next) => {
  
    const { email,passwd} = req.body;
    const newUser = new md.UModel({
        email: email,
        passwd: passwd,
       
    });
    newUser
        .save()
        .then(() =>{
            res.status(201).json({ message: 'Đã lưu đối tượng vào MongoDB'});
        })
        .catch((error) => {
            console.error("Lỗi lưu đối tượng vào MongoDB: ",error);
            res.status(500).json({ error: "Đã xảy ra lỗi server"});
        });
}
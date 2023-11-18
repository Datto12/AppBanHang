package vn.edu.fpt.appbanhang.models;

public class Cart {
    private String _id ;
    private String id_user ;
    private Sanpham id_sp ;
    private String onModel ;

    public Cart() {
    }

    public Cart(String _id, String id_user, Sanpham id_sp, String onModel) {
        this._id = _id;
        this.id_user = id_user;
        this.id_sp = id_sp;
        this.onModel = onModel;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public Sanpham getId_sp() {
        return id_sp;
    }

    public void setId_sp(Sanpham id_sp) {
        this.id_sp = id_sp;
    }

    public String getOnModel() {
        return onModel;
    }

    public void setOnModel(String onModel) {
        this.onModel = onModel;
    }

    public class Sanpham{
        private String _id ;
        private String tensp ;
        private String the_loai ;
        private String mota ;
        private String giasp ;
        private String hinhanh ;
        private String soluong;

        public Sanpham(String _id, String tensp, String the_loai, String mota, String giasp, String hinhanh, String soluong) {
            this._id = _id;
            this.tensp = tensp;
            this.the_loai = the_loai;
            this.mota = mota;
            this.giasp = giasp;
            this.hinhanh = hinhanh;
            this.soluong = soluong;
        }

        public Sanpham() {
        }

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getTensp() {
            return tensp;
        }

        public void setTensp(String tensp) {
            this.tensp = tensp;
        }

        public String getThe_loai() {
            return the_loai;
        }

        public void setThe_loai(String the_loai) {
            this.the_loai = the_loai;
        }

        public String getMota() {
            return mota;
        }

        public void setMota(String mota) {
            this.mota = mota;
        }

        public String getGiasp() {
            return giasp;
        }

        public void setGiasp(String giasp) {
            this.giasp = giasp;
        }

        public String getHinhanh() {
            return hinhanh;
        }

        public void setHinhanh(String hinhanh) {
            this.hinhanh = hinhanh;
        }

        public String getSoluong() {
            return soluong;
        }

        public void setSoluong(String soluong) {
            this.soluong = soluong;
        }
    }
}

package vn.edu.fpt.appbanhang.Retrofit;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import vn.edu.fpt.appbanhang.DienThoai.DuLieuChiTietDienThoai;
import vn.edu.fpt.appbanhang.DienThoai.DuLieuDT;
import vn.edu.fpt.appbanhang.LapTop.DuLieu;
import vn.edu.fpt.appbanhang.LapTop.DuLieuChiTietLaptop;
import vn.edu.fpt.appbanhang.SanPhamMoi.SanPham;
import vn.edu.fpt.appbanhang.SanPhamMoi.SpMoi;
import vn.edu.fpt.appbanhang.models.User;

public interface MyRetrofit {
    MyRetrofit api =new Retrofit.Builder().baseUrl("http://192.168.1.7:3000/").addConverterFactory(GsonConverterFactory.create()).build().create(MyRetrofit.class);

    @GET("spmoi/listspmoi")
    Call<SanPham> GetListSpMoi();
    @GET("lt/lt")
    Call<DuLieu> getListLapTop();

    @GET("dt/dt")
    Call<DuLieuDT> getListDienThoai();

    @GET("dt/{id}")
    Call<DuLieuChiTietDienThoai> getChiTietDienThoai(@Path("id") String id);

    @GET("lt/{id}")
    Call<DuLieuChiTietLaptop> getChiTietLaptop(@Path("id") String id);

    @GET("user")
    Call<ArrayList<User>> getUser();

    @POST("user/add")
    Call<User> addUser(@Body User user);
}


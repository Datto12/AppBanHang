package vn.edu.fpt.appbanhang.Retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import vn.edu.fpt.appbanhang.DienThoai.DuLieuChiTietDienThoai;
import vn.edu.fpt.appbanhang.DienThoai.DuLieuDT;
import vn.edu.fpt.appbanhang.LapTop.DuLieu;
import vn.edu.fpt.appbanhang.LapTop.DuLieuChiTietLaptop;
import vn.edu.fpt.appbanhang.SanPhamMoi.SanPham;
import vn.edu.fpt.appbanhang.SanPhamMoi.SpMoi;
import vn.edu.fpt.appbanhang.models.Cart;
import vn.edu.fpt.appbanhang.models.User;

public interface MyRetrofit {
    MyRetrofit api =new Retrofit.Builder().baseUrl("http://192.168.0.103:3000/").addConverterFactory(GsonConverterFactory.create()).build().create(MyRetrofit.class);

    @GET("spmoi/listspmoi")
    Call<SanPham> GetListSpMoi();
    @GET("lt/lt")
    Call<DuLieu> getListLapTop();

    @GET("dt/dt")
    Call<DuLieuDT> getListDienThoai();


    // api gio hang
    @GET("cart")
    Call<List<Cart>> getList(@Query("id_user")String id_user);
    @DELETE("cart/{id}")
    Call<Cart> deleteAp(@Path("id")String id);

    @FormUrlEncoded
    @POST("cart")
    Call<Cart> addCart(@Field("id_user")String id_user,@Field("id_sp")String id_sp,@Field("onModel")String onModel);




    @GET("dt/{id}")
    Call<DuLieuChiTietDienThoai> getChiTietDienThoai(@Path("id") String id);

    @GET("lt/{id}")
    Call<DuLieuChiTietLaptop> getChiTietLaptop(@Path("id") String id);
}

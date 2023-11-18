package vn.edu.fpt.appbanhang.DienThoai;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.edu.fpt.appbanhang.R;
import vn.edu.fpt.appbanhang.Retrofit.MyRetrofit;
import vn.edu.fpt.appbanhang.models.Cart;

public class ChiTietDienThoaiActivity extends AppCompatActivity {
    private ImageView img;
    private TextView tvTen , tvGia, tvMota;
    private Button btnMua;
    private ArrayList<ChiTietDienThoai> list;
    private String id_dienthoai;
    String id  ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_dien_thoai);
        img = findViewById(R.id.imgChiTietDienThoai);
        tvTen = findViewById(R.id.tenChiTietDienThoai);
        tvGia = findViewById(R.id.giaChiTietDienThoai);
        tvMota = findViewById(R.id.motaChiTietDienThoai);
        btnMua = findViewById(R.id.btnMuaDienThoai);
        id  = getIntent().getStringExtra("id_dienthoai");
        ChiTiet();
        addCart();
    }
    public void ChiTiet(){
        Handler handler = new Handler(Looper.getMainLooper());

        MyRetrofit.api.getChiTietDienThoai(id).enqueue(new Callback<DuLieuChiTietDienThoai>() {
            @Override
            public void onResponse(Call<DuLieuChiTietDienThoai> call, Response<DuLieuChiTietDienThoai> response) {
                DuLieuChiTietDienThoai dl = response.body();
                String tensp =dl.getData().get(0).getTensp();
                String giasp = dl.getData().get(0).getGiasp();
                String hinhanh = dl.getData().get(0).getHinhanh();
                String mota = dl.getData().get(0).getMota();
                id_dienthoai = dl.getData().get(0).getId();

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        tvTen.setText(tensp);
                        tvGia.setText(giasp);
                        tvMota.setText(mota);
                        Picasso.get().load(hinhanh).into(img);
                    }
                });
            }

            @Override
            public void onFailure(Call<DuLieuChiTietDienThoai> call, Throwable t) {

            }
        });
    }
    String id_user = "653913832367b0e5485fd324";
    public void addCart(){
        btnMua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyRetrofit.api.addCart(id_user,id,"DtModel").enqueue(new Callback<Cart>() {
                    @Override
                    public void onResponse(Call<Cart> call, Response<Cart> response) {
                        if (response.isSuccessful()){
                            Toast.makeText(ChiTietDienThoaiActivity.this,"Them gio hang thanh cong",Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Cart> call, Throwable t) {

                    }
                });
            }
        });
    }
}
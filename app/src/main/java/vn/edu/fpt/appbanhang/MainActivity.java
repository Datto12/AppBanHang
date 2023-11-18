package vn.edu.fpt.appbanhang;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;

import android.widget.ViewFlipper;

import com.google.android.material.navigation.NavigationView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.edu.fpt.appbanhang.Cart.CartFragment;
import vn.edu.fpt.appbanhang.DienThoai.DienThoaiFragment;
import vn.edu.fpt.appbanhang.LapTop.ChiTietLaptopActivity;
import vn.edu.fpt.appbanhang.LapTop.LapTopFragment;
import vn.edu.fpt.appbanhang.LienHe.LienHeFragment;
import vn.edu.fpt.appbanhang.Retrofit.MyRetrofit;
import vn.edu.fpt.appbanhang.SanPhamMoi.AdapterSpMoi;
import vn.edu.fpt.appbanhang.SanPhamMoi.SanPham;
import vn.edu.fpt.appbanhang.SanPhamMoi.SanPhamMoiFragment;
import vn.edu.fpt.appbanhang.SanPhamMoi.SpMoi;
import vn.edu.fpt.appbanhang.SanPhamYeuThich.MyAdapter;
import vn.edu.fpt.appbanhang.ThongTin.ThongTinFragment;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private Toolbar toolbar;
    private ViewFlipper viewFlipper;
    private GridView gridView;
    private RecyclerView recyclerView1;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private FrameLayout frameLayout;
    private AdapterSpMoi adapterSpMoi;
    private ArrayList<SpMoi> list;
    private MyAdapter myAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        ActionBar();
        ActionViewFlipper();
        getSanPhamMoi();
        getSanPhamYeuThich();
        ChiTietSanPhamMoi();
    }
    private void ActionViewFlipper(){
        List<String> mangquangcao = new ArrayList<>();
        mangquangcao.add("https://prbaochi.com/wp-content/uploads/2021/07/mau-banner-quang-cao-san-pham-4.jpg");
        mangquangcao.add("https://prbaochi.com/wp-content/uploads/2021/07/mau-banner-quang-cao-san-pham-11.jpg");
        mangquangcao.add("https://prbaochi.com/wp-content/uploads/2021/07/mau-banner-quang-cao-san-pham-15.jpg");
        mangquangcao.add("https://prbaochi.com/wp-content/uploads/2021/07/mau-banner-quang-cao-san-pham-16.jpg");
        for (int i = 0;i<mangquangcao.size();i++){
            ImageView imageView = new ImageView(getApplicationContext());
            Picasso.get().load(mangquangcao.get(i)).into(imageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            viewFlipper.addView(imageView);
        }
        viewFlipper.setFlipInterval(3000);
        viewFlipper.setAutoStart(true);
        Animation slide_in = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_right);
        Animation slide_out = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_left);
        viewFlipper.setInAnimation(slide_in);
        viewFlipper.setOutAnimation(slide_out);
    }
    private void ActionBar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.opendrawer,R.string.closedrawer);
        toggle.syncState();
        toolbar.setNavigationIcon(R.drawable.ic_menu);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.home) {
           startActivity(new Intent(getApplicationContext(),MainActivity.class));
        } else if (id == R.id.dienthoai) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.id_framelayout, DienThoaiFragment.newInstance());//Thay thế màn hình framelayout bằng Bai1fragment
            transaction.commit();
        }else if (id == R.id.laptop) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.id_framelayout, LapTopFragment.newInstance());//Thay thế màn hình framelayout bằng Bai1fragment
            transaction.commit();
        }else if (id == R.id.lienhe) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.id_framelayout, LienHeFragment.newInstance());//Thay thế màn hình framelayout bằng Bai1fragment
            transaction.commit();
        }else if (id == R.id.thongtin) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.id_framelayout, ThongTinFragment.newInstance());//Thay thế màn hình framelayout bằng Bai1fragment
            transaction.commit();
       }
        else if (id == R.id.cart) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.id_framelayout, CartFragment.newInstance());//Thay thế màn hình framelayout bằng Bai1fragment
            transaction.commit();
        }
        drawerLayout.closeDrawer(navigationView);
        return false;
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(navigationView)){
            drawerLayout.closeDrawer(navigationView);
        }else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK){
            if(drawerLayout.isDrawerOpen(navigationView)){
                drawerLayout.closeDrawer(navigationView);
            }else {
                finish();
            }
        }
        return true;
    }


    private void AnhXa(){
       toolbar = findViewById(R.id.toolbar);
        viewFlipper = findViewById(R.id.viewflipper);
        recyclerView1 = findViewById(R.id.recycleview);
        gridView = findViewById(R.id.gridView);
        navigationView = findViewById(R.id.NavView);
        drawerLayout = findViewById(R.id.drawerLayout);
        frameLayout = findViewById(R.id.id_framelayout);
    }
    public void getSanPhamMoi(){
       MyRetrofit.api.GetListSpMoi().enqueue(new Callback<SanPham>() {
           @Override
           public void onResponse(Call<SanPham> call, Response<SanPham> response) {
               if(response.body()!=null){
                   list = new ArrayList<>();
                   list = response.body().getData();
                   adapterSpMoi = new AdapterSpMoi(list);
                   LinearLayoutManager manager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL, false);
                   recyclerView1.setLayoutManager(manager);
                   recyclerView1.setAdapter(adapterSpMoi);
                   adapterSpMoi.notifyDataSetChanged();
               }
           }

           @Override
           public void onFailure(Call<SanPham> call, Throwable t) {

           }
       });
    }
    public void getSanPhamYeuThich(){
        MyRetrofit.api.GetListSpMoi().enqueue(new Callback<SanPham>() {
            @Override
            public void onResponse(Call<SanPham> call, Response<SanPham> response) {
                if (response.body() != null) {
                    list = new ArrayList<>();
                    list = response.body().getData();
                    myAdapter = new MyAdapter(list,MainActivity.this,R.layout.item_listspyeuthich);
                    gridView.setAdapter(myAdapter);
                    myAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<SanPham> call, Throwable t) {

            }
        });
    }
    public void ChiTietSanPhamMoi(){
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.id_framelayout, SanPhamMoiFragment.newInstance());//Thay thế màn hình framelayout bằng Bai1fragment
                transaction.commit();
            }
        });
    }
}
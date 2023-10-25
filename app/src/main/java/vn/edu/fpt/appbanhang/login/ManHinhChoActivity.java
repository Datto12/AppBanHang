package vn.edu.fpt.appbanhang.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import vn.edu.fpt.appbanhang.MainActivity;
import vn.edu.fpt.appbanhang.R;


public class ManHinhChoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_cho);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                nextActivity();
            }
        }, 2000);
    }

    private void nextActivity() {
        startActivity(new Intent(ManHinhChoActivity.this, LoginActivity.class));
        finish(); // Kết thúc activity hiện tại sau khi chuyển sang LoginActivity
    }
}
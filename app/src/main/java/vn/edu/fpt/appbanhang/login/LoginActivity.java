package vn.edu.fpt.appbanhang.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.edu.fpt.appbanhang.MainActivity;
import vn.edu.fpt.appbanhang.R;
import vn.edu.fpt.appbanhang.Retrofit.MyRetrofit;
import vn.edu.fpt.appbanhang.SignUp.SignUpActivity;
import vn.edu.fpt.appbanhang.models.User;

public class LoginActivity extends AppCompatActivity {
    private EditText edEmail,edPassword;
    private Button btnLogin;
    private TextView tvSignUp;
    private ArrayList<User> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        AnhXa();
        list = new ArrayList<User>();
        SignUp();
      //  GetDataUser();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckLogin();
            }
        });
    }
    public void AnhXa(){
        edEmail = findViewById(R.id.edEmailLogin);
        edPassword = findViewById(R.id.edPasswordLogin);
        btnLogin = findViewById(R.id.btnLogin);
        tvSignUp = findViewById(R.id.tvSignUp);

    }
//    public void GetDataUser(){
//       MyRetrofit.api.getUser().enqueue(new Callback<User>() {
//           @Override
//           public void onResponse(Call<User> call, Response<User> response) {
//               if(response.isSuccessful()){
//                   list.clear();
//                   list.addAll(response.body());
//               }
//           }
//
//           @Override
//           public void onFailure(Call<User> call, Throwable t) {
//
//           }
//       });
//    }
    public void CheckLogin(){
        String email = edEmail.getText().toString().trim();
        String passwd = edPassword.getText().toString().trim();

        if(list == null || list.isEmpty()){
            return;
        }
        boolean isHanUser = false;
        for (User user : list){
            if(email.equals(user.getEmail().toString()) && passwd.equals(user.getPasswd().toString())){
                isHanUser = true;
                Toast.makeText(this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                break;
            }
        }
        if(isHanUser){
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        }else {
            Toast.makeText(this, "Email or Pass sai", Toast.LENGTH_SHORT).show();
        }
    }
    public void SignUp(){
        tvSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SignUpActivity.class));
            }
        });
    }
}
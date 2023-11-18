package vn.edu.fpt.appbanhang.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.edu.fpt.appbanhang.MainActivity;
import vn.edu.fpt.appbanhang.R;
import vn.edu.fpt.appbanhang.Retrofit.MyRetrofit;
import vn.edu.fpt.appbanhang.models.User;

public class SignUpActivity extends AppCompatActivity {
    private EditText edEmail,edPass,edRePass;
    private Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        AnhXa();
//        btnSignUp.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                SignUp();
//            }
//        });
    }
    public void AnhXa(){
        edEmail = findViewById(R.id.edEmailSignUp);
        edPass = findViewById(R.id.edPasswordSignUp);
        edRePass = findViewById(R.id.edRePasswordSignUp);
        btnSignUp = findViewById(R.id.btnSignUp);
    }
//    public void SignUp(){
//        String email = edEmail.getText().toString().trim();
//        String passwd = edPass.getText().toString().trim();
//        String rePass = edRePass.getText().toString().trim();
//        if(email.isEmpty() || passwd.isEmpty() || rePass.isEmpty()){
//            Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
//            edRePass.setText("");
//            edEmail.setText("");
//            edPass.setText("");
//
//        }
//        if(rePass.equals(passwd)){
//            User user = new User(email,passwd);
//            MyRetrofit.api.addUser(user).enqueue(new Callback<User>() {
//                @Override
//                public void onResponse(Call<User> call, Response<User> response) {
//                    Toast.makeText(SignUpActivity.this, "Đăng kí thành công", Toast.LENGTH_SHORT).show();
//                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
//                }
//
//                @Override
//                public void onFailure(Call<User> call, Throwable t) {
//
//                }
//            });
//        }else {
//            Toast.makeText(this, "Vui lòng nhập đúng mật khẩu", Toast.LENGTH_SHORT).show();
//        }
//    }
}
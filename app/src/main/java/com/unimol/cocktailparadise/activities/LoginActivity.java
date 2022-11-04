package com.unimol.cocktailparadise.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.unimol.cocktailparadise.R;
import com.unimol.cocktailparadise.models.LoginDTO;
import com.unimol.cocktailparadise.network.RetrofitClient;
import com.unimol.cocktailparadise.network.UserService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private EditText mailBox;
    private EditText passwordBox;
    private Button loginButton;
    private TextView registerLink;
    private String loginUrl = "login/dologin?";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.mailBox = (EditText) findViewById(R.id.mailBox);
        this.passwordBox = (EditText) findViewById(R.id.passwordBox);
        this.loginButton = (Button) findViewById(R.id.loginButton);
        this.registerLink = (TextView) findViewById(R.id.registerLink);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                UserService userService = RetrofitClient.getRetrofitInstanceMYSQ().create(UserService.class);
                Call<LoginDTO> call = userService.login(mailBox.getText().toString().trim(), passwordBox.getText().toString().trim());

                Log.e("mail", mailBox.getText().toString().trim());
                Log.e("password", passwordBox.getText().toString().trim());

                call.enqueue(new Callback<LoginDTO>() {
                    @Override
                    public void onResponse(Call<LoginDTO> call, Response<LoginDTO> response) {
                        LoginDTO loginDTO = response.body();

                        Integer userId = loginDTO.getUserId();
                        Log.e("mail", userId.toString());

                        if(loginDTO.getStatus() == true){

                        }

                    }

                    @Override
                    public void onFailure(Call<LoginDTO> call, Throwable t) {

                    }
                });
            }
        });
    }
}
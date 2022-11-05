package com.unimol.cocktailparadise.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.unimol.cocktailparadise.R;
import com.unimol.cocktailparadise.models.LoginDTO;
import com.unimol.cocktailparadise.network.RetrofitClient;
import com.unimol.cocktailparadise.network.UserService;
import com.unimol.cocktailparadise.util.Preferences;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private EditText mailBox;
    private EditText passwordBox;
    private Button loginButton;
    private TextView registerLink;
    private TextView recoverPasswordText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.mailBox = (EditText) findViewById(R.id.mailBox);
        this.passwordBox = (EditText) findViewById(R.id.passwordBox);
        this.loginButton = (Button) findViewById(R.id.loginButton);
        this.registerLink = (TextView) findViewById(R.id.registerLink);
        this.recoverPasswordText = (TextView) findViewById(R.id.recoverPasswordText);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                UserService userService = RetrofitClient.getRetrofitInstanceMYSQL().create(UserService.class);
                Call<LoginDTO> call = userService.login(mailBox.getText().toString().trim(), passwordBox.getText().toString().trim());

                Log.e("mail", mailBox.getText().toString().trim());
                Log.e("password", passwordBox.getText().toString().trim());

                call.enqueue(new Callback<LoginDTO>() {
                    @Override
                    public void onResponse(Call<LoginDTO> call, Response<LoginDTO> response) {
                        LoginDTO loginDTO = response.body();
                        if (!(loginDTO == null)) {
                            int userId = loginDTO.getUserId();
                            String username = loginDTO.getUsername();
                            if (loginDTO.getStatus()) {
                                Preferences.savePreferences(LoginActivity.this, mailBox.getText().toString().trim(), passwordBox.getText().toString().trim(), userId, username);
                                Toast.makeText(LoginActivity.this, "Bentornato " + username + "!", Toast.LENGTH_LONG).show();
                                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                            } else {
                                Toast.makeText(LoginActivity.this, "Credenziali errate!", Toast.LENGTH_LONG).show();
                            }
                        } else {
                            Toast.makeText(LoginActivity.this, "Errore di connessione!", Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<LoginDTO> call, Throwable t) {

                        Toast.makeText(LoginActivity.this, "Errore di connessione!", Toast.LENGTH_LONG).show();


                    }
                });
            }
        });

        this.registerLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });

        this.recoverPasswordText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, OtpActivity.class));
            }
        });


    }

    @Override
    public void onBackPressed() {
    }
}
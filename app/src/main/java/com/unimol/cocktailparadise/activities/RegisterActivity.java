package com.unimol.cocktailparadise.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.unimol.cocktailparadise.R;
import com.unimol.cocktailparadise.models.LoginDTO;
import com.unimol.cocktailparadise.models.RegisterDTO;
import com.unimol.cocktailparadise.network.RetrofitClient;
import com.unimol.cocktailparadise.network.UserService;
import com.unimol.cocktailparadise.util.Preferences;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    private EditText usernameBox;
    private EditText mailBox;
    private EditText passwordBox;
    private Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        this.usernameBox = (EditText) findViewById(R.id.usernameBox);
        this.mailBox = (EditText) findViewById(R.id.mailBox);
        this.passwordBox = (EditText) findViewById(R.id.passwordBox);
        this.registerButton = (Button) findViewById(R.id.registerButton);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                UserService userService = RetrofitClient.getRetrofitInstanceMYSQL().create(UserService.class);
                Call<RegisterDTO> call = userService.register(usernameBox.getText().toString().trim(), mailBox.getText().toString().trim(), passwordBox.getText().toString().trim());
                Log.e("mail", mailBox.getText().toString().trim());
                Log.e("password", passwordBox.getText().toString().trim());

                call.enqueue(new Callback<RegisterDTO>() {
                    @Override
                    public void onResponse(Call<RegisterDTO> call, Response<RegisterDTO> response) {
                        RegisterDTO registerDTO = response.body();
                        if(registerDTO.getStatus() == true){
                            Toast.makeText(RegisterActivity.this, registerDTO.getError_msg(), Toast.LENGTH_SHORT).show();
                            Toast.makeText(RegisterActivity.this, "Ora effettua l'accesso", Toast.LENGTH_LONG).show();
                            startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                        } else {
                            Toast.makeText(RegisterActivity.this, registerDTO.getError_msg(), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<RegisterDTO> call, Throwable t) {

                    }
                });

            }
        });

    }


}
package com.unimol.cocktailparadise.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.unimol.cocktailparadise.R;
import com.unimol.cocktailparadise.models.OTPResponseDTO;
import com.unimol.cocktailparadise.network.RetrofitClient;
import com.unimol.cocktailparadise.network.UserService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewPasswordActivity extends AppCompatActivity {

    private EditText newPasswordText;
    private Button newPasswordButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.unimol.cocktailparadise.R.layout.activity_new_password);

        Intent intent = getIntent();
        String temp = getIntent().getStringExtra("mail");

        newPasswordText = (EditText) findViewById(R.id.newPasswordText);
        newPasswordButton = (Button) findViewById(R.id.newPasswordButton);

        newPasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                UserService userService = RetrofitClient.getRetrofitInstanceMYSQL().create(UserService.class);
                Call<OTPResponseDTO> call = userService.changePassword(temp, newPasswordText.getText().toString().trim());

                call.enqueue(new Callback<OTPResponseDTO>() {
                    @Override
                    public void onResponse(Call<OTPResponseDTO> call, Response<OTPResponseDTO> response) {
                        OTPResponseDTO otpResponseDTO = response.body();
                        if(otpResponseDTO.getStatus()){
                            Toast.makeText(NewPasswordActivity.this, otpResponseDTO.getMessage(), Toast.LENGTH_LONG).show();
                            Toast.makeText(NewPasswordActivity.this, "Ora effettua l'accesso.", Toast.LENGTH_LONG).show();
                            startActivity(new Intent(NewPasswordActivity.this, LoginActivity.class));
                        } else {
                            Toast.makeText(NewPasswordActivity.this, otpResponseDTO.getMessage(), Toast.LENGTH_LONG).show();
                            startActivity(new Intent(NewPasswordActivity.this, LoginActivity.class));
                        }
                    }

                    @Override
                    public void onFailure(Call<OTPResponseDTO> call, Throwable t) {

                    }
                });

            }
        });




    }



}
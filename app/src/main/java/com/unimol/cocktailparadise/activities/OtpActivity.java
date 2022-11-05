package com.unimol.cocktailparadise.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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

public class OtpActivity extends AppCompatActivity {

    private EditText otpEditText;
    private EditText mailLostText;
    private Button recoverPassButton;
    private Button checkOtpButton;
    int otpValue = 0;
    String mailForIntent = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);

        this.otpEditText = (EditText) findViewById(R.id.otpEditText);
        this.mailLostText = (EditText) findViewById(R.id.lostEmailText);
        this.recoverPassButton = (Button) findViewById(R.id.recoverPassButton);
        this.checkOtpButton = (Button) findViewById(R.id.checkOtpButton);

        checkOtpButton.setVisibility(View.INVISIBLE);
        checkOtpButton.setClickable(false);

        otpEditText.setVisibility(View.INVISIBLE);

        recoverPassButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String temp = mailLostText.getText().toString().trim();

                if(!temp.isEmpty()){

                    UserService userService = RetrofitClient.getRetrofitInstanceMYSQL().create(UserService.class);
                    Call<OTPResponseDTO> call = userService.passwordRecovery(temp);

                    call.enqueue(new Callback<OTPResponseDTO>() {
                        @Override
                        public void onResponse(Call<OTPResponseDTO> call, Response<OTPResponseDTO> response) {
                            OTPResponseDTO otpResponseDTO = response.body();

                            if(otpResponseDTO.getStatus()){
                                mailForIntent = mailLostText.getText().toString().trim();
                                otpValue = otpResponseDTO.getOtpValue();
                                Toast.makeText(OtpActivity.this, "Codice OTP inviato alla mail!", Toast.LENGTH_SHORT).show();
                                Integer i = otpValue;
                                Log.e("MESSAGE", i.toString());

                                otpEditText.setVisibility(View.VISIBLE);
                                checkOtpButton.setVisibility(View.VISIBLE);
                                checkOtpButton.setClickable(true);
                            }
                        }

                        @Override
                        public void onFailure(Call<OTPResponseDTO> call, Throwable t) {

                        }
                    });

                }
                else {
                    Toast.makeText(OtpActivity.this, "Devi inserire una mail!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        checkOtpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(otpValue == Integer.parseInt(otpEditText.getText().toString())){
                    Intent intent = new Intent(OtpActivity.this, NewPasswordActivity.class);
                    intent.putExtra("mail", mailForIntent);
                    startActivity(intent);
                } else{
                    Toast.makeText(OtpActivity.this, "OTP non corretto!", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
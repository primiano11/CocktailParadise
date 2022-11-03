package com.unimol.cocktailparadise.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.unimol.cocktailparadise.R;

public class LoginActivity extends AppCompatActivity {

    private EditText mailBox;
    private EditText passwordBox;
    private Button loginButton;
    private TextView registerLink;
    private TextView changePasswordLink;
    private String loginUrl = "login/dologin?";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.mailBox = (EditText) findViewById(R.id.mailBox);
        this.passwordBox = (EditText) findViewById(R.id.passwordBox);
        this.loginButton = (Button) findViewById(R.id.loginButton);
        this.registerLink = (TextView) findViewById(R.id.registerLink);
    }


}
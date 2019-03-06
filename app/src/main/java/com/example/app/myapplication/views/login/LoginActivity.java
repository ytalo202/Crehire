package com.example.app.myapplication.views.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.app.myapplication.R;
import com.example.app.myapplication.views.main.MainActivity;
import com.example.app.myapplication.views.register.RegisterActivity;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void Login(View view) {
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
        finish();
    }

    public void GoRegister(View view) {
        Intent i = new Intent(this,RegisterActivity.class);
        startActivity(i);
    }
}

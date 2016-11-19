package ru.devfestsiberia.codelabfirebase.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import ru.devfestsiberia.codelabfirebase.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void login(View v){
        Intent intent  = new Intent(this, MainActivity.class);
        finishAffinity();
        startActivity(intent);
    }
}

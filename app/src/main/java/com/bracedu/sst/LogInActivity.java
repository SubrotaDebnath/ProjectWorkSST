package com.bracedu.sst;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LogInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }

    }

    public void logInBTN(View view) {
        startActivity(new Intent(LogInActivity.this,MainActivity.class));
    }
}

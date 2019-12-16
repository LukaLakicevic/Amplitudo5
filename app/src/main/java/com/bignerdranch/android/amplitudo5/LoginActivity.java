package com.bignerdranch.android.amplitudo5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.bignerdranch.android.amplitudo5.DataHolder.holder;


public class LoginActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText emailTextView = findViewById(R.id.txt_email);
        final EditText passwordTextView = findViewById(R.id.txt_password);
        Button submitBtn = findViewById(R.id.btn_submit);



        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                holder.setEmail(emailTextView.getText().toString());
                holder.setPassword(passwordTextView.getText().toString());

                startActivity(new Intent(LoginActivity.this, MainActivity.class));
            }
        });
    }
}
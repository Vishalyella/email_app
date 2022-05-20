package com.example.emailapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText eTo;
    private EditText eSubject;
    private EditText eMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eTo = findViewById(R.id.txtTo);
        eSubject = findViewById(R.id.txtSub);
        eMsg = findViewById(R.id.txtMsg);
        Button btn;
        btn = findViewById(R.id.btnSend);
        btn.setOnClickListener(v -> {
            Intent it = new Intent(Intent.ACTION_SEND);
            it.putExtra(Intent.EXTRA_EMAIL, new String[]{eTo.getText().toString()});
            it.putExtra(Intent.EXTRA_SUBJECT,eSubject.getText().toString());
            it.putExtra(Intent.EXTRA_TEXT,eMsg.getText());
            it.setType("message/rfc822");
            startActivity(Intent.createChooser(it,"Choose Mail App"));
        });
    }
}
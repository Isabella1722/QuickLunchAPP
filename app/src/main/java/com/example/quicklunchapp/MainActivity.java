package com.example.quicklunchapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button iniciarSesionBtn;
    private Button registroBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        iniciarSesionBtn= findViewById(R.id.iniciarSesionBtn);
        registroBtn= findViewById(R.id.registroBtn);



        iniciarSesionBtn.setOnClickListener(
                (v)->{
                    Intent i = new Intent(this,IniciarSesionActivity.class);
                    startActivity(i);
                }
        );

        registroBtn.setOnClickListener(
                (v)->{
                    Intent i = new Intent(this,RegistroActivity.class);
                    startActivity(i);
                }
        );

    }
}

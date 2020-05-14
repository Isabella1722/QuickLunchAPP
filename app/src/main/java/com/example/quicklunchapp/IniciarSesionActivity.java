package com.example.quicklunchapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class IniciarSesionActivity extends AppCompatActivity {

    private EditText documentoET;
    private EditText claveET;
    private Button iniciarBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_sesion);

        documentoET= findViewById(R.id.documentoET);
        claveET= findViewById(R.id.claveET);
        iniciarBtn= findViewById(R.id.iniciarBtn);


        iniciarBtn.setOnClickListener(
                (v)->{
                    Intent i = new Intent(this, MenuActivity.class);
                    startActivity(i);
                }
        );
    }
}

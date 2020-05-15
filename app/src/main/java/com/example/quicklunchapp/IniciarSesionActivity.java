package com.example.quicklunchapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class IniciarSesionActivity extends AppCompatActivity {

    private EditText documentoET;
    private EditText claveET;
    private Button iniciarBtn;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_sesion);

        documentoET = findViewById(R.id.documentoET);
        claveET = findViewById(R.id.claveET);
        iniciarBtn = findViewById(R.id.iniciarBtn);

        iniciarBtn.setOnTouchListener(
                (v, event) -> {

                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN:
                            v.setBackgroundResource(R.drawable.focus_input);
                            break;

                        case MotionEvent.ACTION_MOVE:

                            break;

                        case MotionEvent.ACTION_UP:
                            v.setBackgroundResource(R.drawable.rounded_input);
                            Intent i = new Intent(this, MenuActivity.class);
                            startActivity(i);
                            break;
                    }
                    return true;
                }
        );
    }
}

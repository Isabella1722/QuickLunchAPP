package com.example.quicklunchapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button iniciarSesionBtn;
    private Button registroBtn;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciarSesionBtn = findViewById(R.id.iniciarSesionBtn);
        registroBtn = findViewById(R.id.registroBtn);

        iniciarSesionBtn.setOnTouchListener(
                (v, event) -> {

                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN:
                            v.setBackgroundResource(R.drawable.focus_input);
                            break;

                        case MotionEvent.ACTION_MOVE:

                            break;

                        case MotionEvent.ACTION_UP:
                            v.setBackgroundResource(R.drawable.rounded_input);
                            Intent i = new Intent(this, IniciarSesionActivity.class);
                            startActivity(i);
                            break;
                    }
                    return true;
                }
        );

        registroBtn.setOnTouchListener(
                (v, event) -> {

                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN:
                            v.setBackgroundResource(R.drawable.focus_input);
                            break;

                        case MotionEvent.ACTION_MOVE:

                            break;

                        case MotionEvent.ACTION_UP:
                            v.setBackgroundResource(R.drawable.rounded_input);
                            Intent i = new Intent(this, RegistroActivity.class);
                            startActivity(i);
                            break;
                    }
                    return true;
                }
        );
    }
}

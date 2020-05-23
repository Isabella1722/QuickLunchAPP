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

        // Encontrar los views
        iniciarSesionBtn = findViewById(R.id.iniciarSesionBtn);
        registroBtn = findViewById(R.id.registroBtn);

        iniciarSesionBtn.setOnTouchListener(
                (v, event) -> {
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN:
                            // Cambiar el color del boton al presionarlo
                            v.setBackgroundResource(R.drawable.focus_input);
                            break;

                        case MotionEvent.ACTION_MOVE:

                            break;

                        case MotionEvent.ACTION_UP:
                            // Restaurar el color del boton al soltarlo y cambiar de actividad
                            v.setBackgroundResource(R.drawable.rounded_input);
                            Intent i = new Intent(this, IniciarSesionActivity.class);
                            startActivity(i);
                            finish();
                            break;
                    }
                    return true;
                }
        );

        registroBtn.setOnTouchListener(
                (v, event) -> {
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN:
                            // Cambiar el color del boton al presionarlo
                            v.setBackgroundResource(R.drawable.focus_input);
                            break;

                        case MotionEvent.ACTION_MOVE:

                            break;

                        case MotionEvent.ACTION_UP:
                            // Restaurar el color del boton al soltarlo y cambiar de actividad
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

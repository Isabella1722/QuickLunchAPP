package com.example.quicklunchapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.quicklunchapp.model.Plato;

import java.util.ArrayList;

public class VerPlatoActivity extends AppCompatActivity {

    private EditText nombreET;
    private ImageView imagenPlato;
    private EditText descripcionET;
    private EditText bebidaET;
    private EditText jugoET;
    private EditText comentariosET;

    String mostrarN;
    private Button pedirBtn;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_plato);

        pedirBtn = findViewById(R.id.pedirBtn);
        nombreET = findViewById(R.id.nombreET);
        mostrarN= getIntent().getExtras().getString("nombre");
        nombreET.setText(mostrarN);

        pedirBtn.setOnTouchListener(
                (v, event) -> {

                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN:
                            v.setBackgroundResource(R.drawable.focus_input);
                            break;

                        case MotionEvent.ACTION_MOVE:

                            break;

                        case MotionEvent.ACTION_UP:
                            v.setBackgroundResource(R.drawable.rounded_input);
                            Intent i = new Intent(this, VerTicketActivity.class);
                            startActivity(i);
                            break;
                    }
                    return true;
                }
        );
    }
}

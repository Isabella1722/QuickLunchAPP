package com.example.quicklunchapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.quicklunchapp.model.Plato;

import java.util.ArrayList;

public class VerPlatoActivity extends AppCompatActivity {

    private TextView nombreET;
    private ImageView imagenPlato;
    private TextView descripcionET;
    private TextView bebidaET;
    private TextView postreET;
    private EditText comentariosET;

    private Button pedirBtn;

    private Plato plato;
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_plato);

        pedirBtn = findViewById(R.id.pedirBtn);
        nombreET = findViewById(R.id.nombreET);
        descripcionET = findViewById(R.id.descripcionET);
        bebidaET = findViewById(R.id.bebidaET);
        postreET = findViewById(R.id.postreET);

        //String nombre = getIntent().getExtras().getString("nombre");
        String descrip = getIntent().getExtras().getString("descrip");
        String bebida = getIntent().getExtras().getString("bebida");
        String postre = getIntent().getExtras().getString("postre");

        //nombreET.setText(nombre);
        descripcionET.setText(descrip);
        bebidaET.setText(bebida);
        postreET.setText(postre);

        plato= (Plato) getIntent().getExtras().getSerializable("plato");
        nombreET.setText(plato.toString());
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

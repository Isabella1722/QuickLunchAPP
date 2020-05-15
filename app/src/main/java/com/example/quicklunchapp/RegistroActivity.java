package com.example.quicklunchapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.style.TtsSpan;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.quicklunchapp.model.Usuario;
import com.google.firebase.database.FirebaseDatabase;

public class RegistroActivity extends AppCompatActivity {


    private EditText nombreET;
    private EditText codigoET;
    private EditText documentoET;
    private EditText claveUnoET;
    private EditText claveDosET;
    private Button registrarseBtn;
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        nombreET= findViewById(R.id.nombreET);
        codigoET= findViewById(R.id.codigoET);
        documentoET= findViewById(R.id.documentoET);
        claveUnoET= findViewById(R.id.claveUnoET);
        claveDosET= findViewById(R.id.claveDosET);
        registrarseBtn= findViewById(R.id.registrarseBtn);

        registrarseBtn.setOnTouchListener(
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
                            String id = FirebaseDatabase.getInstance().getReference().child("estudiantes").push().getKey();
                            String nombre= nombreET.getText().toString();
                            String codigo= codigoET.getText().toString();
                            String documentoIdentidad= documentoET.getText().toString();
                            String clave= claveUnoET.getText().toString();
                            
                            Usuario estudiante = new Usuario(id,nombre,codigo,documentoIdentidad,clave);
                            FirebaseDatabase.getInstance().getReference().child("estudiantes").child(id).setValue(estudiante);

                            break;
                    }
                    return true;
                }
        );
    }
}

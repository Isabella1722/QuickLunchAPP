package com.example.quicklunchapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.style.TtsSpan;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.quicklunchapp.model.Usuario;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class RegistroActivity extends AppCompatActivity {


    private EditText nombreET;
    private EditText codigoET;
    private EditText documentoET;
    private EditText claveUnoET;
    private EditText claveDosET;
    private Button registrarseBtn;
    private RadioButton condicionesRButton;
    private boolean estaRegistrado;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        nombreET = findViewById(R.id.nombreET);
        codigoET = findViewById(R.id.codigoET);
        documentoET = findViewById(R.id.documentoET);
        claveUnoET = findViewById(R.id.claveUnoET);
        claveDosET = findViewById(R.id.claveDosET);
        registrarseBtn = findViewById(R.id.registrarseBtn);
        condicionesRButton = findViewById(R.id.condicionesRButton);
        estaRegistrado = false;

        registrarseBtn.setOnTouchListener(
                (v, event) -> {
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN:
                            v.setBackgroundResource(R.drawable.focus_input);
                            //estaRegistrado = false;
                            break;

                        case MotionEvent.ACTION_MOVE:

                            break;

                        case MotionEvent.ACTION_UP:
                            v.setBackgroundResource(R.drawable.rounded_input);
                            String nombre = nombreET.getText().toString();
                            String codigo = codigoET.getText().toString();
                            String documentoIdentidad = documentoET.getText().toString();
                            String clave = claveUnoET.getText().toString();
                            String confirmarClave = claveDosET.getText().toString();

                            String id = FirebaseDatabase.getInstance().getReference().child("estudiantes").push().getKey();
                            Usuario estudiante = new Usuario(id, nombre, codigo, documentoIdentidad, clave);

                            FirebaseDatabase.getInstance().getReference("estudiantes/").addChildEventListener(new ChildEventListener() {
                                @Override
                                public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                                    Usuario usuario = dataSnapshot.getValue(Usuario.class);
                                    ArrayList<Usuario> usuarioArrayList;
                                    usuarioArrayList = new ArrayList<>();
                                    usuarioArrayList.add(usuario);

                                    for (int i = 0; i < usuarioArrayList.size(); i++) {
                                        String docu = usuarioArrayList.get(i).getDocumentoIdentidad();
                                        if(estudiante.getDocumentoIdentidad().equals(docu)) {
                                            estaRegistrado = true;
                                            break;
                                        }
                                    }
                                }

                                @Override
                                public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                                }

                                @Override
                                public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

                                }

                                @Override
                                public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {

                                }
                            });


                            if (!nombre.equals("") && !codigo.equals("") && !documentoIdentidad.equals("") && !estaRegistrado &&
                                    !clave.equals("") && clave.equals(confirmarClave) && condicionesRButton.isChecked()) {
                                FirebaseDatabase.getInstance().getReference().child("estudiantes").child(id).setValue(estudiante);
                                Intent i = new Intent(this, MenuActivity.class);
                                startActivity(i);

                            } else if (!clave.equals(confirmarClave)) {
                                runOnUiThread(
                                        () -> {
                                            Toast.makeText(this, "Las claves no coinciden", Toast.LENGTH_SHORT).show();
                                        }
                                );
                            } else if (estaRegistrado) {
                                runOnUiThread(
                                        () -> {
                                            Toast.makeText(this, "El usuario ya está registrado", Toast.LENGTH_SHORT).show();
                                        }
                                );
                            } else {
                                runOnUiThread(
                                        () -> {
                                            Toast.makeText(this, "Rellene los campos y acepte los términos y condiciones", Toast.LENGTH_SHORT).show();
                                        }
                                );
                            }
                            break;
                    }
                    return true;
                }
        );
    }
}

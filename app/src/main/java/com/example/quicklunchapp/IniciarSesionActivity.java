package com.example.quicklunchapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.quicklunchapp.model.Usuario;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

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

                            Query query = FirebaseDatabase.getInstance().getReference("estudiantes").orderByChild("documentoIdentidad").equalTo(documentoET.getText().toString().trim());
                            query.addListenerForSingleValueEvent(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    Usuario usuario = null;
                                    for(DataSnapshot coincidencia: dataSnapshot.getChildren()) {
                                        usuario = coincidencia.getValue(Usuario.class);
                                    }

                                    if(usuario == null) {
                                        Toast.makeText(IniciarSesionActivity.this, "El estudiante no está registrado", Toast.LENGTH_LONG).show();

                                    } else {
                                        if(usuario.getClave().equals(claveET.getText().toString().trim())) {
                                            Intent i = new Intent(IniciarSesionActivity.this, MenuActivity.class);
                                            i.putExtra("usuario", usuario);
                                            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                            startActivity(i);
                                        } else {
                                            Toast.makeText(IniciarSesionActivity.this, "La clave es incorrecta", Toast.LENGTH_LONG).show();
                                        };
                                    }

                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {

                                }
                            });
                            break;
                    }
                    return true;
                }
        );
    }
}

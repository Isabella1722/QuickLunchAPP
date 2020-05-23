package com.example.quicklunchapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.preference.PreferenceManager;
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

        // Encontrar los views
        documentoET = findViewById(R.id.documentoET);
        claveET = findViewById(R.id.claveET);
        iniciarBtn = findViewById(R.id.iniciarBtn);

        iniciarBtn.setOnTouchListener(
                (v, event) -> {
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN:
                            // Cambiar el color del boton al presionarlo
                            v.setBackgroundResource(R.drawable.focus_input);
                            break;

                        case MotionEvent.ACTION_MOVE:

                            break;

                        case MotionEvent.ACTION_UP:
                            // Restaurar el color del boton al soltarlo
                            v.setBackgroundResource(R.drawable.rounded_input);

                            // Verificar si el usuario ya esta registrado
                            Query query = FirebaseDatabase.getInstance().getReference("estudiantes").orderByChild("documentoIdentidad").equalTo(documentoET.getText().toString().trim());
                            query.addListenerForSingleValueEvent(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    Usuario usuario = null;

                                    for(DataSnapshot coincidencia: dataSnapshot.getChildren()) {
                                        // Obtener usuario que coincida con los datos ingresados
                                        usuario = coincidencia.getValue(Usuario.class);
                                    }

                                    if(usuario == null) {
                                        // Mostrar mensaje si el usuario no esta registrado
                                        Toast.makeText(IniciarSesionActivity.this, "El estudiante no está registrado", Toast.LENGTH_LONG).show();

                                    } else {
                                        // Ir a la siguiente actividad si el usuario esta registrado
                                        if(usuario.getClave().equals(claveET.getText().toString().trim())) {
                                            SharedPreferences localStorage = PreferenceManager.getDefaultSharedPreferences(IniciarSesionActivity.this);
                                            localStorage.edit().putString("userdocumento", usuario.getDocumentoIdentidad()).putString("userclave", usuario.getClave()).apply();
                                            Intent i = new Intent(IniciarSesionActivity.this, MenuActivity.class);

                                            // Pasar usuario a la siguiente actividad
                                            i.putExtra("usuario", usuario);

                                            // Cerrar actividades anteriores
                                            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

                                            startActivity(i);
                                        } else {
                                            // Mostrar mensaje si el usuario escribe mal su clave
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

package com.example.quicklunchapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.Toast;

import com.example.quicklunchapp.model.Usuario;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private Button iniciarSesionBtn;
    private Button registroBtn;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Comprobar usuario
        comprobarLogin();

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

    public void comprobarLogin() {
        SharedPreferences localStorage = PreferenceManager.getDefaultSharedPreferences(this);
        String documento = localStorage.getString("userdocumento", "NO_USER");
        String clave = localStorage.getString("userclave", "NO_PASS");
        if(!documento.equals("NO_USER") || !clave.equals("NO_PASS")) {
            login(documento, clave, this);
        }
    }

    public void login(String documento, String clave, Context context) {
        Query query = FirebaseDatabase.getInstance().getReference("estudiantes").orderByChild("documentoIdentidad").equalTo(documento);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Usuario usuario = null;

                for(DataSnapshot coincidencia: dataSnapshot.getChildren()) {
                    // Obtener usuario que coincida con los datos ingresados
                    usuario = coincidencia.getValue(Usuario.class);
                }

                if(usuario == null) {

                } else {
                    // Ir a la siguiente actividad si el usuario esta registrado
                    if(usuario.getClave().equals(clave)) {
                        SharedPreferences localStorage = PreferenceManager.getDefaultSharedPreferences(context);
                        localStorage.edit().putString("userdocumento", usuario.getDocumentoIdentidad()).putString("userclave", usuario.getClave()).apply();
                        Intent i = new Intent(context, MenuActivity.class);

                        // Pasar usuario a la siguiente actividad
                        i.putExtra("usuario", usuario);

                        // Cerrar actividades anteriores
                        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

                        startActivity(i);
                    } else {
                        // Mostrar mensaje si el usuario escribe mal su clave
                        Toast.makeText(context, "La clave es incorrecta", Toast.LENGTH_LONG).show();
                    };
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}

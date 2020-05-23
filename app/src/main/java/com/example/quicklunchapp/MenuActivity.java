package com.example.quicklunchapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;

import com.example.quicklunchapp.model.CustomAdapter;
import com.example.quicklunchapp.model.Plato;
import com.example.quicklunchapp.model.Usuario;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {

    private GridView listaPlatosGv;
    private CustomAdapter adapter;
    private Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        // Obtener los views
        listaPlatosGv = findViewById(R.id.listaPlatosGv);

        // Inicializar adapter del gridView
        adapter = new CustomAdapter();
        listaPlatosGv.setAdapter(adapter);

        // Traer usuario de la actividad anterior
        usuario = (Usuario) getIntent().getExtras().getSerializable("usuario");

        //Cargar platos de firebase
        FirebaseDatabase.getInstance().getReference().child("platos")
                .addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                        Plato plato = dataSnapshot.getValue(Plato.class);
                        // Agregar platos a gridView
                        adapter.agregarPlato(plato);
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

        // Seleccionar plato del gridView
        listaPlatosGv.setOnItemClickListener(
                (view, renglon, pos, id) -> {
                    Plato plato = (Plato) listaPlatosGv.getItemAtPosition(pos);
                    Intent i = new Intent(this, VerPlatoActivity.class);

                    // Pasar el usuario y el plato a la siguiente actividad
                    i.putExtra("usuario", usuario);
                    i.putExtra("plato", plato);

                    startActivity(i);
                }
        );
    }
}



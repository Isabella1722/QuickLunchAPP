package com.example.quicklunchapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.quicklunchapp.model.Plato;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;

public class VerTicketActivity extends AppCompatActivity {

    private TextView descripcionET;
    private TextView estadoPedido;
    private ImageView imagenQr;
    private Plato plato;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_ticket);
        descripcionET = findViewById(R.id.descripcionET);
        estadoPedido = findViewById(R.id.estadoPedido);
        imagenQr = findViewById(R.id.imagenQr);


        // Traer plato
        plato = (Plato) getIntent().getExtras().getSerializable("plato");
        String nombre = plato.getNombre();
        descripcionET.setText(nombre);



    }
}

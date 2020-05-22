package com.example.quicklunchapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.quicklunchapp.model.Plato;
import com.example.quicklunchapp.model.Ticket;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class VerTicketActivity extends AppCompatActivity {

    private TextView descripcionET;
    private TextView estadoPedido;
    private Plato plato;
    private Ticket ticket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_ticket);
        descripcionET = findViewById(R.id.descripcionET);
        estadoPedido = findViewById(R.id.estadoPedido);
        ticket = (Ticket) getIntent().getExtras().getSerializable("ticket");

        // Traer plato
        plato = (Plato) getIntent().getExtras().getSerializable("plato");
        String nombre = plato.getNombre();
        String estado = ticket.getEstado();
        descripcionET.setText(nombre);

        String text = ticket.getId(); // Whatever you need to encode in the QR code

        FirebaseDatabase.getInstance().getReference("pedidos/").child(ticket.getId()).child("estado").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String nuevoEstado = dataSnapshot.getValue().toString();
                estadoPedido.setText(nuevoEstado);

                if(nuevoEstado.contains("listo")){
                    Intent i = new Intent(VerTicketActivity.this, FinalActivity.class);
                    i.putExtra("idQr", text);
                    startActivity(i);
                    finish();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}

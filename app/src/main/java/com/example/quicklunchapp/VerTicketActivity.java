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

        // Obtener los views
        descripcionET = findViewById(R.id.descripcionET);
        estadoPedido = findViewById(R.id.estadoPedido);

        // Traer ticket de la actividad anterior
        ticket = (Ticket) getIntent().getExtras().getSerializable("ticket");

        // Obtener datos del ticket y del plato
        String nombre = ticket.getNombrePlato();
        String estado = ticket.getEstado();

        // Dar valor al textView
        descripcionET.setText(nombre);

        // Codigo del ticket que se obtiene al escanear el Qr
        String text = ticket.getId();

        // Obtener el estado del pedido actual
        FirebaseDatabase.getInstance().getReference("pedidos/").child(ticket.getId()).child("estado").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // Verificar si el pedido aun existe
                if (dataSnapshot.exists()) {
                    String nuevoEstado = dataSnapshot.getValue().toString();
                    // Cambiar el textView de acuerdo al estado del pedido
                    estadoPedido.setText(nuevoEstado);

                    // Cambiar de actividad cuando el pedido este listo para ser reclamado
                    if (nuevoEstado.contains("listo")) {
                        Intent i = new Intent(VerTicketActivity.this, FinalActivity.class);

                        // Pasar el codigo del ticket a la siguiente actividad
                        i.putExtra("idQr", text);
                        startActivity(i);
                        finish();
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}

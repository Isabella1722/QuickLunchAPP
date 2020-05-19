package com.example.quicklunchapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

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
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

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

        String text="Hola xd"; // Whatever you need to encode in the QR code
        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        try {
            BitMatrix bitMatrix = multiFormatWriter.encode(text, BarcodeFormat.QR_CODE,200,200);
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
            imagenQr.setImageBitmap(bitmap);
        } catch (WriterException e) {
            e.printStackTrace();
        }
    }
}

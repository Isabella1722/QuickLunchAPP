package com.example.quicklunchapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.quicklunchapp.model.Usuario;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import java.util.Objects;

public class FinalActivity extends AppCompatActivity {

    private Button cerrarBtn;
    private ImageView qrImg;
    private String codigoQr;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        cerrarBtn = findViewById(R.id.cerrarBtn);
        qrImg = findViewById(R.id.qrImg);
        codigoQr = getIntent().getExtras().getString("idQr");

        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        try {
            BitMatrix bitMatrix = multiFormatWriter.encode(codigoQr, BarcodeFormat.QR_CODE, 200, 200);
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
            qrImg.setImageBitmap(bitmap);
        } catch (WriterException e) {
            e.printStackTrace();
        }

        cerrarBtn.setOnTouchListener(
                (v, event) -> {
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN:
                            v.setBackgroundResource(R.drawable.focus_input2);
                            break;

                        case MotionEvent.ACTION_MOVE:

                            break;

                        case MotionEvent.ACTION_UP:
                            v.setBackgroundResource(R.drawable.rounded_input2);
                            Intent i = new Intent(FinalActivity.this, MainActivity.class);
                            startActivity(i);
                            finish();
                            break;
                    }
                    return true;
                }
        );
    }
}

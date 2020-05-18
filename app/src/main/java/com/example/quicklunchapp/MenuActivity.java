package com.example.quicklunchapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.quicklunchapp.model.Plato;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {

    private ImageButton menuUnoBtn;
    private ImageButton menuDosBtn;
    private ImageButton menuTresBtn;
    private ImageButton menuCuatroBtn;
    private ImageButton menuCincoBtn;
    private ImageButton menuSeisBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        menuUnoBtn = findViewById(R.id.menuUnoBtn);
        menuDosBtn = findViewById(R.id.menuDosBtn);
        menuTresBtn = findViewById(R.id.menuTresBtn);
        menuCuatroBtn = findViewById(R.id.menuCuatroBtn);
        menuCincoBtn = findViewById(R.id.menuCincoBtn);
        menuSeisBtn = findViewById(R.id.menuSeisBtn);


        menuUnoBtn.setOnClickListener(
                (v) -> {
                    restaurarAlphaDeImagenes();
                    menuUnoBtn.setAlpha(0.2f);
                    String nombre = "Pollo colombiano";
                    String descripcion = "Descipción: Delicioso pollo apanado con la receta de la abuela, acompañado de ensalada primavera  (lechuga, tomate, aceitunas) y una porción de papás a la francesa";
                    String bebida = "Bebida: Jugo de mora";
                    String postre = "Postre: Tres leches";
                    Intent i = new Intent(this, VerPlatoActivity.class);
                    i.putExtra("nombre", nombre);
                    i.putExtra("descrip", descripcion);
                    i.putExtra("bebida", bebida);
                    i.putExtra("postre", postre);
                    startActivity(i);
                }
        );
        menuDosBtn.setOnClickListener(
                (v) -> {
                    restaurarAlphaDeImagenes();
                    String nombre = "plato";
                    String descripcion = "Descipción:  si";
                    String bebida = "Bebida: awa de uwu";
                    String postre = "Postre: xd";
                    Intent i = new Intent(this, VerPlatoActivity.class);
                    i.putExtra("nombre", nombre);
                    i.putExtra("descrip", descripcion);
                    i.putExtra("bebida", bebida);
                    i.putExtra("postre", postre);
                    startActivity(i);
                }
        );
        /*`menuTresBtn.setOnClickListener(
                (v) -> {
                    restaurarAlphaDeImagenes();
                    menuTresBtn.setAlpha(0.2f);
                    Intent i = new Intent(this, VerPlatoActivity.class);
                    startActivity(i);
                }
        );
        menuCuatroBtn.setOnClickListener(
                (v) -> {
                    restaurarAlphaDeImagenes();
                    menuCuatroBtn.setAlpha(0.2f);
                    Intent i = new Intent(this, VerPlatoActivity.class);
                    startActivity(i);
                }
        );
        menuCincoBtn.setOnClickListener(
                (v) -> {
                    restaurarAlphaDeImagenes();
                    menuCincoBtn.setAlpha(0.2f);
                    Intent i = new Intent(this, VerPlatoActivity.class);
                    startActivity(i);
                }
        );
        menuSeisBtn.setOnClickListener(
                (v) -> {
                    restaurarAlphaDeImagenes();
                    menuSeisBtn.setAlpha(0.2f);
                    Intent i = new Intent(this, VerPlatoActivity.class);
                    startActivity(i);
                }
        );*/


    }

    public void restaurarAlphaDeImagenes() {

        menuUnoBtn.setAlpha(1f);
        menuDosBtn.setAlpha(1f);
        menuTresBtn.setAlpha(1f);
        menuCuatroBtn.setAlpha(1f);
        menuCincoBtn.setAlpha(1f);
        menuSeisBtn.setAlpha(1f);


    }
}

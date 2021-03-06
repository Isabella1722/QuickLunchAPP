package com.example.quicklunchapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.quicklunchapp.model.Plato;
import com.example.quicklunchapp.model.Ticket;
import com.example.quicklunchapp.model.Usuario;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class VerPlatoActivity extends AppCompatActivity {

    private TextView nombreET;
    private ImageView imagenPlato;
    private TextView descripcionET;
    private TextView bebidaET;
    private TextView postreET;
    private EditText comentariosET;
    private Plato plato;
    private Button pedirBtn;
    private Usuario usuario;

    @SuppressLint({"ClickableViewAccessibility"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_plato);

        // Obtener los views
        nombreET = findViewById(R.id.nombreET);
        imagenPlato = findViewById(R.id.imagenQr);
        descripcionET = findViewById(R.id.descripcionET);
        bebidaET = findViewById(R.id.bebidaET);
        postreET = findViewById(R.id.postreET);
        comentariosET = findViewById(R.id.comentariosET);
        pedirBtn = findViewById(R.id.pedirBtn);

        // Traer plato de la actividad anterior
        plato = (Plato) getIntent().getExtras().getSerializable("plato");
        usuario = (Usuario) getIntent().getExtras().getSerializable("usuario");

        // Obtener datos del plato
        String idPlato = plato.getId();
        String nombre = plato.getNombre();
        String descripcion = plato.getDescripcion();
        String bebida = plato.getBebida();
        String postre = plato.getPostre();
        String url = plato.getUrl();

        // Asignar texto a los textView
        nombreET.setText(nombre);
        descripcionET.setText("Descripción: " + descripcion);
        bebidaET.setText("Bebida: " + bebida);
        postreET.setText("Postre: " + postre);

        // Cambiar imagen dependiendo del plato
        switch (url) {
            case "1":
                imagenPlato.setImageResource(R.drawable.descripuno);
                break;
            case "2":
                imagenPlato.setImageResource(R.drawable.desdos);
                break;
            case "3":
                imagenPlato.setImageResource(R.drawable.destres);
                break;
            case "4":
                imagenPlato.setImageResource(R.drawable.descuatro);
                break;
            case "5":
                imagenPlato.setImageResource(R.drawable.descinco);
                break;
            case "6":
                imagenPlato.setImageResource(R.drawable.deseis);
                break;
        }

        pedirBtn.setOnTouchListener(
                (v, event) -> {
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN:
                            // Cambiar color del boton al presionarlo
                            v.setBackgroundResource(R.drawable.focus_input);
                            break;

                        case MotionEvent.ACTION_MOVE:

                            break;

                        case MotionEvent.ACTION_UP:
                            // Restaurar color del boton al soltarlo
                            v.setBackgroundResource(R.drawable.rounded_input);

                            long rightnow = Calendar.getInstance().getTime().getTime();

                            // Crear ticket del pedido
                            Ticket ticket = new Ticket(usuario.getCodigo(), usuario.getId(), idPlato, usuario.getNombre(), usuario.getCodigo(),
                                    nombre, descripcion, bebida, postre, comentariosET.getText().toString(), "En espera", rightnow);


                            // Agregar pedido a firebase
                            FirebaseDatabase.getInstance().getReference().child("pedidos").child(ticket.getId()).setValue(ticket);

                            SharedPreferences localStorage = PreferenceManager.getDefaultSharedPreferences(VerPlatoActivity.this);
                            localStorage.edit().putString("userdocumento", usuario.getDocumentoIdentidad()).
                                    putString("userclave", usuario.getClave()).putString("userticket", ticket.getId()).apply();

                            Intent i = new Intent(this, VerTicketActivity.class);

                            // Pasar datos del plato y del ticket a la siguiente actividad
                            i.putExtra("ticket", ticket);

                            // Cerrar actividades anteriores
                            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

                            startActivity(i);
                            break;
                    }
                    return true;
                }
        );
    }
}

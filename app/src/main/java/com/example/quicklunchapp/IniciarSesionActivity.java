package com.example.quicklunchapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class IniciarSesionActivity extends AppCompatActivity {

    private EditText documentoET;
    private EditText claveET;
    private Button iniciarBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_sesion);

        documentoET= findViewById(R.id.documentoET);
        claveET= findViewById(R.id.claveET);
        iniciarBtn= findViewById(R.id.iniciarBtn);


        iniciarBtn.setOnClickListener(
                (v)->{
                    Intent i = new Intent(this, MenuActivity.class);
                    startActivity(i);
                }
        );
    }

    public void onStart(){
        super.onStart();

        documentoET.setOnFocusChangeListener( new View.OnFocusChangeListener(){
            public void onFocusChange( View view, boolean hasfocus){
                if(hasfocus){
                    view.setBackgroundResource( R.drawable.focus_input);
                }
                else{
                    view.setBackgroundResource( R.drawable.rounded_input);
                }
            }
        });

        claveET.setOnFocusChangeListener( new View.OnFocusChangeListener(){
            public void onFocusChange( View view, boolean hasfocus){
                if(hasfocus){
                    view.setBackgroundResource( R.drawable.focus_input);
                }
                else{
                    view.setBackgroundResource( R.drawable.rounded_input);
                }
            }
        });
    }
}

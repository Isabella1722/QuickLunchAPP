package com.example.quicklunchapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.style.TtsSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegistroActivity extends AppCompatActivity {


    private EditText nombreET;
    private EditText codigoET;
    private EditText documentoET;
    private EditText claveUnoET;
    private EditText claveDosET;
    private Button registrarseBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        nombreET= findViewById(R.id.nombreET);
        codigoET= findViewById(R.id.codigoET);
        documentoET= findViewById(R.id.documentoET);
        claveUnoET= findViewById(R.id.claveUnoET);
        claveDosET= findViewById(R.id.claveDosET);
        registrarseBtn= findViewById(R.id.registrarseBtn);


        registrarseBtn.setOnClickListener(
                (v)->{
                    Intent i = new Intent(this, MenuActivity.class);
                    startActivity(i);
                }
        );
    }

    public void onStart(){
        super.onStart();

        nombreET.setOnFocusChangeListener( new View.OnFocusChangeListener(){
            public void onFocusChange( View view, boolean hasfocus){
                if(hasfocus){
                    view.setBackgroundResource( R.drawable.focus_input);
                }
                else{
                    view.setBackgroundResource( R.drawable.rounded_input);
                }
            }
        });

        codigoET.setOnFocusChangeListener( new View.OnFocusChangeListener(){
            public void onFocusChange( View view, boolean hasfocus){
                if(hasfocus){
                    view.setBackgroundResource( R.drawable.focus_input);
                }
                else{
                    view.setBackgroundResource( R.drawable.rounded_input);
                }
            }
        });

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

        claveUnoET.setOnFocusChangeListener( new View.OnFocusChangeListener(){
            public void onFocusChange( View view, boolean hasfocus){
                if(hasfocus){
                    view.setBackgroundResource( R.drawable.focus_input);
                }
                else{
                    view.setBackgroundResource( R.drawable.rounded_input);
                }
            }
        });

        claveDosET.setOnFocusChangeListener( new View.OnFocusChangeListener(){
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

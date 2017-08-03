package com.seas.santader.mapas5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.net.Uri;
import android.widget.Button;
import android.view.View;
import android.content.Intent;
import android.widget.TextView;

public class ContactActivity extends AppCompatActivity {
   Button b_telefono;
    Button btnHome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);


        //boton llamada

        //Obtenemos una referencia a los controles de la interfaz
        final Button b_telefono = (Button)findViewById(R.id.b_telefono);
        //Implementamos el evento “click” del botón
        b_telefono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(android.content.Intent.ACTION_DIAL,
                        Uri.parse("tel:+615095996")); //
                startActivity(i);
            }

        });
        //boton llamada




    }



}

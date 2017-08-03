package com.seas.santader.mapas5;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Register extends AppCompatActivity
{
    EditText etName,etsaldo,etUsername,etPassword;
    Button bRegister;
    Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        etName=(EditText)findViewById(R.id.etName);
        etsaldo=(EditText)findViewById(R.id.etsaldo);
        etUsername=(EditText)findViewById(R.id.etUsername);
        etPassword=(EditText)findViewById(R.id.etPassword);
        bRegister=(Button)findViewById(R.id.bRegister);
        btn2=(Button)findViewById(R.id.btn2);


        //boton mapas

        //Obtenemos una referencia a los controles de la interfaz
        final Button btn2 = (Button)findViewById(R.id.btn2);
        //Implementamos el evento “click” del botón
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(Register.this, MapsActivity.class);
                startActivity(intent);
            }

        });
        //boton mapas




    }
    public void onClickRegister(View view)
    {
        String name     = etName.getText().toString();
        int saldo         = Integer.parseInt(etsaldo.getText().toString());
        String username = etUsername.getText().toString();
        String password = etPassword.getText().toString();
        User user       =new User(name,saldo,username,password);
        registerUser(user);
    }

    public void registerUser(User user)
    {
        ServerRequest serverRequest=new ServerRequest(this);
        serverRequest.storeUserDataInBackground(user, new GetUserCallback() {
            @Override
            public void done(User user) {
                Intent intent=new Intent(getApplicationContext(),Login.class);
                startActivity(intent);
            }
        });
    }
}
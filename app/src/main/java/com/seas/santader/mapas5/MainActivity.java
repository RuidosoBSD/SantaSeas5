package com.seas.santader.mapas5;

        import android.content.Intent;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.view.View;
        import android.widget.Button;
        import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    UserLocalStore userLocalStore;
    Button bLogout;
    Button btn2;
    TextView tvName,tvsaldo,tvUsername,tvPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bLogout         =(Button)findViewById(R.id.bLogout);
        btn2            =(Button)findViewById(R.id.btn2);
        tvName          =(TextView)findViewById(R.id.tvName);
        tvsaldo           =(TextView)findViewById(R.id.tvsaldo);
        tvUsername      =(TextView)findViewById(R.id.tvUsername);
        tvPassword      =(TextView)findViewById(R.id.tvPassword);
        userLocalStore  =new UserLocalStore(this);
        isLoggedIn(userLocalStore);


        //boton mapas

        //Obtenemos una referencia a los controles de la interfaz
        final Button btn2 = (Button)findViewById(R.id.btn2);
        //Implementamos el evento “click” del botón
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(MainActivity.this, MapsActivity.class);
                startActivity(intent);
            }

        });
        //boton mapas




           }
    public void isLoggedIn(UserLocalStore userLocalStore)
    {
        if(userLocalStore.getUserLoggedIn())
        {
            User user=userLocalStore.getLoggedInUser();
            tvName.setText(user.name);
            tvsaldo.setText(Integer.toString(user.saldo));
            tvUsername.setText(user.username);
            tvPassword.setText(user.password);

        }
        else
        {
            Intent intent=new Intent(getApplicationContext(),Login.class);
            startActivity(intent);
        }
    }
    public void onClickLogout(View view)
    {
        userLocalStore.setUserLoggedIn(false);
        userLocalStore.clearUserData();
        Intent intent=new Intent(getApplicationContext(),Login.class);
        startActivity(intent);
    }





}

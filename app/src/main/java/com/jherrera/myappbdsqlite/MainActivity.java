package com.jherrera.myappbdsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClic(View view) {
        Intent intent;
        switch (view.getId()){
            case R.id.btnInsertar:
                intent = new Intent(getApplicationContext(),MainActivityInsertar.class);
                startActivity(intent);
                break;
            case R.id.btnBuscar:
                intent = new Intent(getApplicationContext(),MainActivityBuscar.class);
                startActivity(intent);
                break;
            case R.id.btnMostrar:
                intent = new Intent(getApplicationContext(),MainActivityMostrar.class);
                startActivity(intent);
                break;
            case R.id.btnActualizar:
                intent = new Intent(getApplicationContext(),MainActivityActualizar.class);
                startActivity(intent);
                break;
            case R.id.btnEliminar:
                intent = new Intent(getApplicationContext(),MainActivityEliminar.class);
                startActivity(intent);
                break;
        }
    }
}
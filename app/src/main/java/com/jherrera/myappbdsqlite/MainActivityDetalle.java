package com.jherrera.myappbdsqlite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

public class MainActivityDetalle extends AppCompatActivity {
    private Fragment fragment;
    private String id,nombre,raza,color,edad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_detalle);
        fragment = new DetalleFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.contenedorID,fragment).commit();
        this.obtenerDatos();
        this.trasladarInformacion();
    }
    private void obtenerDatos(){
        Bundle bundle = getIntent().getExtras();
        id = bundle.getString("id");
        nombre = bundle.getString("nombre");
        raza = bundle.getString("raza");
        color = bundle.getString("color");
        edad = bundle.getString("edad");
    }

    private void trasladarInformacion(){
        Bundle bundle = new Bundle();
        bundle.putString("id",id);
        bundle.putString("nombre",nombre);
        bundle.putString("raza",raza);
        bundle.putString("color",color);
        bundle.putString("edad",edad);
        fragment.setArguments(bundle);

    }
}
package com.jherrera.myappbdsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.jherrera.myappbdsqlite.complementos.ConstantesSQL;
import com.jherrera.myappbdsqlite.complementos.MascotaVO;

import java.util.ArrayList;

public class MainActivityMostrar extends AppCompatActivity {
    private ListView listView;
    //arreglos
    //para llenar la lisata y el otro obtener los datos d ela base de datos
    private ArrayList<String> listaDatos;
    private ArrayList<MascotaVO> listaMascotas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_mostrar);
        listView = findViewById(R.id.listaMostrar);

        this.mostrarMascota();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                trasladoInformacion(position);
            }
        });

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,listaDatos);
        listView.setAdapter(arrayAdapter);
    }

    private void mostrarMascota(){
        ConectorSQLite conectorSQLite = new ConectorSQLite(this, ConstantesSQL.BD_MASCOTA,null,ConstantesSQL.VERSION);
        SQLiteDatabase database = conectorSQLite.getReadableDatabase();
        try {
            MascotaVO mascotaVO;
            listaMascotas = new ArrayList<>();
            String consultaCompleta;
            consultaCompleta = "SELECT * FROM "+ConstantesSQL.TABLA_MASCOTA+";";
            Cursor cursor = database.rawQuery(consultaCompleta,null);
            //llenado de las variables VO
            while(cursor.moveToNext()){
                mascotaVO = new MascotaVO();
                mascotaVO.setIdMascota(cursor.getInt(0));
                mascotaVO.setNombreMascota(cursor.getString(1));
                mascotaVO.setRazaMascota(cursor.getString(2));
                mascotaVO.setColorMascota(cursor.getString(3));
                mascotaVO.setEdadMascota(cursor.getInt(4));

                listaMascotas.add(mascotaVO);
            }
            listaDatos = new ArrayList<>();
            for (int i = 0;i<listaMascotas.size();i++){
                listaDatos.add(listaMascotas.get(i).getIdMascota()+". "+listaMascotas.get(i).getNombreMascota());
            }

        }catch (Exception e){
            e.getMessage();
        }

    }
    private void trasladoInformacion(int position){
        String idM,nombreM,razaM,colorM,edadM;
        idM = String.valueOf(listaMascotas.get(position).getIdMascota());
        nombreM = listaMascotas.get(position).getNombreMascota();
        razaM = listaMascotas.get(position).getRazaMascota();
        colorM = listaMascotas.get(position).getColorMascota();
        edadM = String.valueOf(listaMascotas.get(position).getEdadMascota());

        Intent intent = new Intent(getApplicationContext(),MainActivityDetalle.class);
        intent.putExtra("id",idM);
        intent.putExtra("nombre",nombreM);
        intent.putExtra("raza",razaM);
        intent.putExtra("color",colorM);
        intent.putExtra("edad",edadM);
        startActivity(intent);
    }










}
package com.jherrera.myappbdsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.jherrera.myappbdsqlite.complementos.ConstantesSQL;

public class MainActivityInsertar extends AppCompatActivity {
    private EditText editTextNombre,editTextRaza,editTextColor,editTextEdad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_insertar);
        editTextNombre = findViewById(R.id.edtNombreMascota);
        editTextRaza = findViewById(R.id.edtRazaMascota);
        editTextColor = findViewById(R.id.edtColorMascota);
        editTextEdad = findViewById(R.id.edtEdadMascota);
    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btninsertarMascota:
                this.insertarMascota();
                break;
        }
    }

    private void insertarMascota(){
        if (!editTextNombre.getText().toString().isEmpty() &&
                !editTextRaza.getText().toString().isEmpty() &&
                !editTextColor.getText().toString().isEmpty() &&
                !editTextEdad.getText().toString().isEmpty()){
            //realizar la conceicon por medio del objeto conector
            ConectorSQLite conectorSQLite = new ConectorSQLite(this, ConstantesSQL.BD_MASCOTA,null,ConstantesSQL.VERSION);
            //instaciamos el objeto de base de datos para establecer lo que se va a realizar continuacion en la base de datos
            SQLiteDatabase database = conectorSQLite.getWritableDatabase();
            //creacion del query para la insercion de los daots
            try {
                String consultaInsertar;
                consultaInsertar = "INSERT INTO "+ConstantesSQL.TABLA_MASCOTA + " ("+ConstantesSQL.CAMPO_NOMBRE+", "+
                        ConstantesSQL.CAMPO_RAZA+", "+ConstantesSQL.CAMPO_COLOR+", "+ConstantesSQL.CAMPO_EDAD+
                        ") VALUES ('"+editTextNombre.getText().toString()+"', '"+editTextRaza.getText().toString()+
                        "', '"+editTextColor.getText().toString()+"', "+editTextEdad.getText().toString()+");";
                //accion de la consulta
                database.execSQL(consultaInsertar);
                database.close();
                editTextNombre.setText("");
                editTextRaza.setText("");
                editTextColor.setText("");
                editTextEdad.setText("");

                Toast.makeText(this, "Datos ingresados Correctos", Toast.LENGTH_SHORT).show();
            }catch (Exception e){
                e.getMessage();
            }
        }else{
            Toast.makeText(this, "Debe de llenar todos los campos", Toast.LENGTH_SHORT).show();
        }
    }
}
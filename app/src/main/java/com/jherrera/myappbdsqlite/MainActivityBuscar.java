package com.jherrera.myappbdsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.jherrera.myappbdsqlite.complementos.ConstantesSQL;

public class MainActivityBuscar extends AppCompatActivity {
    private EditText editTextID;
    private TextView textViewNombre,textViewRaza,textViewColor,textViewEdad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_buscar);
        editTextID = findViewById(R.id.edtBuscarMascota);
        textViewNombre = findViewById(R.id.txtNombreBuscar);
        textViewRaza = findViewById(R.id.txtRazaBuscar);
        textViewColor = findViewById(R.id.txtColorBuscar);
        textViewEdad = findViewById(R.id.txtEdadBuscar);

    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnBuscarMascota:
                this.buscarMascota();
                break;
        }
    }
    private void buscarMascota(){
        ConectorSQLite conectorSQLite = new ConectorSQLite(this, ConstantesSQL.BD_MASCOTA, null, ConstantesSQL.VERSION);
        SQLiteDatabase database = conectorSQLite.getReadableDatabase();
        String[] parametro = {editTextID.getText().toString()};
        if (!editTextID.getText().toString().isEmpty()){
            //consulta por id
            try {
                String consultaID;
                consultaID = "SELECT " + ConstantesSQL.CAMPO_NOMBRE + ", " + ConstantesSQL.CAMPO_RAZA + ", " + ConstantesSQL.CAMPO_COLOR + ", " +
                        ConstantesSQL.CAMPO_EDAD + " FROM " + ConstantesSQL.TABLA_MASCOTA + " WHERE " + ConstantesSQL.CAMPO_ID + " =?;";
                //Objeto que permite obtener datos de la consulta de la bd
                Cursor cursor = database.rawQuery(consultaID, parametro);
                cursor.moveToFirst();
                textViewNombre.setText(cursor.getString(0));
                textViewRaza.setText(cursor.getString(1));
                textViewColor.setText(cursor.getString(2));
                textViewEdad.setText(cursor.getString(3));
            }catch (Exception e){
                e.getMessage();
                Toast.makeText(this, "Datos no encontrados", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "debe de llenar el campo", Toast.LENGTH_SHORT).show();
        }
    }
}
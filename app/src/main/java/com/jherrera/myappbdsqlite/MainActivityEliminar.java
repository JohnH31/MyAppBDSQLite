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

public class MainActivityEliminar extends AppCompatActivity {
    private EditText editTextID;
    private TextView textViewNombre,textViewRaza,textViewColor,textViewEdad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_eliminar);
        editTextID = findViewById(R.id.edtBuscarEliminarMascota);
        textViewNombre = findViewById(R.id.txtNombreEliminar);
        textViewRaza = findViewById(R.id.txtRazaEliminar);
        textViewColor = findViewById(R.id.txtColorEliminar);
        textViewEdad = findViewById(R.id.txtEdadEliminar);

    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnBuscarEliminarMascota:
                this.consultarID();
                break;
            case R.id.EliminarMascota:
                this.eliminarMascota();
                break;
        }
    }
    private void consultarID(){
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
                Toast.makeText(this, "Dato no encontrado", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "debe de llenar el campo", Toast.LENGTH_SHORT).show();
        }
    }
    private void eliminarMascota(){
        if (!editTextID.getText().toString().isEmpty()){
            ConectorSQLite conectorSQLite = new ConectorSQLite(this, ConstantesSQL.BD_MASCOTA, null, ConstantesSQL.VERSION);
            SQLiteDatabase database = conectorSQLite.getWritableDatabase();
            try {
                String consultaEliminar;
                consultaEliminar = "DELETE FROM "+ConstantesSQL.TABLA_MASCOTA+" WHERE "+ConstantesSQL.CAMPO_ID+"= "+
                        editTextID.getText().toString()+";";
                database.execSQL(consultaEliminar);
                database.close();
                editTextID.setText("");
                textViewNombre.setText("");
                textViewRaza.setText("");
                textViewColor.setText("");
                textViewEdad.setText("");
                Toast.makeText(this, "Se ha eliminado la mascota", Toast.LENGTH_SHORT).show();
            }catch (Exception e){
                e.getMessage();
            }

        }else{
            Toast.makeText(this, "Debe ingresear datos", Toast.LENGTH_SHORT).show();
        }
    }
}
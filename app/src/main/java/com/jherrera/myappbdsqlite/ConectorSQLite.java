package com.jherrera.myappbdsqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.jherrera.myappbdsqlite.complementos.ConstantesSQL;

public class ConectorSQLite extends SQLiteOpenHelper {

    public ConectorSQLite(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //crear la tabla
        db.execSQL(ConstantesSQL.CREAR_TABLA_MASCOTA);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //borrar la tabla si ya existe
        db.execSQL(ConstantesSQL.BORRAR_TABLA);
        onCreate(db);

    }
}

package com.jherrera.myappbdsqlite.complementos;

public class ConstantesSQL {

    public static final String BD_MASCOTA = "bd_mascota";

    public static final String TABLA_MASCOTA = "tbl_mascota";

    public static final String CAMPO_ID = "id_mascota";
    public static final String CAMPO_NOMBRE = "nombre_mascota";
    public static final String CAMPO_RAZA = "raza_mascota";
    public static final String CAMPO_COLOR = "color_mascota";
    public static final String CAMPO_EDAD = "edad_mascota";

    public static final String CREAR_TABLA_MASCOTA = "CREATE TABLE "+TABLA_MASCOTA+
            " ("+CAMPO_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+CAMPO_NOMBRE+" TEXT NOT NULL,"+
            CAMPO_RAZA+" TEXT NOT NULL, "+CAMPO_COLOR+" TEXT NOT NULL, "+CAMPO_EDAD+" INTEGER NOT NULL);";

    public static final String BORRAR_TABLA = "DROP TABLE IF EXISTS "+TABLA_MASCOTA;

    public static final int VERSION = 1;
}

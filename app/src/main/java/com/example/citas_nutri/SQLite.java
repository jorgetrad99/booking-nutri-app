package com.example.citas_nutri;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class UsuarioSQLiteHelper extends SQLiteOpenHelper {
    //Sentencia SQL para crear la tabla de Datos Generales
    String sqlCreate1Registrar = "CREATE TABLE DatoGeneral (icodigo INTEGER PRIMARY KEY, tnombre TEXT, tapellidoP TEXT, tapellidoM TEXT, tCorreo TEXT, tContra TEXT)";
    String sqlCreate1Ingresar = "CREATE TABLE DatoGeneral2 (icodigo INTEGER  PRIMARY KEY AUTOINCREMENT, tCorreo TEXT, tContra TEXT)";


    public UsuarioSQLiteHelper(Context contexto, String nombre, SQLiteDatabase.CursorFactory factory, Integer version)
    {
        super(contexto,nombre,factory,version);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Se ejecuta la sentencia SQL de creación de la tabla
        db.execSQL(sqlCreate1Registrar);
        db.execSQL(sqlCreate1Ingresar);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        //NOTA: Por simplicidad del ejemplo aquí utilizamos directamente la opción de
        //      eliminar la tabla anterior y crearla de nuevo vacía con el nuevo formato.
        //      Sin embargo lo normal será que haya que migrar datos de la tabla antigua
        //      a la nueva, por lo que este método debería ser más elaborado.
        //Se crea la nueva versión de la tabla

        db.execSQL(sqlCreate1Registrar);
        db.execSQL(sqlCreate1Ingresar);

        //Se elimina la versión anterior de la tabla
        db.execSQL("DROP TABLE IF EXISTS DatoGeneral");
        db.execSQL("DROP TABLE IF EXISTS DatoGeneral2");



    }

}

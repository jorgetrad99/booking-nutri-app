package com.example.citas_nutri;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Ingresar extends AppCompatActivity {
    private EditText Correo;
    private EditText contra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresar);
        Correo = (EditText) findViewById(R.id.edtCorre);
        contra = (EditText) findViewById(R.id.edtContraseña);

    }

    public void Ingre(View view) {

        String clave = Correo.getText().toString();
        String sContra = contra.getText().toString();



//Verificando que los campos tengan dato
        if (clave.length() > 0 && sContra.length() > 0) {
            UsuarioSQLiteHelper usuario = new UsuarioSQLiteHelper(this, "dbPrincipal", null, 1);
            SQLiteDatabase db = usuario.getWritableDatabase();

            Cursor fila = db.rawQuery("SELECT * FROM DatoGeneral WHERE iCodigo = " + clave, null);
            if (fila.moveToFirst()) {
                Correo.setError("Existe registro con el RFC proporcionado");
            } else {
                db.execSQL("INSERT INTO DatoGeneral (icodigo,tnombre,tapellidoP,tapellidoM,tCorreo,tContra) VALUES ('" + clave + sContra + "')");
                db.close();
                Toast.makeText(this, "Los datos generales se han registrado", Toast.LENGTH_SHORT).show();

                Correo.setText("");
                contra.setText("");

                Intent i = new Intent(this, Ingresa_Usua.class);
                startActivity(i);
            }
        } else {
            Toast.makeText(this, "Ingrese todos los datos generales", Toast.LENGTH_SHORT).show();
        }


}


}

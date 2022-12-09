package com.example.citas_nutri;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Registrar extends AppCompatActivity {
    private EditText nombre;
    private EditText apellido1;
    private EditText apellido2;
    private EditText telef;
    private EditText Correo;
    private EditText contra;
    private Button registrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        nombre = (EditText) findViewById(R.id.edtxtNombre);
        apellido1 = (EditText) findViewById(R.id.edtxtApellidoP);
        apellido2 = (EditText) findViewById(R.id.edtxtApellidoM);
        telef = (EditText) findViewById(R.id.edtxtTele);
        Correo = (EditText) findViewById(R.id.edtxtCorreo);
        contra = (EditText) findViewById(R.id.edtxtContra);
        registrar = (Button) findViewById(R.id.button);

    }

    public void Regis(View view) {

        String clave = telef.getText().toString();
        String snombre = nombre.getText().toString();
        String sapellidoP = apellido1.getText().toString();
        String sapellidoM = apellido2.getText().toString();
        String sCorreo = Correo.getText().toString();
        String sContra = contra.getText().toString();



//Verificando que los campos tengan dato
        if (clave.length() > 0 && snombre.length() > 0 && sapellidoP.length() > 0 && sapellidoM.length() > 0 && sCorreo.length() > 0 && sContra.length() > 0) {
            UsuarioSQLiteHelper usuario = new UsuarioSQLiteHelper(this, "dbPrincipal", null, 1);
            SQLiteDatabase db = usuario.getWritableDatabase();

            Cursor fila = db.rawQuery("SELECT * FROM DatoGeneral WHERE iCodigo = " + clave, null);
            if (fila.moveToFirst()) {
                telef.setError("Existe registro con el RFC proporcionado");
            } else {
                db.execSQL("INSERT INTO DatoGeneral (icodigo,tnombre,tapellidoP,tapellidoM,tCorreo,tContra) VALUES ('" + clave + "', '" + snombre + "','" + sapellidoP + "','" + sapellidoM + "','" + sCorreo + "' ,'" + sContra + "')");
                db.close();
                Toast.makeText(this, "Los datos generales se han registrado", Toast.LENGTH_SHORT).show();
                telef.setText("");
                nombre.setText("");
                apellido1.setText("");
                apellido2.setText("");
                Correo.setText("");
                contra.setText("");
            }
        } else {
            Toast.makeText(this, "Ingrese todos los datos generales", Toast.LENGTH_SHORT).show();
        }


    }

    public boolean onCreateOptionsMenu(Menu menu){
        //Se asigna el menu al activity correspondiente
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected (MenuItem item){
        //Se valida el icono seleccionado del menú
        switch (item.getItemId()){
            case android.R.id.home:
                this.finish();
                return true;
            case R.id.txtRegis:
                Intent i = new Intent(this, Registrar.class);
                startActivity(i);
            case R.id.txtIngresa:
                Intent e = new Intent(this, Ingresar.class);
                startActivity(e);
            case R.id.txtIngresaUsu:
                Intent o = new Intent(this, Ingresa_Usua.class);
                startActivity(o);
            case R.id.txtIngresaNutri:
                Intent s = new Intent(this, IngresaNutri.class);
                startActivity(s);
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }

}
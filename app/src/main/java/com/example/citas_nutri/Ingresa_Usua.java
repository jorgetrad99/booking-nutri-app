package com.example.citas_nutri;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Ingresa_Usua extends AppCompatActivity {
    private EditText Fecha;
    private EditText Hora;
    private Button Ingresa;
    int nOption;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresa_usua);
        Fecha =(EditText) findViewById(R.id.edtxFecha);
        Hora = (EditText) findViewById(R.id.edtxHora);
        Ingresa = (Button) findViewById(R.id.btnReserv);




    }
}
package com.example.citas_nutri;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void irAIngresar(View view) {
        Intent intent = new Intent(MainActivity.this, Ingresar.class);
        startActivity(intent);
    }

    public void irARegistrar(View view) {
        Intent intent = new Intent(MainActivity.this, Registrar.class);
        startActivity(intent);
    }
}
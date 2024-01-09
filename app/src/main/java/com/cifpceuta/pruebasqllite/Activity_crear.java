package com.cifpceuta.pruebasqllite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Activity_crear extends AppCompatActivity {

    EditText nombreUsu, paswordUsu;
    MyDbHelper manejador;

    SQLiteDatabase database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear);
        nombreUsu = findViewById(R.id.name);
        paswordUsu = findViewById(R.id.passw);
        manejador = new MyDbHelper(this);
        database = manejador.getWritableDatabase();
    }


    public void home(View view){

        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    public void registrarse(View view){
        ContentValues content = new ContentValues();
        content.put(AreaContract.AreaEntry.COLUMN_USUARIO,nombreUsu.getText().toString());
        content.put(AreaContract.AreaEntry.COLUMN_PASSW,paswordUsu.getText().toString());

        database.insert(AreaContract.AreaEntry.TABLE_NAME,null,content);

        startActivity(new Intent(this,Launcher.class));



    }

}
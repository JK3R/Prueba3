package com.csto.prueba3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {


    Button BTN_CONTAR,BTN_RESULTADO;
    RadioButton NULO,BLANCO,BORIC,KAST;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BTN_CONTAR = (Button) findViewById(R.id.button);
        BTN_RESULTADO = (Button) findViewById(R.id.button2);
        NULO =(RadioButton)findViewById(R.id.id_nulo);
        BORIC =(RadioButton)findViewById(R.id.id_Boric);
        KAST =(RadioButton)findViewById(R.id.id_Kast);
        ContentValues BD = new ContentValues();



        BTN_CONTAR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
                builder.setMessage("DESEA ELIMINAR")
                        .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                SQLiteDatabase DB;
                                DBHelper conn = new DBHelper(getApplicationContext());
                                DB = conn.getReadableDatabase();
                                DB.insert("Voto",null,bd);
                            }
                        })
                        .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // User cancelled the dialog
                            }
                        });
                // Create the AlertDialog object and return it
                builder.create();
                builder.show();


            }

            SQLiteDatabase BD;
            DBHelper conn =new DBHelper(getApplicationContext());


        });


        BTN_RESULTADO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(getApplicationContext(),Mostrar.class);
                I.putExtra("NULO","0");
                I.putExtra("BLANCO","0");
                I.putExtra("BORIC","0");
                I.putExtra("KAST","0");
                startActivity(I);
            }
        });
    }
}
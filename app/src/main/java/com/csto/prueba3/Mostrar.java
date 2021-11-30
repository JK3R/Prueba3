package com.csto.prueba3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Mostrar extends AppCompatActivity {

    TextView TV_BLANCO, TV_NULO,TV_BORIC,TV_KAST;
    Button BTN_VOLVER;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);
        TV_BLANCO = (TextView) findViewById(R.id.id_blancoM);
        TV_NULO = (TextView) findViewById(R.id.id_NuloM);
        TV_BORIC = (TextView) findViewById(R.id.Id_BoricM);
        TV_KAST = (TextView) findViewById(R.id.id_KastM);

        BTN_VOLVER = (Button) findViewById(R.id.button4);

        Integer TotalBLanco=0, TotalNulo=0, TotalBoric=0, TotalKast=0;


        SQLiteDatabase db;
        DBHelper conn = new DBHelper(getApplicationContext());
        db= conn.getReadableDatabase();
        Cursor C =db.query("censo",null,null,null,null,null,null);
        if(C!=null)
        {
            if(C.moveToFirst())
            {
                do{
                    if(C.getString(2).equals("N"))
                    {

                        TotalNulo++; //incrementar
                    }
                    if(C.getString(2).equals("B"))
                    {

                        TotalBoric++; //incrementar
                    }
                    if(C.getString(2).equals("K"))
                    {

                        TotalKast++; //incrementar
                    }
                    else
                    {

                        TotalBLanco++; //incrementar
                    }
                }
                while(C.moveToNext());
            }

        }
        TV_BLANCO.setText(""+TotalBLanco);
        TV_NULO.setText(""+TotalNulo);
        TV_BORIC.setText(""+TotalBoric);
        TV_KAST.setText(""+TotalKast);


        BTN_VOLVER.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(I);
            }
        });

    }


}
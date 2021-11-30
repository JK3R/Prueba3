package com.csto.prueba3;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper{

    public  static String VOTOS_BD ="Voto.db";

    public static int Version_DB=1;
    public static String Tabla_Voto="create table Voto(id_voto integer primary key, voto_blanco integer not null, voto_nulo integer not null, voto_boric integer not null, voto_kast integer not null)";


    public DBHelper(Context context) {
        super(context, VOTOS_BD, null, Version_DB);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(Tabla_Voto);
       }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {


    }
}


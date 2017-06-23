package com.example.adolfo.sistema_m;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.view.View;
import android.widget.Toast;

/**
 * Created by adolfo on 14/06/17.
 */

public class data_base extends SQLiteOpenHelper {

   public  String sql="CREATE TABLE tienda(titulo TEXT,asunto TEXT);";


    public data_base(Context c, String name, SQLiteDatabase.CursorFactory cf, int version){
        super(c,name,cf,version);
        System.out.print("se creo base");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE tienda (titulo TEXT,asunto TEXT);");
        System.out.println("Se creo la base");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       db.execSQL("DROP TABLE IF EXISTS tienda");
       db.execSQL(sql);
    }
}

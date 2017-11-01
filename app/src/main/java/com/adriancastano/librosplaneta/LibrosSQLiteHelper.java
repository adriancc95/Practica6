package com.adriancastano.librosplaneta;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by adria on 25/10/2017.
 */

public class LibrosSQLiteHelper extends SQLiteOpenHelper {

    String sqlCreate = "CREATE TABLE libros(" +
            "id         TEXT," +
            "bookname       TEXT," +
            "autorname      TEXT," +
            "person      TEXT," +
            "phone      TEXT)";

    public LibrosSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS libros");
        db.execSQL(sqlCreate);
    }
}

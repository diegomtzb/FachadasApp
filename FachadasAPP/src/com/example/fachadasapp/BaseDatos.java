package com.example.fachadasapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class BaseDatos extends SQLiteOpenHelper {
	public BaseDatos(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
	}

	String sqlCreate = "CREATE TABLE Fachadas (direccion TEXT, autor TEXT)";

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(sqlCreate);
		System.out.print("Creado");
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS Fachadas");
		Log.i("Eliminado","Eliminado");
		db.execSQL(sqlCreate);
	}
}

package com.example.fachadasapp;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

public class FachadasControlador {
	static int tiempo = 2000;

	public FachadasControlador(){}
	
	public boolean insertarRegistro(Context context, String Direccion, String Autor){
		boolean estado = false;
		BaseDatos fach = new BaseDatos(context,"DBFachadas",null,1);
		SQLiteDatabase db = fach.getWritableDatabase();
		if(db != null){
			try{
				ContentValues nuevoRegistro = new ContentValues();
				nuevoRegistro.put("direccion", Direccion);
				nuevoRegistro.put("autor", Autor);
				db.insert("Fachadas", null, nuevoRegistro);
				Toast.makeText(context, "Fachada publicada", tiempo).show();
				estado = true;
			}catch(Exception e){
				estado = false;
				Toast.makeText(context, "Error al insertar", tiempo).show();
			}
		}
		return estado;
	}
	
	public ArrayList<Fachadas> listaFachadas(Context context){
		ArrayList<Fachadas> fachadas = new ArrayList<Fachadas>();
		
		BaseDatos bd = new BaseDatos(context, "DBFachadas",null,1);
		
		SQLiteDatabase db = bd.getReadableDatabase();
		
		if(db != null){
			try {
				Cursor c = db.rawQuery("SELECT * from Fachadas", null);
				if(c.moveToFirst()){
					do{
						Fachadas fachada = new Fachadas(c.getString(0), c.getString(1));
						fachadas.add(fachada);
					}while(c.moveToNext());
				}
				c.close();
				db.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	return fachadas;
	}
}

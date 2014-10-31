package com.example.fachadasapp;

import java.net.HttpURLConnection;
import java.net.URL;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Fachadas {
	private int id;
	private String direccion;
	private String autor;
	/*private String imagen;
	private Bitmap imagen_bmp;*/
	
	int nuevoId = (int) Math.random();
	
	public Fachadas(int nuevoId, String d, String a){
		this.id = (int) Math.random();
		this.direccion = d;
		this.autor = a;
	}
	
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	public int getId(int id){return id;}
	/*public void setImagen_ofertabmp(Bitmap imagen_ofertabmp) {
		this.imagen_bmp = imagen_bmp;
	}*/
	
	/*public void setImagen(String imagen) {
		String imagenHttpAdress = "http://"+imagen;
		URL imagenURL = null;
		try {
			imagenURL=new URL(imagenHttpAdress);
			HttpURLConnection connection = (HttpURLConnection) imagenURL.openConnection();
			connection.connect();
			this.imagen_bmp = BitmapFactory.decodeStream(connection.getInputStream());
			connection.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
}

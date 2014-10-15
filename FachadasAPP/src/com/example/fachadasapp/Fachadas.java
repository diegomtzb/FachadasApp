package com.example.fachadasapp;

public class Fachadas {
	private String direccion;
	private String autor;
	private String imagen;
	
	
	public Fachadas(String d, String a){
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
}

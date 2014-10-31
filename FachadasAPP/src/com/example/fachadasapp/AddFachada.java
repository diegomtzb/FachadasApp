package com.example.fachadasapp;

import com.example.controlador.Conexion;

import android.app.Activity;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddFachada extends Activity {
	EditText descripcion, autor;
	Button publicar, cancelar;
	Conexion conexion = new Conexion();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_fachada);
		descripcion = (EditText)findViewById(R.id.addDescripcion);
		autor 		= (EditText)findViewById(R.id.autor);
		publicar 	= (Button)findViewById(R.id.publicar);
		cancelar 	= (Button)findViewById(R.id.cancelar);
	}
	
	public void Cancelar(View v){
		this.finish(); 
	}
	
	public void Publicar (View v) {
		int id = (int)Math.random();
		String respuesta = conexion.ConexionPost("54.210.61.180:8080/documents",id,  descripcion.getText().toString(), autor.getText().toString());
		if(respuesta.equals("0")){
			Toast.makeText(this, "Error al insertar", Toast.LENGTH_SHORT).show();
		}else{
			Toast.makeText(this, "Insertado con exito", Toast.LENGTH_SHORT).show();
			descripcion.setText("");
			autor.setText("");
			descripcion.setFocusable(true);
		}
	}
	
}
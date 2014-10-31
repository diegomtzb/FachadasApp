package com.example.fachadasapp;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
import com.example.controlador.Conexion;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends Activity {
	/*JSONObject jsonObject;
	//Conexion conexion = new Conexion();
	ArrayList<Fachadas> fachadas = new ArrayList<Fachadas>();*/

	@Override
	protected void onResume() {
		super.onResume();
		//llenadoLista();

	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//llenadoLista();

	}

	/*protected int llenadoLista() {
		int dimension = 0;
    	String url = "http://54.210.61.180";
    	String respuesta = conexion.CrearConexion(url);
    	try {
			jsonObject = new JSONObject(respuesta);
			
			JSONArray misFachadas = jsonObject.getJSONArray("ofertas");
			dimension = misFachadas.length();
			if(dimension != 0){
				for(int i = 0; i< dimension;i++){
					JSONObject miFachada = misFachadas.getJSONObject(i);
					Fachadas fachada = new Fachadas(miFachada.getInt("id"), miFachada.getString("Descripcion"), miFachada.getString("Autor"));
					//fachada.setImagen(miFachada.getString("imagen"));
					fachadas.add(fachada);
				}
			}
		} catch (Exception e) {
			dimension = 0;
		}
    	return dimension;
	}*/

	public void login(View v) {
		Intent intent = new Intent(this, LoginActivity.class);
		startActivity(intent);
	}

	public void addfachada(View v) {
		Intent intent = new Intent(this, CamaraActivity.class);
		startActivity(intent);
	}

}
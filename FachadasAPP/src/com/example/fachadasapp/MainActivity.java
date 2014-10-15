package com.example.fachadasapp;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

	@Override
	protected void onResume() {
		super.onResume();
		llenadoLista();

	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		llenadoLista();

	}

	protected void llenadoLista() {
		BaseDatos db = new BaseDatos(this, "BDFachadas", null, 1);
		db.getWritableDatabase();
		FachadasControlador fachadaControlador = new FachadasControlador();
		ArrayList<Fachadas> listaFachadas = fachadaControlador
				.listaFachadas(this);
		if (listaFachadas.size() != 0) {
			FachadasAdapter adapter = new FachadasAdapter(this, listaFachadas);
			ListView lstFachadas = (ListView) findViewById(R.id.listaFachadas);
			lstFachadas.setAdapter(adapter);
		}
	}

	public void login(View v) {
		Intent intent = new Intent(this, LoginActivity.class);
		startActivity(intent);
	}

	public void addfachada(View v) {
		Intent intent = new Intent(this, AddFachada.class);
		startActivity(intent);
	}

}
package com.example.fachadasapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DetalleFachada extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fachadadetalle);
	}
	
public void login(View v){
	Intent intent = new Intent(this, LoginActivity.class);
	startActivity(intent);
}

public void addfachada(View v){
	Intent intent = new Intent(this, AddFachada.class);
	startActivity(intent);
}

}

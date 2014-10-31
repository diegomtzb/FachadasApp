package com.example.fachadasapp;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class FachadasAdapter extends BaseAdapter{
	private Activity activity;
	private ArrayList<Fachadas> fachadas;
	
	public FachadasAdapter (Activity a, ArrayList<Fachadas> lf){
		this.activity = a;
		this.fachadas = lf;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View vi = convertView;
		if(convertView == null){
			LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			vi = inflater.inflate(R.layout.fachadaitem, null);
		}
		
		Fachadas fachada = fachadas.get(position);
		
		TextView descripcion = (TextView) vi.findViewById(R.id.direccionitem);
		descripcion.setText(fachada.getDireccion());
		
		TextView autor = (TextView) vi.findViewById(R.id.autoritem);
		autor.setText(fachada.getAutor());
		
		return vi;
	}

	@Override
	public int getCount() {
		return fachadas.size();
	}

	@Override
	public Object getItem(int position) {
		return fachadas.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}
	

}


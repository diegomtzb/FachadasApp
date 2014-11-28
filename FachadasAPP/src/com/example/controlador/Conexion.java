package com.example.controlador;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class Conexion {
	public Conexion(){}
	
	public String CrearConexion(String url){
		String aux = "" ;
		HttpGet httpGet = new HttpGet(url);
		HttpClient httpClient = new DefaultHttpClient();
		try {
		HttpResponse response = (HttpResponse)httpClient.execute(httpGet);
		HttpEntity entity = response.getEntity();
		BufferedHttpEntity buffer = new BufferedHttpEntity(entity);
		InputStream inputStream = buffer.getContent();
		
		BufferedReader r = new BufferedReader(new InputStreamReader(inputStream));
		String line;
		while((line = r.readLine()) != null){
			aux += line;
		}
			r.close();
			inputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return aux;
	}
	
	public String ConexionPost (String url, String descripcion, String autor){
		String respuesta = "";
		try {
			HttpPost httpPost = new HttpPost(url);
			HttpClient httpClient = new DefaultHttpClient();
			List<NameValuePair> pairs = new ArrayList<NameValuePair>();
			pairs.add(new BasicNameValuePair("descripcion", descripcion));
			pairs.add(new BasicNameValuePair("autor", autor));
			httpPost.setEntity(new UrlEncodedFormEntity(pairs));
			HttpResponse response = httpClient.execute(httpPost);
			HttpEntity entity = response.getEntity();
			respuesta = EntityUtils.toString(entity);
		} catch (Exception e) {
			respuesta = "0";
		}
		return respuesta;
	}
}

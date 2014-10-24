package com.example.fachadasapp;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class Register extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		
		
		task.execute(runnable)
	}
	
	private class task extends AsyncTask<String, Void, Void>{

		@Override
		protected String doInBackground(String... arg0) {
			
			return null;
		}

		@Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
		}

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
		}
		
		
		
	}
	
	public void registrar(View v){
		/ Create a new HttpClient and Post Header
	    HttpClient httpclient = new DefaultHttpClient();
	    HttpPost httppost = new HttpPost("http://website.com/this.php");
	    Log.d("response", "WORKING");
	    try {

	        // Add your data
	        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
	        nameValuePairs.add(new BasicNameValuePair("IMEI", deviceid));
	        nameValuePairs.add(new BasicNameValuePair("LONGITUDE",Double.toString(pLat)));
	        nameValuePairs.add(new BasicNameValuePair("LATITUDE", Double.toString(pLong)));
	        nameValuePairs.add(new BasicNameValuePair("CREATED_AT", timeStamp));
	        httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

	        // Execute HTTP Post Request
	        HttpResponse response = httpclient.execute(httppost);

	        Log.d("response!!!!", "  " + response);

	    } catch (ClientProtocolException e) {
	        //Requirement Auto-generated catch block
	        Log.d("response", "nope" + e);
	    } catch (IOException e) {
	        Log.d("response", "nope" + e);
	        //Requirement Auto-generated catch block
	    }
	}
}

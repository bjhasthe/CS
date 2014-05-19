package com.qr.cs;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.qr.cs.R;


public class MainActivity extends ActionBarActivity  {

	
	private TextView formatTxt, contentTxt;
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//scanButton = (Button)findViewById(R.id.btn_scn);
	    formatTxt = (TextView)findViewById(R.id.scan_format);
	    contentTxt = (TextView)findViewById(R.id.scan_content);
	    
	    
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void scanNow(View view) {
		Log.d("test", "button works!"); 
		
		Intent intent = new Intent("com.google.zxing.client.android.SCAN"); 
		intent.putExtra("com.google.zxing.client.android.SCAN.SCAN_MODE", "QR_CODE_MODE"); 
		startActivityForResult(intent, 0);
		
		
	}
	
	public void onActivityResult(int requestCode, int resultCode, Intent intent){     
		if(requestCode == 0)     { 
			if(resultCode == RESULT_OK)         {
				String contents = intent.getStringExtra("SCAN_RESULT");  
				String format = intent.getStringExtra("SCAN_RESULT_FORMAT");              
				Log.i("xZing", "contents: "+contents+" format: "+format);
				
				formatTxt.setText(format);
				contentTxt.setText(contents);
				
				// Handle successful scan
			}                    
			else if(resultCode == RESULT_CANCELED)         {              	// Handle cancel             
				Log.i("xZing", "Cancelled");         
			}     
		} 
	}
		
}

	



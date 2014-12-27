package com.example.shundeud;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	//private TextView result;
	private EditText search;
	private RelativeLayout screen;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		search = (EditText) findViewById(R.id.search);
		screen=(RelativeLayout)findViewById(R.id.screen);
		Button btn1 = (Button)findViewById(R.id.button1);
        btn1.setOnClickListener(new Button.OnClickListener(){
        	public void onClick(View v){
        		Intent intent = new Intent();
        		intent.setClass(MainActivity.this,MListView.class);
        		MainActivity.this.startActivity(intent);
        	//	MainActivity.this.finish();
        	}
        });
		search.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				Intent intent=new Intent();
				intent.setClass(MainActivity.this, MListView.class);
				startActivity(intent);
				MainActivity.this.finish();
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO 自动生成的方法存根
		  if (v.getId() == R.id.screen) {
              InputMethodManager imm = (InputMethodManager)this.getSystemService(Context.INPUT_METHOD_SERVICE);  
              search.setCursorVisible(false);//失去光标
              imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
      }
		
	}
	
	boolean isToExit=false;
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {   
		
	     if (keyCode == KeyEvent.KEYCODE_BACK) {  
	         if(!isToExit) {  
	             isToExit= true;    
	             Toast.makeText(getApplicationContext(), R.string.isToExit, Toast.LENGTH_SHORT).show();  
	             new Handler().postDelayed(new Runnable(){  
	                 public void run(){  
	                    isToExit=false;
	                 }  
	             }, 2000);;  
	             return false;  
	         }  
	     }  
	   
	     return super.onKeyDown(keyCode, event);  
	 } 
}

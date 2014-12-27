package com.example.shundeud;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class ItemDir extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.itemdir);
//		Bundle bundle=this.getIntent().getExtras();
///		String name=bundle.getString("Name");
		TextView tv=(TextView)findViewById(R.id.itemresult);
		tv.setText(getIntent().getStringExtra("name"));
	}

}

package com.example.andexplll;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Starter extends Activity {
	
	EditText minput;
	Button proceed;
	int moo;
	String mooo;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_starter);
		
		minput=(EditText)findViewById(R.id.editText1);
		proceed=(Button)findViewById(R.id.button1);
		
		
		proceed.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				 mooo = minput.getText().toString();
				 moo = Integer.parseInt(mooo);
				Intent intobj =  new Intent(Starter.this,MainActivity.class);
				intobj.putExtra("emo", moo);
				startActivity(intobj);
				
				
			}
		});
		
		
	}

	
}

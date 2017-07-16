package com.example.andexplll;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AnsDisplay extends Activity {
	
	LinearLayout lans ;
	//double edans[] ;//= new double[]
	TextView tvans;
	String str;
	StringBuffer s= new StringBuffer();
	double ans[] ;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ans_display);
		tvans=(TextView)findViewById(R.id.textView1);
		/*lans = new LinearLayout(getApplicationContext());
		lans.setOrientation(LinearLayout.VERTICAL);
		lans.setBackgroundColor(Color.GRAY);
		setContentView(lans);
		lans.addView(tvans);*/
		ans= new double[20];
		Bundle bundObj = getIntent().getExtras();
		ans= bundObj.getDoubleArray("yo");
		
/*		//if(em!=0)
		edans = bundObj.getDoubleArray("bruno");
		
		*/
		
		/*StringBuffer sb = new StringBuffer();
		
		for(int i=0;i<em;i++){
			
			String s= "\n"+edans[i]+"\n";
			sb = (StringBuffer)sb.append(s);
			}
		tvans.setText(sb);*/
		
		
		//MainActivity obj = new MainActivity();
		// int em = obj.m;
		 //ans= new double[em];
		  //this.ans= obj.ans;
		 for(int i=0;i<ans.length;i++){
			 
			 str="   "+ans[i]+" "+"\n";
			 s=s.append(str);
			 
			 
		 }
		 tvans.setText(s.toString()); 
		
		
		
		
	}

	
}

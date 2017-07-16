package com.example.andexplll;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.inputmethodservice.InputMethodService.Insets;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.HorizontalScrollView;
import android.widget.GridLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Toast;
import android.text.InputType;
import android.view.*;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	GridLayout relLay ;
	LinearLayout linlay;
	Button kittu;
	int m;
	double coeffs[][] ;
	double vals[] ;
	EditText ed[][];
	double ans[];
	ScrollView scrv;
	int flagy = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  setContentView(R.layout.activity_main);
        
      //  scrv= new ScrollView(getApplicationContext());
      //  scrv=(ScrollView)findViewById(R.id.horizontalScrollView1);
        
        Bundle bundo = getIntent().getExtras();
        m= bundo.getInt("emo");
         coeffs= new double[m][m];
         vals= new double[m];
         ed= new EditText[m][m+1];
         ans= new double[m];
        
        LinearLayout linpapa = new LinearLayout(getApplicationContext());
        linpapa.setOrientation(LinearLayout.VERTICAL);
     //   linpapa= (LinearLayout)findViewById(R.id.linpa);
       // setContentView(linpapa);
        
        
        int flagForLinear=0;
        
        
        HorizontalScrollView sv = new HorizontalScrollView(this);
        sv.setHorizontalScrollBarEnabled(true);
        sv.setVerticalScrollBarEnabled(true);
        ScrollView vsv = new ScrollView(this);
        vsv.setVerticalScrollBarEnabled(true);
        vsv.setHorizontalScrollBarEnabled(true);
       
        //sv.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT));
       
        //RelativeLayout relLay = new RelativeLayout();
        relLay = new GridLayout(getApplicationContext());
        relLay.setRowCount(m+1);
        relLay.setColumnCount(m*2+1);
        
        
        Display disp = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        disp.getSize(size);
        int width = size.x;
        int height = size.y;
        
        GridLayout.LayoutParams param = new GridLayout.LayoutParams();
       // LayoutParams param = (LayoutParams) relLay.getLayoutParams();
        param.height= height;
        param.width= width; 
        relLay.setLayoutParams(param);
        
       /* ScrollView scv = new ScrollView(getApplicationContext());
        relLay.addView(scv);*/
       
        vsv.addView(sv);
        sv.addView(relLay);
        //linpapa.addView(relLay);
        
        this.setContentView(vsv); 
       

        for(int i = 0 ; i <= m ; i++){

            for(int j = 0 ; j < m+1 ; j++){
                if(i < m){
                	
                     ed[i][j] = new EditText(getApplicationContext());
                    ed[i][j].setInputType(InputType.TYPE_CLASS_PHONE);
                    ed[i][j].setWidth(70);
                    ed[i][j].setBackgroundColor(Color.LTGRAY);
                    ed[i][j].setTextColor(Color.BLACK);
                    
                    relLay.addView(ed[i][j]);

                    if(j != m){

                        if(j == m-1) {
                            TextView tv = new TextView(getApplicationContext());
                            tv.setText("X"+j+" = ");
                            tv.setTextColor(Color.BLACK);
                            tv.setBackgroundColor(Color.YELLOW);
                            relLay.addView(tv);

                        } //lbl[i][j] = new JLabel("X"+j+" = ");
                        else {
                            TextView tv = new TextView(getApplicationContext());
                            tv.setText("X"+j+" + ");
                            tv.setTextColor(Color.BLUE);
                            tv.setBackgroundColor(Color.GREEN);
                            relLay.addView(tv);
                            //lbl[i][j] = new JLabel("X" + j + " + ");
                        }

                    }
                }
                else{
                /*	if(flagForLinear==0){
                	linlay = new LinearLayout(getApplicationContext());
                	linlay.setOrientation(LinearLayout.HORIZONTAL);
                	linlay.setBackgroundColor(Color.BLACK);
                	relLay.addView(linlay);
                	flagForLinear=1;
                	}					*/
                    if(j == m){
                       /* Button bittu= new Button(getApplicationContext());
                        bittu.setText("B");
                        relLay.addView(bittu);*/
                    }
                      //  Window.add(button);
                    else if(j == 0){
                        kittu= new Button(getApplicationContext());
                        kittu.setText("Ans");
                        relLay.addView(kittu);
                        
                       /* Button bittu= new Button(getApplicationContext());
                        bittu.setText("New");
                        relLay.addView(bittu);*/
                    }
                       // Window.add(newx);
                    else {
                        TextView ta= new TextView(getApplicationContext());
                        ta.setText("");
                        ta.setBackgroundColor(Color.CYAN);
                        relLay.addView(ta);
                        //Window.add(new JLabel(""));
                        //Window.add(new JLabel(""));
                    } 

                }  

            }

        }
        
        linlay = new LinearLayout(getApplicationContext());
    	linlay.setOrientation(LinearLayout.HORIZONTAL);
    	linlay.setBackgroundColor(Color.BLACK);
    	LinearLayout.LayoutParams linparam = new LinearLayout.LayoutParams(300, 50);
        linlay.setLayoutParams(linparam);
    	linparam.setMarginStart(param.height);
    	linpapa.addView(linlay);
    	       
        
        
        
        kittu.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				flagy=0;
				 for(int i = 0 ; i < m ; i++){
					 
					 for(int j = 0 ; j < m+1 ; j++){
						 String temp = ed[i][j].getText().toString();
						 temp = temp.trim();
						 
						 if(temp.isEmpty()){
							 //JOptionPane.showMessageDialog(null, "Please do enter something in the boxes(0 for no coefff. or value)","ERRRRRRR",JOptionPane.ERROR_MESSAGE);}
						 Toast.makeText(getApplicationContext(), "Please enter all coeffs", Toast.LENGTH_LONG).show();
						 flagy=1;
						 break;
						 }else{
					     double trololol =0 ;
						 try{trololol=Double.parseDouble(temp);
						 
                         if(j < m){
							 
							 coeffs[i][j] = trololol;
						 }
						 else
							 vals[i] = trololol;//(double)Double.valueOf(trololol);
						 }catch(Exception e){
							 //JOptionPane.showMessageDialog(null,"Stop Entertaining and please enter a valid Value(decimal or integer)!!!!!","Damn you",JOptionPane.ERROR_MESSAGE);Window.dispose();};	 
							 Toast.makeText(getApplicationContext(), "y u no enter something sensible?", Toast.LENGTH_LONG).show();
						 
						 }
						}
					 }
					 
				 }
				
				//Toast.makeText(getApplicationContext(), " "+coeffs[1][1], Toast.LENGTH_LONG).show();
				
				if(flagy!=1){
				 ans = getValues(coeffs, vals);
				 //Toast.makeText(getApplicationContext(), " "+ans[0]+" "+ans[1]+" "+" ", Toast.LENGTH_LONG).show();
				
				 Intent answer = new Intent(MainActivity.this,AnsDisplay.class);
				 answer.putExtra("yo", ans);
				 startActivity(answer);
				 
				}
				 
			}
		});
        
        
        
    }
    
    
    
    
    
    public static double[] getValues(double[][]coeff,double[]values){
 	   
 	   int loal = values.length;
 	   double[]ans = new double[loal];
 	   double DETx = getDet(coeff);
 	   
 	   for(int i = 0 ; i < loal ; i++){
 		   
 		   double[][]Augmento = new double[loal][loal] ;
 		   for(int j = 0 ; j < loal ; j++){
 			   
 			   for(int k = 0 ; k < loal ; k++){
 				   
 				   if(k == i){
 					   Augmento[j][k] = values[j] ;
 				   }
 				   else
 					   Augmento[j][k] = coeff[j][k] ;
 				   
 			   }
 			   
 		   }
 		   	   ans[i] =  getDet(Augmento)/DETx ;
 	   }
 	   
 	  return ans ;
 	   
    }
    
    public static double getDet(double[][]a){
 	   
 	   double det = 0;
 	   int i = 0 ;
 	   int len = a.length;

 	   if(len == 1){

 		   return a[0][0];
 	   }
 	   else{
 	   for(int j = 0 ; j < len ; j++){

 		   double[][]cofact = new double[len-1][len-1];

 		   int ii =0 , jj ;

 		   for(int b = 0 ; b < len ; b++){
 			   
 			   if(b!=i){
 			   jj = 0; 
 			   
 			   for(int c = 0 ; c < len ;c++){
 				   
 				   if(c!=j){
 				   cofact[ii][jj] = a[b][c];
 				   
 				   jj++ ;
 				   }
 			   }
 			   ii++ ;
 			   }
 		   }
 		   det+=(a[i][j]*Math.pow(-1, i+j)*getDet(cofact));
 		   
 	   }
 	   
 	   return det ;
 	   }
 	   
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}


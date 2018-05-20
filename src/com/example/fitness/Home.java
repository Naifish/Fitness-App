package com.example.fitness;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.Toast;

public class Home extends Activity {
	
	ImageButton upperbody_btn,lowerbody_btn,findplan_btn,nutrition_btn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		
		upperbody_btn=(ImageButton)findViewById(R.id.home_imgbtn_upperbody);
		lowerbody_btn=(ImageButton)findViewById(R.id.home_imgbtn_lowerbody);
		findplan_btn=(ImageButton)findViewById(R.id.home_imgbtn_findplan);
		nutrition_btn=(ImageButton)findViewById(R.id.home_imgbtn_nutrition);
		
		upperbody_btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				//Toast.makeText(Home.this, "you have selected upperbody", Toast.LENGTH_SHORT).show();
				
				Intent gotoUpperbody=new Intent(Home.this,SubCat.class);
				gotoUpperbody.putExtra("cat_type", "upper");
				startActivity(gotoUpperbody);
				//finish();
				
			}
		});
		
		lowerbody_btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				//Toast.makeText(Home.this,"You have selected lowerbody", Toast.LENGTH_SHORT).show();
				
				Intent gotoLowerbody=new Intent(Home.this,SubCat.class);
				gotoLowerbody.putExtra("cat_type", "lower");
				startActivity(gotoLowerbody);
				//finish();
				
			}
		});
		
		findplan_btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				//Toast.makeText(Home.this,"You have selected find a plan", Toast.LENGTH_SHORT).show();
				
				Intent gotoFindplan=new Intent(Home.this,SubCat.class);
				gotoFindplan.putExtra("cat_type", "plan");
				startActivity(gotoFindplan);
				//finish();
			}
		});
		
		nutrition_btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				//Toast.makeText(Home.this,"You have selected Nutrition", Toast.LENGTH_SHORT).show();
				
				Intent gotoNutritions=new Intent(Home.this,SubCat.class);
				gotoNutritions.putExtra("cat_type", "nutrition");
				startActivity(gotoNutritions);
				//finish();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home, menu);
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
}

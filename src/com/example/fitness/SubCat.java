package com.example.fitness;


import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

public class SubCat extends Activity {
	
	ImageButton gobacktohome_btn;
	ListView subCat_listV;
	String[] subCat;
	String Category;
	public String title[];

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sub_cat);
		subCat_listV=(ListView)findViewById(R.id.subcat_LV_exercises);
		gobacktohome_btn=(ImageButton)findViewById(R.id.subcat_imgbtn_goback);
		
		//final String title[];
		
		Intent recieve=getIntent();
		Category = recieve.getStringExtra("cat_type");
		
		Resources res=SubCat.this.getResources();
		
		if(Category.equals("upper")){
			
			subCat_listV.setAdapter(new upperbody_Adapter(SubCat.this));
			title=res.getStringArray(R.array.upperbody_titles);
		}
		else if(Category.equals("lower"))
		{
			subCat_listV.setAdapter(new lowerbody_Adapter(SubCat.this));
			title=res.getStringArray(R.array.lowerbody_titles);
		}
		else if(Category.equals("plan"))
		{
			subCat_listV.setAdapter(new plan_Adapter(SubCat.this));
			title=res.getStringArray(R.array.plan_titles);
		}
		else if(Category.equals("nutrition"))
		{
			subCat_listV.setAdapter(new nutrition_Adapter(SubCat.this));
			title=res.getStringArray(R.array.nutrition_titles);
		}
		
		subCat_listV.setOnItemClickListener(new OnItemClickListener() {
			
			@Override
			public void onItemClick(AdapterView<?>parent,View view,int posi,long id)
			{
				//Toast.makeText(SubCat.this, "you have clicked "+title[posi], Toast.LENGTH_SHORT).show();
				
				Intent goForInfo=new Intent(SubCat.this,Complete_info.class);
				goForInfo.putExtra("category",Category);
				goForInfo.putExtra("title", title[posi]);
				startActivity(goForInfo);
			}
		});
		
		gobacktohome_btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent gohome=new Intent(SubCat.this,Home.class);
				startActivity(gohome);
				finish();
				
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sub_cat, menu);
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

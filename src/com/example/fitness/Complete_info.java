package com.example.fitness;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

public class Complete_info extends Activity {
	
	String category,title;
	VideoView myvideoView;
	MediaController myMediaControler;
	TextView title_TV,description_TV;
	ImageButton playvid_btn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_complete_info);
		
		title_TV=(TextView)findViewById(R.id.compinfo_TV_title);
		description_TV=(TextView)findViewById(R.id.compinfo_TV_description);
		playvid_btn=(ImageButton)findViewById(R.id.compinfo_IB_playvid);
		
		Intent inten2=getIntent();
		category = inten2.getStringExtra("category");
		title=inten2.getStringExtra("title");
		
		title_TV.setText(title);
		description_TV.setText("the description,title and image will fetch from the respectes table"
				+ "the description,title and image will fetch from the respectes table");
		
		Toast.makeText(Complete_info.this,"Category is "+category+" and Title is "+title, Toast.LENGTH_SHORT).show();
		
		myvideoView=(VideoView)findViewById(R.id.compinfo_LL_subcatVid);
		myMediaControler=new MediaController(this);
		myMediaControler.setAnchorView(myvideoView);
		String uriPath="android.resource://com.example.fitness/"+R.raw.wildlife;
		Uri myUri=Uri.parse(uriPath);
		myvideoView.setMediaController(myMediaControler);
		myvideoView.setVideoURI(myUri);
		
		playvid_btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				myvideoView.start();
			}
		});
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.complete_info, menu);
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

package com.example.fitness;

import java.util.ArrayList;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class nutrition_Adapter extends BaseAdapter {
	
	ArrayList<singleRow> mylist;
	Context _context;
	
	public nutrition_Adapter(Context c) {
		// TODO Auto-generated constructor stub
		
		_context=c;
		// TODO Auto-generated constructor stub
		mylist=new ArrayList<singleRow>();
		
		Resources res=c.getResources();
		
		String title[]=res.getStringArray(R.array.nutrition_titles);
		String description[]=res.getStringArray(R.array.nutrition_description);
		int[]image={R.drawable.nut1,R.drawable.nut2,R.drawable.nut3,R.drawable.nut4,R.drawable.nut5,R.drawable.nut6,R.drawable.nut7,R.drawable.nut8};
		
		for(int i=0;i<8;i++)
		{
			mylist.add(new singleRow(title[i], description[i], image[i]));
		}
		
		//1) get the titles, descriptions and images from xml
		//2) group each title, its related description and its related image in to a singleRow object
		//3) put the singleRow object inside the arraylist

	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mylist.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return mylist.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		// 1) get the root view
		//2) use the root view to find other view
		//3) set the valuse
				
		LayoutInflater inflater=(LayoutInflater) _context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View row=inflater.inflate(R.layout.single_row, parent, false);
		TextView title=(TextView)row.findViewById(R.id.textView1);
		TextView description=(TextView)row.findViewById(R.id.textView2);
		ImageView image=(ImageView)row.findViewById(R.id.imageView1);
				
		singleRow temp=mylist.get(position);
				
		title.setText(temp.title);
		description.setText(temp.description);
		image.setImageResource(temp.image);
		return row;  //return the root view to single_row.xml
	}

}

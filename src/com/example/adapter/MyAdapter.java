package com.example.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends ArrayAdapter<String>{
	
	Context mContext;
	List<String> msubjectNames;
	public MyAdapter(Context context, List<String> subjects) {
		super(context,R.layout.my_adapter,subjects);
		
		mContext = context;
		msubjectNames = subjects;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		
		if(convertView == null) {
			convertView = LayoutInflater.from(mContext).inflate(R.layout.my_adapter, null);
			holder = new ViewHolder();
			
			holder.mSubjectImage = (ImageView)convertView.findViewById(R.id.subjectImage);
			holder.mSubjectName = (TextView)convertView.findViewById(R.id.subjectName);
			convertView.setTag(holder);
		}
		else {
			holder = (ViewHolder)convertView.getTag();
		}
		
		holder.mSubjectName.setText(msubjectNames.get(position));
		holder.mSubjectImage.setImageResource(R.drawable.ic_launcher);
		
		
		return convertView;
	}
	
	
	
	private static class ViewHolder {
		ImageView mSubjectImage;
		TextView mSubjectName;
	}
}

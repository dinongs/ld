package com.example.shundeud;

import java.util.ArrayList;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MAdapter extends BaseAdapter {

	private LayoutInflater mInflater;
	private Context context;
	
	private ArrayList<String> DATA;
	private static final String Tag="MAdapter";
	private ListView parentView;
	private ListView parentView1;
	public MAdapter(Context context,ArrayList<String> DATA,ListView lv)
	{
		super();
		this.mInflater=LayoutInflater.from(context);
		this.context=context;
		this.DATA=DATA;
		this.parentView1=lv;
	}
	
	@Override
	public int getCount() {
		// TODO �Զ����ɵķ������
		return DATA.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO �Զ����ɵķ������
		return DATA.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO �Զ����ɵķ������
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO �Զ����ɵķ������
		ViewHolder holder;
		Log.d(Tag, "goin the view");
		if(convertView==null)
		{
			convertView=mInflater.inflate(R.layout.itemdir, null);
			holder=new ViewHolder();
			holder.editview=(TextView)convertView.findViewById(R.id.itemresult);
			convertView.setTag(holder);
		}else
		{
			holder=(ViewHolder)convertView.getTag();
		}
		holder.editview.setText(DATA.get(position));
		parentView=(ListView)convertView. findViewById(R.id.mlistview);
		final String text=DATA.get(position);
		holder.editview.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO �Զ����ɵķ������
				parentView1.setAdapter(new MListAdapter(context,text,"xx"));
			}
		});
		return convertView;
	}
   static class ViewHolder
   {
	   TextView editview;
	   ImageView icon;
   }
}

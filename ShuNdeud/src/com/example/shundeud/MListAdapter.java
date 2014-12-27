package com.example.shundeud;

import java.util.ArrayList;

import android.app.TaskStackBuilder;
import android.content.Context;
import android.os.Trace;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

public class MListAdapter extends BaseAdapter {
	
	private LayoutInflater mInflater;
	private String original;
	private String translate;
	private int Count;

	public MListAdapter(Context context,String original,String translate) {
		// TODO �Զ����ɵĹ��캯�����
		super();
		this.mInflater=LayoutInflater.from(context);
		this.original=original;
		this.translate=translate;
	}

	@Override
	public int getCount() {
		// TODO �Զ����ɵķ������
		return 1;
	}

	@Override
	public Object getItem(int position) {
		// TODO �Զ����ɵķ������
		return original;
	}

	@Override
	public long getItemId(int position) {
		// TODO �Զ����ɵķ������
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO �Զ����ɵķ������
		ViewHolder holder;
		if(convertView==null)
		{
			convertView=mInflater.inflate(R.layout.each_shou,null);
			holder=new ViewHolder();
			holder.original=(TextView)convertView.findViewById(R.id.original);
			holder.sound=(TextView)convertView.findViewById(R.id.sound);
			holder.translate=(TextView)convertView.findViewById(R.id.translate);
			convertView.setTag(holder);
		}
		else
		{
			holder=(ViewHolder)convertView.getTag();
		}
		holder.original.setText(this.original);
		holder.translate.setText(this.translate);
		holder.sound.setText("������");	
		holder.sound.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO �Զ����ɵķ������
				
			}
		});
		return convertView;
	}
	
	static class ViewHolder{
		TextView original;
		TextView translate;
		TextView sound;
	}

}

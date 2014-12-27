package com.example.shundeud;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;

import android.R.string;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MListView extends Activity {

	private TextView lsearch;
	private ListView mlistview;
	private Context ct;
	private ArrayList<String> arrayList = new ArrayList<String>();
	private ArrayList<String> original;
	private ArrayList<String> translate;
	private Map<String,String> resutl;


	ArrayList<String> list ;
	private final String DATABASE_PATH = "/data/data/com.example.shundeud/databases/";
	private final String DATABASE_FILENAME = "ndeud.db ";

	// private HashMap<int ,String> lmap;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listview);

		lsearch = (TextView) findViewById(R.id.lsearch);
		mlistview = (ListView) findViewById(R.id.mlistview);
		ct = this;
		lsearch.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO �Զ����ɵķ������

			}
		});
//		 if(Flag==0)
//			{
////		mlistview.setOnItemClickListener(new OnItemClickListener() {
////
////			@Override
////			public void onItemClick(AdapterView<?> parent, View view,
////					int position, long id) {
////				// TODO �Զ����ɵķ������
////           mlistview.setAdapter(new MListAdapter(ct, original
////						.get(position), translate.get(position)));
////				
////
////			}
////		});
//		Flag=1;
//			}

		lsearch.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO �Զ����ɵķ������

			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO �Զ����ɵķ������

			}

			@SuppressWarnings("unchecked")
			@Override
			public void afterTextChanged(Editable s) {
				// TODO �Զ����ɵķ������
				String str1 = s.toString();
				original = new ArrayList<String>();
				translate = new ArrayList<String>();
				if (!str1.equals("")) {
					// DatabaseHelper db = new DatabaseHelper(
					// getApplicationContext(), "Ndeud.db", null, 1);
					// DatabaseHelper db=openDatabasef();
					// if(db==null)
					// return ;
					int type = MyTool.getInputType(s.toString());
					SQLiteDatabase database = openDatabasef();
					String sqlx = "select * from Xongb Where Ndeudx like'" + s
							+ "%';";
					String sqlz = "select * from Xongb Where Ndeud like'%" + s
							+ "%';";
					Cursor c = null;
					c = database.rawQuery(sqlx, null);
					int t = c.getCount();
					if (t < 1)
						c = database.rawQuery(sqlz, null);
					int count = 0;
				list	= new ArrayList<String>();

					arrayList.removeAll(arrayList);
					
					while (c.moveToNext()) {
						String str = c.getString(c.getColumnIndex("Ndeud"));
						String str2 = str + "\r\n"
								+ c.getString(c.getColumnIndex("Ndeudx"));
						original.add(c.getString(c.getColumnIndex("Ndeudx")));
						translate.add(str);
						list.add(str2);
						arrayList.add(str2);
						if (++count > 100)
							break;
					}
					String str = "��ѯ�����\r\n";
					for (String string : list) {
						str += "\n" + string;
					}

					c.close();
					database.close();
					mlistview.setAdapter(new MAdapter(ct,list,mlistview));
				}else
				{
					mlistview.setAdapter(new MAdapter(ct,list,mlistview));
				}

			}
		});

	}

	private SQLiteDatabase openDatabasef() {
		try {
			// ���dictionary.db�ļ��ľ���·��
			String databaseFilename = DATABASE_PATH + DATABASE_FILENAME;
			File dir = new File(DATABASE_PATH);
			// ���/sdcard/dictionaryĿ¼�д��ڣ��������Ŀ¼
			if (!dir.exists())
				dir.mkdirs();
			// �����/sdcard/dictionaryĿ¼�в�����
			// dictionary.db�ļ������res/rawĿ¼�и�������ļ���
			// SD����Ŀ¼��/sdcard/dictionary��
			File dbfile = new File(databaseFilename);
			if (!(dbfile).exists()) {
				// ��÷�װdictionary.db�ļ���InputStream����
				InputStream is = getResources().openRawResource(R.raw.ndeud);
				dbfile.createNewFile();
				FileOutputStream fos = new FileOutputStream(databaseFilename);
				byte[] buffer = new byte[8192];
				int count = 0;
				// ��ʼ����dictionary.db�ļ�
				while ((count = is.read(buffer)) > 0) {
					fos.write(buffer, 0, count);
				}

				fos.close();
				is.close();
			}
			// ��/sdcard/dictionaryĿ¼�е�dictionary.db�ļ�
			Log.d("openDatabasef1", "eeeee");
			SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(
					databaseFilename, null);

			Log.d("openDatabasef-db", db == null ? "null" : "not null");
			return db;
		} catch (Exception e) {
			// Log.d("openDatabasef", e.getMessage());
		}
		return null;
	}
 
}

package com.example.shundeud;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
	
	DatabaseHelper(Context context,String name,CursorFactory cursorFactory,int version)
	{
		super(context,name,cursorFactory,version);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO �Զ����ɵķ������

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO �Զ����ɵķ������

	}
	
	@Override
	public void onOpen(SQLiteDatabase db){
		super.onOpen(db);
	}

}

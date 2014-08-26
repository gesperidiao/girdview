package com.example.dataservice;

import android.database.Cursor;


public class LazyInitialization<T> {
	Cursor query;
	int count;
	RelationalToObjectMapper<T> mapping;

	LazyInitialization(Cursor c, RelationalToObjectMapper<T> mapping) {
		this.query = c;
		this.mapping = mapping;
		
		query.moveToFirst();
	}
	
	public void first() {
		query.moveToFirst();
	}

	public int count() {
		return query.getCount();
	}

	public T build() {
		return mapping.build(query);
	}
	
	public boolean next() {
		return query.moveToNext();
	}

	public void setCursor(Cursor cur) {
		this.query = cur;
		count = query.getCount();
		query.moveToFirst();
	}

	public Cursor getCursor(){
		return this.query;
	}
}

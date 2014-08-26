package com.example.dataservice;

import android.database.Cursor;

public abstract class RelationalToObjectMapper <T> {

	public RelationalToObjectMapper() {
		// TODO Auto-generated constructor stub
	}

	public abstract T build(Cursor c);
	
}

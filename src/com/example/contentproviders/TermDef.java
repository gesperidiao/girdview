package com.example.contentproviders;

public class TermDef {
	  // Database table
	  public static final String TABLE_TERM = "term";
	  public static final String COLUMN_ID = "id";
	  public static final String COLUMN_WORD = "word"; 
	  public static final String COLUMN_CATEGORY = "category";

	  public static final String COLUMN_ROW_ID = "ROWID _id";

	  
	  public static String[] getAllColumns(){
		  return new String[]{
				  COLUMN_ID, COLUMN_WORD, COLUMN_CATEGORY, COLUMN_ROW_ID };
	  }
}

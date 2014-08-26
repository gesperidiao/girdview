package com.example.contentproviders;

public class SentenceDef {
	  // Database table
	  public static final String TABLE_SENTENCE = "sentence";
	  public static final String COLUMN_ID = "id";
	  public static final String COLUMN_lAST_USED = "last_used"; 
	  public static final String COLUMN_TYPE = "type";
	  public static final String COLUMN_ROW_ID = "ROWID _id";

	  
	  public static String[] getAllColumns(){
		  return new String[]{
				  COLUMN_ID, COLUMN_lAST_USED, COLUMN_TYPE, COLUMN_ROW_ID };
	  }
}

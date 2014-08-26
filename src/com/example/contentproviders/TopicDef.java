package com.example.contentproviders;

public class TopicDef {
	  // Database table
	  public static final String TABLE_TOPIC = "topic";
	  public static final String COLUMN_ID = "id";
	  public static final String COLUMN_DESCRIPTION = "description"; 
	  public static final String COLUMN_ROW_ID = "ROWID _id";

	  
	  public static String[] getAllColumns(){
		  return new String[]{
				  COLUMN_ID, COLUMN_DESCRIPTION, COLUMN_ROW_ID };
	  }
}

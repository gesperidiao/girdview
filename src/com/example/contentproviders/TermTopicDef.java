package com.example.contentproviders;

public class TermTopicDef {
	  public static final String TABLE_TERM_TOPIC = "term_topic";
	  public static final String COLUMN_ID = "id";
	  public static final String COLUMN_TERM_ID = "term_id"; 
	  public static final String COLUMN_TOPIC_ID = "topic_id";
	  public static final String COLUMN_ROW_ID = "ROWID _id";


	  
	  public static String[] getAllColumns(){
		  return new String[]{
				  COLUMN_ID, COLUMN_TERM_ID,COLUMN_TOPIC_ID, COLUMN_ROW_ID };
	  }
}

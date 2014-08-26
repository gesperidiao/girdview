package com.example.contentproviders;

public class SymbolDef {
	  // Database table
	  public static final String TABLE_SYMBOL = "symbol";
	  public static final String COLUMN_ID = "id";
	  public static final String COLUMN_TYPE = "type"; 
	  public static final String COLUMN_TERM_ID = "term_id";
	  public static final String COLUMN_PICTOGRAM_ID = "pictogram_id";
	  public static final String COLUMN_ROW_ID = "ROWID _id";

	  
	  public static String[] getAllColumns(){
		  return new String[]{
				  COLUMN_ID, COLUMN_TYPE, COLUMN_TERM_ID, COLUMN_PICTOGRAM_ID,  COLUMN_ROW_ID };
	  }
}

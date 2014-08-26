package com.example.contentproviders;

public class PictogramDef {
	  // Database table
	  public static final String TABLE_PICTOGRAM = "pictogram";
	  public static final String COLUMN_ID = "id";
	  public static final String COLUMN_PICTURE = "picture"; 
	  public static final String COLUMN_ROW_ID = "ROWID _id";

	  
	  public static String[] getAllColumns(){
		  return new String[]{
				  COLUMN_ID, COLUMN_PICTURE, COLUMN_ROW_ID };
	  }
}

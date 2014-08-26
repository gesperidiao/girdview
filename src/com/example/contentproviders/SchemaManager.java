package com.example.contentproviders;

import com.example.models.Term;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class SchemaManager extends SQLiteOpenHelper {

	static final String TAG = "SchemaManager";

	private static final int CURRENT_DB_VERSION = 1;

	public static final String DATABASE_NAME = "alohaDB";
	public static final String FTS_VIRTUAL_TABLE = "AlohaDB2014";

	/*
	 * These fields are used for syncing purpose
	 */
	public static final String LOCAL_OWNER = "local_owner";
	public static final String GLOBAL_OWNER = "global_owner";
	private static final String OWNER_COLUMNS_DEF = String.format(
			" %s TEXT, %s TEXT ", LOCAL_OWNER, GLOBAL_OWNER);

	public SchemaManager(Context context) {
		super(context, DATABASE_NAME, null, CURRENT_DB_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// System.out.println("Creating Database");
		try {
			db.execSQL("CREATE TABLE " + PictogramDef.TABLE_PICTOGRAM + " ("
					+ PictogramDef.COLUMN_ID + " TEXT NOT NULL PRIMARY KEY, "
					+ PictogramDef.COLUMN_PICTURE + " TEXT NOT NULL, "
					+ OWNER_COLUMNS_DEF + " )");

			db.execSQL("CREATE TABLE " + TermDef.TABLE_TERM + " ("
					+ TermDef.COLUMN_ID + " TEXT NOT NULL PRIMARY KEY, "
					+ TermDef.COLUMN_CATEGORY + " INTEGER NOT NULL, "
					+ TermDef.COLUMN_WORD + " TEXT NOT NULL, "
					+ OWNER_COLUMNS_DEF + " )");
			
			
			db.execSQL("CREATE TABLE " + TopicDef.TABLE_TOPIC + " ("
					+ TopicDef.COLUMN_ID + " TEXT NOT NULL PRIMARY KEY, "
					+ TopicDef.COLUMN_DESCRIPTION + " TEXT NOT NULL, "
					+ OWNER_COLUMNS_DEF + " )");

			db.execSQL("CREATE TABLE " + TermTopicDef.TABLE_TERM_TOPIC + " ("
					+ TermTopicDef.COLUMN_ID + " TEXT NOT NULL PRIMARY KEY, "
					+ TermTopicDef.COLUMN_TERM_ID + " TEXT NOT NULL, "
					+ TermTopicDef.COLUMN_TOPIC_ID + " TEXT NOT NULL, "
					+ OWNER_COLUMNS_DEF + " )");

			db.execSQL("CREATE TABLE " + SymbolDef.TABLE_SYMBOL + " ("
					+ SymbolDef.COLUMN_ID + " TEXT NOT NULL PRIMARY KEY, "
					+ SymbolDef.COLUMN_TYPE + " TEXT NOT NULL, "
					+ SymbolDef.COLUMN_TERM_ID + " TEXT NOT NULL, "
					+ SymbolDef.COLUMN_ROW_ID + " TEXT NOT NULL, "
					+ OWNER_COLUMNS_DEF + " )");

			//TODO Sentece
			
		} catch (SQLiteException e) {
			Log.v(TAG, "DataService exception in onCreate SQLite tables");
			throw e;
		}

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVer, int newVer) {

		// TODO: this should gracefully handle new database versions by copying
		// tables
		// current code will delete everything and recreate the table structure
		try {
			db.execSQL("DROP TABLE IF IT EXISTS " + PictogramDef.TABLE_PICTOGRAM);
			db.execSQL("DROP TABLE IF IT EXISTS " + SymbolDef.TABLE_SYMBOL);
			db.execSQL("DROP TABLE IF IT EXISTS " + TermDef.TABLE_TERM);
			db.execSQL("DROP TABLE IF IT EXISTS " + TermTopicDef.TABLE_TERM_TOPIC);
			db.execSQL("DROP TABLE IF IT EXISTS " + TopicDef.TABLE_TOPIC);

			onCreate(db);
		} catch (SQLiteException e) {
			Log.v(TAG, "DataService exception in onUpgrade SQLite tables");
			throw e;
		}
	}
}

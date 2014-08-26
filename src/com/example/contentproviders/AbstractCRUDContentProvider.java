package com.example.contentproviders;

import java.util.Arrays;
import java.util.HashSet;

import com.example.settings.AppSettings;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.util.Log;

/*import com.eyenetra.netrag.contentproviders.SchemaManager;
import com.eyenetra.netrag.contentproviders.AbstractCRUDContentProvider.ProviderProfile;
import com.eyenetra.netrag.server.Constants;
import com.eyenetra.netrag.settings.AppSettings;*/

public abstract class AbstractCRUDContentProvider extends ContentProvider {

	public static String TAG = "AbstractCRUDContentProvider";
	
	private AppSettings appSettings;
	
	static class ProviderProfile {
		public ProviderProfile(String basePath, String contentType, String contentItemType, 
				String tableName, String columnID, String[] allColumns) {
			super();
			this.basePath = basePath;
			this.contentType = contentType;
			this.contentItemType = contentItemType;
			this.tableName = tableName;
			this.columnID = columnID;
			this.allColumns = allColumns;
		}
		String basePath;
		String contentType;
		String contentItemType;
		String tableName;
		String columnID;
		String[] allColumns;
	}
	
	final UriMatcher sURIMatcher = new UriMatcher(UriMatcher.NO_MATCH);
	
	// Used for the UriMacher
	static final int LIST = 0;
	static final int ITEM_ID = 1;
	
	void addURIMatcher(String authority, ProviderProfile profile) {
		sURIMatcher.addURI(authority, profile.basePath, LIST);
		sURIMatcher.addURI(authority, profile.basePath + "/*", ITEM_ID);
	}
	
	// Database open/upgrade helper
	public SchemaManager db;
	
	abstract ProviderProfile profile(Uri uri);
	
	public int type(Uri uri) {
		int uriType = sURIMatcher.match(uri);
		//Log.i("CRUD Type", uri.toString() + " " + uriType);
		return uriType; 
	}
	
	@Override
	synchronized public int delete(Uri uri, String selection, String[] selectionArgs) {
		//System.out.println("Delete Start");
		
		SQLiteDatabase sqlDB = db.getWritableDatabase();
		int rowsDeleted = 0;
		
		ProviderProfile profile = profile(uri);
		
		switch (type(uri)) {
			case LIST:
				rowsDeleted = sqlDB.delete(profile.tableName, selection, selectionArgs);
				break;
			case ITEM_ID:
				String id = uri.getLastPathSegment();
				if (selection == null || selection.isEmpty()) {
					rowsDeleted = sqlDB.delete(profile.tableName, profile.columnID + " = ? ", new String[] { id });
			} else {
				String[] idPrependedSelectionArgs = new String[selectionArgs.length + 1];
				idPrependedSelectionArgs[0] = id;
				System.arraycopy(selectionArgs, 0, idPrependedSelectionArgs, 1, selectionArgs.length);

				rowsDeleted = sqlDB.delete(profile.tableName, profile.columnID + " = ? and " + selection,
						idPrependedSelectionArgs);
			}
				break;
			default:
				throw new IllegalArgumentException("Unknown URI: " + uri);
		}
		
		//System.out.println("Delete Result: " + rowsDeleted);
		
		getContext().getContentResolver().notifyChange(uri, null, true);
		return rowsDeleted;
	}

	@Override
	public String getType(Uri uri) {
		ProviderProfile profile = profile(uri);
		switch (type(uri)) {
		case LIST:
			return profile.contentType;
		case ITEM_ID:
			return profile.contentItemType;
		default:
			throw new IllegalArgumentException("Unsupported URI: " + uri);
		}
	}

	@Override
	synchronized public Uri insert(Uri uri, ContentValues values) {
		//System.out.println("Insert Start");
		//Log.i("Insert", uri.toString());
		ProviderProfile profile = profile(uri);
		
		SQLiteDatabase sqlDB = db.getWritableDatabase();
		
		String localOwner = ""; //TODO appSettings.getLoggedInUsername();
		String globalOwner = ""; //TODO getCloudId(appSettings.getLoggedInUsername());
		values.put("local_owner", localOwner);
		values.put("global_owner", globalOwner);
		
		long rowId = sqlDB.insert(profile.tableName, null, values);
		
		if (rowId != -1) {
			getContext().getContentResolver().notifyChange(uri, null, true);
			// System.out.println("Insert Result: " + id);
			return Uri.parse(profile.basePath + "/" + values.getAsString(profile.columnID));
		} else {
			return null;
		}
	}

	@Override
	synchronized public boolean onCreate() {
		db = new SchemaManager(this.getContext());
		appSettings = new AppSettings(this.getContext());
		
		return false;
	}
	
	synchronized public boolean onCreate(SchemaManager database) {
		db = database;
		return false;
	}

	@Override
	synchronized public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs,
			String sortOrder) {
		ProviderProfile profile = profile(uri);
		
		Log.i(TAG, "Query: " + uri.toString());
		
		// Check if the caller has requested a column which does not exists
		checkColumns(uri, projection);

		SQLiteDatabase sqlDB = db.getWritableDatabase();
		
		Cursor cursor;
		if (type(uri) == ITEM_ID) {
			String id = uri.getLastPathSegment();
			if (selection == null || selection.isEmpty()) {
				cursor = sqlDB.query(profile.tableName, projection, profile.columnID + " = ? ", new String[] { id }, null, null, sortOrder);
			} else {
				String[] idPrependedSelectionArgs = new String[selectionArgs.length + 1];
				idPrependedSelectionArgs[0] = id;
				System.arraycopy(selectionArgs, 0, idPrependedSelectionArgs, 1, selectionArgs.length);

				cursor = sqlDB.query(profile.tableName, projection, profile.columnID + " = ? and " + selection,
						idPrependedSelectionArgs, null, null, sortOrder);
			}
		} else {
			cursor = sqlDB.query(profile.tableName, projection, selection, selectionArgs, null, null, sortOrder);
		}
		
		// Make sure that potential listeners are getting notified
		cursor.setNotificationUri(getContext().getContentResolver(), uri);
		
		return cursor;
	}

	@Override
	synchronized public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
		//System.out.println("Update Start");
		ProviderProfile profile = profile(uri);
		
		SQLiteDatabase sqlDB = db.getWritableDatabase();
		int rowsUpdated = 0;
		switch (type(uri)) {
		case LIST:
			rowsUpdated = sqlDB.update(profile.tableName, values, selection, selectionArgs);
			break;
		case ITEM_ID:
			String id = uri.getLastPathSegment();
			if (selection == null || selection.isEmpty()) {
				rowsUpdated = sqlDB.update(profile.tableName, values, profile.columnID + " = ? ", new String[] { id });
			} else {
				String[] idPrependedSelectionArgs = new String[selectionArgs.length + 1];
				idPrependedSelectionArgs[0] = id;
				System.arraycopy(selectionArgs, 0, idPrependedSelectionArgs, 1, selectionArgs.length);

				rowsUpdated = sqlDB.update(profile.tableName, values, profile.columnID + " = ? and " + selection,
						idPrependedSelectionArgs);
			}
			break;
		default:
			throw new IllegalArgumentException("Unknown URI: " + uri);
		}
		
		//System.out.println("Update Result: " +rowsUpdated);
		
		getContext().getContentResolver().notifyChange(uri, null, true);
		return rowsUpdated;
	}

	private void checkColumns(Uri uri, String[] projection) {
		String[] available = profile(uri).allColumns;
		if (projection != null) {
			HashSet<String> requestedColumns = new HashSet<String>(Arrays.asList(projection));
			HashSet<String> availableColumns = new HashSet<String>(Arrays.asList(available));
			// Check if all columns which are requested are available
			
			requestedColumns.removeAll(availableColumns);
			
			if (!requestedColumns.isEmpty()) { 
				throw new IllegalArgumentException(
					"Unknown columns in projection " + hashSetToString(requestedColumns) + "Available columns are: " + hashSetToString(availableColumns));
					}
		}
	}
	
	private String hashSetToString(HashSet<String> set) {
		StringBuilder str = new StringBuilder();
		for (String s : set) {
			str.append(s + ", ");
		}
		return str.toString();
	}

}

package com.example.settings;

import android.content.Context;

public class AppSettings {
	   public static String getSETTING_LOGGED_IN_USER_ID() {
		return SETTING_LOGGED_IN_USER_ID;
	}

	public static void setSETTING_LOGGED_IN_USER_ID(String sETTING_LOGGED_IN_USER_ID) {
		SETTING_LOGGED_IN_USER_ID = sETTING_LOGGED_IN_USER_ID;
	}

	public static String getSETTING_LOGGED_IN_USER_USERNAME() {
		return SETTING_LOGGED_IN_USER_USERNAME;
	}

	public static void setSETTING_LOGGED_IN_USER_USERNAME(
			String sETTING_LOGGED_IN_USER_USERNAME) {
		SETTING_LOGGED_IN_USER_USERNAME = sETTING_LOGGED_IN_USER_USERNAME;
	}

	public static String getSETTING_DEVICE_ID() {
		return SETTING_DEVICE_ID;
	}

	public static void setSETTING_DEVICE_ID(String sETTING_DEVICE_ID) {
		SETTING_DEVICE_ID = sETTING_DEVICE_ID;
	}

	public static String getSETTING_SCROLL_MODE() {
		return SETTING_SCROLL_MODE;
	}

	public static void setSETTING_SCROLL_MODE(String sETTING_SCROLL_MODE) {
		SETTING_SCROLL_MODE = sETTING_SCROLL_MODE;
	}

	private static String SETTING_LOGGED_IN_USER_ID = "account.id";
	    private static String SETTING_LOGGED_IN_USER_USERNAME = "account.username";

	    private static String SETTING_DEVICE_ID = "device.id";
	    private static String SETTING_SCROLL_MODE = "device.scroll_mode";

	    public AppSettings(Context context) {
	    }
}

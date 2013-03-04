package com.fastmanjohn.test;

import android.util.Log;

public class AppLogger {

	private static final boolean DEBUG = true;

	public static void debug(String tag, String msg) {
		if (DEBUG) {
			Log.d(tag, msg);
		}
	}

	public static void error(String tag, String msg) {
		Log.e(tag, msg);
	}

	public static void wornning(String tag, String msg) {
		if (DEBUG) {
			Log.w(tag, msg);
		}
	}

	public static void println(int priority, String tag, String msg) {
		Log.println(priority, tag, msg);
	}
}

package com.codelabs.java_developers.fundamentals;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.codelabs.java_developers.R;

public class Fundamentals011 extends AppCompatActivity {
	private static final String LOG_TAG = Fundamentals011.class.getSimpleName();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fundamentals011);

		Log.v("Fundamentals011", "Hello World"); // v: Verbose
		Log.d("Fundamentals011", "Hello World"); // d: Debug
		Log.i("Fundamentals011", "Hello World"); // i: Info
		Log.w("Fundamentals011", "Hello World"); // w: Warn
		Log.e("Fundamentals011", "Hello World"); // e: Error

		Log.v(LOG_TAG, "Hello World"); // v: Verbose
		Log.d(LOG_TAG, "Hello World"); // d: Debug
		Log.i(LOG_TAG, "Hello World"); // i: Info
		Log.w(LOG_TAG, "Hello World"); // w: Warn
		Log.e(LOG_TAG, "Hello World"); // e: Error
	}
}
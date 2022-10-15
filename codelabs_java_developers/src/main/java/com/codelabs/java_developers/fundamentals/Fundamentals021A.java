package com.codelabs.java_developers.fundamentals;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.codelabs.java_developers.R;

public class Fundamentals021A extends AppCompatActivity {
	private static final String LOG_TAG = Fundamentals021A.class.getSimpleName();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fundamentals021_a);
	}

	public void launchSecondActivity(View view) {
		Log.d(LOG_TAG, "Button clicked!");

		Intent intent = new Intent(this, Fundamentals021B.class);
		startActivity(intent);
	}
}
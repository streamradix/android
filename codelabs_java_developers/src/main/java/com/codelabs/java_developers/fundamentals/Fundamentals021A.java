package com.codelabs.java_developers.fundamentals;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.codelabs.java_developers.R;

public class Fundamentals021A extends AppCompatActivity {
	private static final String LOG_TAG = Fundamentals021A.class.getSimpleName();

	// set key to identify String value
	public static final String EXTRA_MESSAGE = "com.codelabs.java_developers.extra.MESSAGE";

	private EditText mMessageEditText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fundamentals021_a);

		mMessageEditText = findViewById(R.id.editText_main);
	}

	public void launchSecondActivity(View view) {
		Log.d(LOG_TAG, "Button clicked!");

		Intent intent = new Intent(this, Fundamentals021B.class);

		// get String from EditText
		String message = mMessageEditText.getText().toString();

		// put key-value data in Intent Extras
		intent.putExtra(EXTRA_MESSAGE, message);

		startActivity(intent);
	}
}
package com.codelabs.java_developers.fundamentals;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.codelabs.java_developers.R;

public class Fundamentals021B extends AppCompatActivity {
	private static final String LOG_TAG = Fundamentals021B.class.getSimpleName();

	// set key to identify String value
	public static final String EXTRA_REPLY = "com.codelabs.java_developers.extra.REPLY";

	private EditText mReply;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fundamentals021_b);

		// get Intent which starts this Activity
		Intent intent = getIntent();

		// receive String data in Intent Extra
		String message = intent.getStringExtra(Fundamentals021A.EXTRA_MESSAGE);

		TextView textView = findViewById(R.id.text_message);
		textView.setText(message);

		mReply = findViewById(R.id.editText_second);

		Log.d(LOG_TAG, "--- --- ---");
		Log.d(LOG_TAG, "onCreate");
	}

	@Override
	protected void onRestart() {
		super.onRestart();
		Log.d(LOG_TAG, "onRestart");
	}

	@Override
	protected void onStart() {
		super.onStart();
		Log.d(LOG_TAG, "onStart");
	}

	@Override
	protected void onResume() {
		super.onResume();
		Log.d(LOG_TAG, "onResume");
	}

	@Override
	protected void onPause() {
		super.onPause();
		Log.d(LOG_TAG, "onPause");
	}

	@Override
	protected void onStop() {
		super.onStop();
		Log.d(LOG_TAG, "onStop");
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.d(LOG_TAG, "onDestroy");
	}

	public void returnReply(View view) {
		// get text of the EditText as a String
		String reply = mReply.getText().toString();

		// create new Intent for response
		// don`t reuse the Intent object received from original request
		Intent replyIntent = new Intent();

		// add reply String to response Intent as an Intent Extra
		replyIntent.putExtra(EXTRA_REPLY, reply);

		// set the Result to RESULT_OK         to indicate that the response was successful
		// set the Result to RESULT_CANCELLED  to indicate that the response was unsuccessful
		// set the Result to RESULT_FIRST_USER for defining developer own result code
		setResult(RESULT_OK, replyIntent);

		// close Activity and return to Activity that requested this Activity
		finish();
	}
}
package com.codelabs.java_developers.fundamentals;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.codelabs.java_developers.R;

public class Fundamentals021A extends AppCompatActivity {
	private static final String LOG_TAG = Fundamentals021A.class.getSimpleName();

	// set key to identify String value
	public static final String EXTRA_MESSAGE = "com.codelabs.java_developers.extra.MESSAGE";

	private EditText mMessageEditText;

	// set key for a particular type of response
	public static final int TEXT_REQUEST = 1;

	private TextView mReplyHeadTextView;
	private TextView mReplyTextView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fundamentals021_a);

		mMessageEditText = findViewById(R.id.editText_main);

		mReplyHeadTextView = findViewById(R.id.text_header_reply);
		mReplyTextView = findViewById(R.id.text_message_reply);
	}

	public void launchSecondActivity(View view) {
		Log.d(LOG_TAG, "Button clicked!");

		Intent intent = new Intent(this, Fundamentals021B.class);

		// get String from EditText
		String message = mMessageEditText.getText().toString();

		// put key-value data in Intent Extras
		intent.putExtra(EXTRA_MESSAGE, message);

		startActivityForResult(intent, TEXT_REQUEST);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		// requestCode : set when launched the Activity with startActivityForResult()
		// resultCode  : set when launched this Activity (usually one of RESULT_OK or RESULT_CANCELED)
		// Intent data : contains the data returned from the launch Activity

		if (requestCode == TEXT_REQUEST) {
			if (resultCode == RESULT_OK) {
				if (data == null) return;
				String reply = data.getStringExtra(Fundamentals021B.EXTRA_REPLY);

				// set the visibility to true
				mReplyHeadTextView.setVisibility(View.VISIBLE);
				mReplyTextView.setVisibility(View.VISIBLE);

				// set Text to reply
				mReplyTextView.setText(reply);
			}
		}
	}
}
package com.codelabs.java_developers.fundamentals;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.codelabs.java_developers.R;

public class Fundamentals021A extends AppCompatActivity {
	private static final String LOG_TAG = Fundamentals021A.class.getSimpleName();

	// set key to identify String value
	public static final String EXTRA_MESSAGE = "com.codelabs.java_developers.extra.MESSAGE";

	private EditText mMessageEditText;

	private TextView mReplyHeadTextView;
	private TextView mReplyTextView;

	/**
	 * ActivityResult APIs replace startActivityForResult() and onActivityResult()
	 * - startActivityForResult() is deprecated
	 *
	 * ActivityResult APIs
	 * - implements from androidx.activity:activity:1.2.0-alpha02
	 * - implements from androidx.fragment:fragment:1.3.0-alpha02
	 *
	 * registerForActivityResult(Contract<I, O>, Callback<O>)
	 * - register ActivityResult
	 * - return Launcher
	 *
	 * ActivityResultContract<I, O> : contract specifying that Type I, Type O
	 * ActivityResultCallback<O>    : callback to be called when ActivityResult is available
	 * ActivityResultLauncher<I>    : launcher for prepared ActivityResult
	 *
	 * Type I : Launcher launch with Type I
	 * Type O : Callback called with Type O
	 */
	private ActivityResultLauncher<Intent> activityResultLauncher;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fundamentals021_a);

		mMessageEditText = findViewById(R.id.editText_main);

		mReplyHeadTextView = findViewById(R.id.text_header_reply);
		mReplyTextView = findViewById(R.id.text_message_reply);

		// registering ActivityResult
		activityResultLauncher = registerForActivityResult(
				new ActivityResultContracts.StartActivityForResult(),
				new ActivityResultCallback<ActivityResult>() {
					@Override
					public void onActivityResult(ActivityResult result) {
						Intent data = result.getData();

						if (result.getResultCode() == RESULT_OK) {
							if (data == null) return;

							String reply = data.getStringExtra(Fundamentals021B.EXTRA_REPLY);

							// set the visibility to true
							mReplyHeadTextView.setVisibility(View.VISIBLE);
							mReplyTextView.setVisibility(View.VISIBLE);

							// set Text to reply
							mReplyTextView.setText(reply);
						}
					}
				});
	}

	public void launchSecondActivity(View view) {
		Log.d(LOG_TAG, "Button clicked!");

		Intent intent = new Intent(this, Fundamentals021B.class);

		// get String from EditText
		String message = mMessageEditText.getText().toString();

		// put key-value data in Intent Extras
		intent.putExtra(EXTRA_MESSAGE, message);

		activityResultLauncher.launch(intent);
	}
}
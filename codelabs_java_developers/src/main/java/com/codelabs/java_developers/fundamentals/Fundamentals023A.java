package com.codelabs.java_developers.fundamentals;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import com.codelabs.java_developers.R;

public class Fundamentals023A extends AppCompatActivity {
	private EditText mWebsiteEditText;
	private EditText mLocationEditText;
	private EditText mShareTextEditText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fundamentals023_a);

		mWebsiteEditText = findViewById(R.id.website_edittext);
		mLocationEditText = findViewById(R.id.location_edittext);
		mShareTextEditText = findViewById(R.id.share_edittext);
	}

	public void openWebsite(View view) {
		// Get the URL text
		String url = mWebsiteEditText.getText().toString();

		// Parse the URI
		Uri webpage = Uri.parse(url);

		// Create Implicit Intent: new Intent(ACTION, data:uri)
		Intent intent = new Intent(Intent.ACTION_VIEW, webpage);

		// Find and activity to handle the intent and start that activity
		if (intent.resolveActivity(getPackageManager()) != null) {
			startActivity(intent);
		} else {
			Log.d("Implicit Intents", "Can`t handle this intent!");
		}
	}

	public void openLocation(View view) {
		// Get the string indicating a location
		// Input is not validated: it`s passed to the location handler intact
		String loc = mLocationEditText.getText().toString();

		// Parse the location
		Uri addressUri = Uri.parse("geo:0,0?q=" + loc);

		// Create Implicit Intent: new Intent(ACTION, data:uri)
		Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);

		// Find an activity to handle the intent and start that activity
		if (intent.resolveActivity(getPackageManager()) != null) {
			startActivity(intent);
		} else {
			Log.d("Implicit Intents", "Can`t handle this intent!");
		}
	}

	public void shareText(View view) {
		// Get the string to share
		String txt = mShareTextEditText.getText().toString();

		// MIME type of item to be shared
		String mimeType = "text/plain";

		// set ShareCompat.IntentBuilder and start chooser
		ShareCompat.IntentBuilder.from(this)
				.setChooserTitle(R.string.share_text_with)
				.setText(txt)
				.setType(mimeType)
				.startChooser();
	}
}
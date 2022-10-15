package com.codelabs.java_developers.fundamentals;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.codelabs.java_developers.R;

/**
 * Configure Intent filter in AndroidManifest.xml
 *
 * AndroidManifest.xml > application tag > activity tag > intent-filter tag
 * : Define Intent that Activity can handle
 *
 * Tags in intent-filter tag
 * - action   : only one,    purpose to handle intent
 * - category : one or more, filter category of intent
 * - data     : data specification (type, uri or both)
 *
 * Condition to receive Implicit Intent
 * - activity tag > exported: true
 * - activity tag > intent-filter tag > category tag: category.DEFAULT
 */

public class Fundamentals023B extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fundamentals023_b);

		// Get Intent that starts this Activity
		Intent intent = getIntent();

		// Get Intent Data
		// Intent data is always a URI object
		Uri uri = intent.getData();

		if (uri != null) {
			String uri_string = getString(R.string.uri_label, uri);
			TextView textView = findViewById(R.id.text_uri_message);
			textView.setText(uri_string);
		}
	}
}
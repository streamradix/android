package com.codelabs.java_developers.fundamentals;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.codelabs.java_developers.R;

public class Fundamentals021B extends AppCompatActivity {

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
	}
}
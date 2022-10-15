package com.codelabs.java_developers.fundamentals;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.codelabs.java_developers.R;

public class Fundamentals041B extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fundamentals041_b);

		Intent intent = getIntent();
		String message = intent.getStringExtra(Fundamentals041A.EXTRA_MESSAGE);

		TextView textView = findViewById(R.id.order_textview);
		textView.setText(message);
	}
}
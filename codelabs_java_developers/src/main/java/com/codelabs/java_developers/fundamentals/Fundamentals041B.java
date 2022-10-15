package com.codelabs.java_developers.fundamentals;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

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

	public void onRadioButtonClicked(View view) {
		// Is the button now checked?
		boolean checked = ((RadioButton) view).isChecked();

		// Check which radio button was clicked.
		switch (view.getId()) {
			case R.id.sameday:
				if (checked)
					// Same day service
					displayToast(getString(R.string.same_day_messenger_service));
				break;
			case R.id.nextday:
				if (checked)
					// Next day delivery
					displayToast(getString(R.string.next_day_ground_delivery));
				break;
			case R.id.pickup:
				if (checked)
					// Pick up
					displayToast(getString(R.string.pick_up));
				break;
			default:
				// Do nothing.
				break;
		}
	}

	private void displayToast(String message) {
		Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
	}
}
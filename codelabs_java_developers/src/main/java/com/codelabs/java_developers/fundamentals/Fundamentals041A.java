package com.codelabs.java_developers.fundamentals;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.codelabs.java_developers.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Fundamentals041A extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fundamentals041_a);

		FloatingActionButton fab = findViewById(R.id.fab);
		fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Fundamentals041A.this, Fundamentals041B.class);
				startActivity(intent);
			}
		});
	}

	/**
	 * Displays a Toast with the message
	 *
	 * @param message Message to display
	 */
	private void displayToast(String message) {
		Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
	}

	/**
	 * click handlers to be called from android:onClick
	 *
	 * must be public, return void and have a View as its only parameter
	 */
	public void showDonutOrder(View view) {
		displayToast(getString(R.string.donut_order_message));
	}

	public void showIceCreamOrder(View view) {
		displayToast(getString(R.string.ice_cream_order_message));
	}

	public void showFroyoOrder(View view) {
		displayToast(getString(R.string.froyo_order_message));
	}
}
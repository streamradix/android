package com.codelabs.java_developers.fundamentals;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.codelabs.java_developers.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Fundamentals041A extends AppCompatActivity {
	public static final String EXTRA_MESSAGE = "com.codelabs.java_developers.extra.MESSAGE";
	private String mOrderMessage = "";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fundamentals041_a);

		Toolbar toolbar = findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);

		FloatingActionButton fab = findViewById(R.id.fab);
		fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Fundamentals041A.this, Fundamentals041B.class);
				intent.putExtra(EXTRA_MESSAGE, mOrderMessage);
				startActivity(intent);
			}
		});
	}

	/**
	 * Inflates the menu, and adds items to the action bar if it is present.
	 *
	 * @param menu Menu to inflate.
	 * @return Returns true if the menu inflated.
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.fund041a_menu, menu);
		return true;
	}

	/**
	 * Handles app bar item clicks.
	 *
	 * @param item Item clicked.
	 * @return True if one of the defined items was clicked.
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		// This comment suppresses the Android Studio warning about simplifying
		// the return statements.
		//noinspection SimplifiableIfStatement
		if (id == R.id.action_order) {
			Intent intent = new Intent(Fundamentals041A.this, Fundamentals041B.class);
			intent.putExtra(EXTRA_MESSAGE, mOrderMessage);
			startActivity(intent);
			return true;
		} else if (id == R.id.action_status) {
			displayToast(getString(R.string.action_status_message));
			return true;
		} else if (id == R.id.action_favorites) {
			displayToast(getString(R.string.action_favorites_message));
			return true;
		} else if (id == R.id.action_contact) {
			displayToast(getString(R.string.action_contact_message));
			return true;
		}

		return super.onOptionsItemSelected(item);
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
		mOrderMessage = getString(R.string.donut_order_message);
		displayToast(mOrderMessage);
	}

	public void showIceCreamOrder(View view) {
		mOrderMessage = getString(R.string.ice_cream_order_message);
		displayToast(mOrderMessage);
	}

	public void showFroyoOrder(View view) {
		mOrderMessage = getString(R.string.froyo_order_message);
		displayToast(mOrderMessage);
	}
}
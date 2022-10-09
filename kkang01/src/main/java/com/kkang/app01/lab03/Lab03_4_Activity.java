package com.kkang.app01.lab03;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.kkang.app01.R;

public class Lab03_4_Activity extends AppCompatActivity {
	private CheckBox checkBox;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lab03_4);

		TextView textView = findViewById(R.id.fontView);
		Typeface typeface = Typeface.createFromAsset(getAssets(), "xmas.ttf");
		textView.setTypeface(typeface);

		checkBox = findViewById(R.id.checkbox);
		checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
				if (isChecked) {
					checkBox.setText("is Checked");
				} else {
					checkBox.setText("is unChecked");
				}
			}
		});
	}
}
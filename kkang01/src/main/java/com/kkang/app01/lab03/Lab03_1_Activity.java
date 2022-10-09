package com.kkang.app01.lab03;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Lab03_1_Activity extends AppCompatActivity {

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		LinearLayout linear = new LinearLayout(this);
		linear.setOrientation(LinearLayout.VERTICAL);

		Button btn1 = new Button(this);
		btn1.setText("Button 1");

		linear.addView(btn1);

		Button btn2 = new Button(this);
		btn2.setText("Button 2");

		linear.addView(btn2);

		setContentView(linear);
	}
}

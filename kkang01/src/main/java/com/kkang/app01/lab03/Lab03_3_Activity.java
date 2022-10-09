package com.kkang.app01.lab03;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.kkang.app01.R;

public class Lab03_3_Activity extends AppCompatActivity implements View.OnClickListener {
	private Button trueBtn;
	private Button falseBtn;
	private TextView targetTextView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lab03_3);

		trueBtn = findViewById(R.id.btn_visible_true);
		falseBtn = findViewById(R.id.btn_visible_false);
		targetTextView = findViewById(R.id.text_visible_target);

		trueBtn.setOnClickListener(this);
		falseBtn.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		if (view == trueBtn) {
			targetTextView.setVisibility(View.VISIBLE);
		} else if (view == falseBtn) {
			targetTextView.setVisibility(View.INVISIBLE);
		}
	}
}
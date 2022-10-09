package com.kkang.app01.lab08;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.kkang.app01.R;

public class Lab08_1_Activity extends AppCompatActivity
		implements View.OnClickListener {
	private EditText titleView;
	private EditText contentView;
	private Button addBtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lab08_1);

		titleView = findViewById(R.id.add_title);
		contentView = findViewById(R.id.add_content);
		addBtn = findViewById(R.id.add_btn);

		addBtn.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		if (view == addBtn) {
			String title = titleView.getText().toString();
			String content = contentView.getText().toString();

			DBHelper helper = new DBHelper(this);
			SQLiteDatabase db = helper.getWritableDatabase();
			db.execSQL("insert into tb_memo (title, content) values (?, ?)",
			           new String[]{title, content});
			db.close();

			Intent intent = new Intent(Lab08_1_Activity.this, ReadDBActivity.class);
			startActivity(intent);
		}
	}
}
package com.codelabs.java_developers;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.codelabs.java_developers.databinding.ActivityMainBinding;
import com.codelabs.java_developers.fundamentals.Fundamentals011;
import com.codelabs.java_developers.main.MainAdapter;
import com.codelabs.java_developers.main.MainItem;
import com.codelabs.java_developers.main.MainListener;
import com.codelabs.java_developers.main.MainViewHolder;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
	private ActivityMainBinding bind;
	private ArrayList<MainItem> list;
	private MainAdapter mainAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		bind = ActivityMainBinding.inflate(getLayoutInflater());
		setContentView(bind.getRoot());

		list = new ArrayList<>();
		appendList();

		mainAdapter = new MainAdapter(list);
		mainAdapter.setListener(new MainListener() {
			@Override
			public void clickHandler(MainViewHolder holder, MainItem item, int position) {
				Class<?> cls = item.getCls();

				if (cls == null) return;
				startActivity(new Intent(MainActivity.this, cls));
			}
		});

		bind.mainRecycler.setLayoutManager(new LinearLayoutManager(this));
		bind.mainRecycler.setAdapter(mainAdapter);
	}

	private void appendList() {
		list.add(new MainItem("HelloWorld", Fundamentals011.class));
	}
}
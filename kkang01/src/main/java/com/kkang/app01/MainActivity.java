package com.kkang.app01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.kkang.app01.lab03.Lab03_1_Activity;

import java.util.ArrayList;
import java.util.function.BiConsumer;

public class MainActivity extends AppCompatActivity {
	private ArrayList<Lab> data;
	private LabAdapter adapter;
	private RecyclerView recyclerView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		data = new ArrayList<>();
		addLab();

		adapter = new LabAdapter(data);
		adapter.setListener(new BiConsumer<View, Lab>() {
			@Override
			public void accept(View view, Lab lab) {
				startActivity(new Intent(getApplicationContext(), lab.getCls()));
			}
		});

		recyclerView = findViewById(R.id.recycler);
		recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
		recyclerView.setAdapter(adapter);
	}

	private void addLab() {
		data.add(new Lab("Lab03_1", Lab03_1_Activity.class));
	}
}
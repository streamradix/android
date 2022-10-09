package com.kkang.app01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.kkang.app01.lab03.Lab03_1_Activity;
import com.kkang.app01.lab03.Lab03_2_Activity;
import com.kkang.app01.lab03.Lab03_3_Activity;
import com.kkang.app01.lab03.Lab03_4_Activity;
import com.kkang.app01.lab04.Lab04_1_Activity;
import com.kkang.app01.lab04.Lab04_2_Activity;
import com.kkang.app01.lab04.Lab04_3_Activity;
import com.kkang.app01.lab04.Lab04_4_Activity;
import com.kkang.app01.lab05.Lab05_1_Activity;
import com.kkang.app01.lab05.Lab05_2_Activity;
import com.kkang.app01.lab06.Lab06_1_Activity;
import com.kkang.app01.lab07.Lab07_1_Activity;
import com.kkang.app01.lab07.Lab07_2_Activity;
import com.kkang.app01.lab08.Lab08_1_Activity;

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
		data.add(new Lab("Lab03_2", Lab03_2_Activity.class));
		data.add(new Lab("Lab03_3", Lab03_3_Activity.class));
		data.add(new Lab("Lab03_4", Lab03_4_Activity.class));
		data.add(new Lab("Lab04_1", Lab04_1_Activity.class));
		data.add(new Lab("Lab04_2", Lab04_2_Activity.class));
		data.add(new Lab("Lab04_3", Lab04_3_Activity.class));
		data.add(new Lab("Lab04_4", Lab04_4_Activity.class));
		data.add(new Lab("Lab05_1", Lab05_1_Activity.class));
		data.add(new Lab("Lab05_2", Lab05_2_Activity.class));
		data.add(new Lab("Lab06_1", Lab06_1_Activity.class));
		data.add(new Lab("Lab07_1", Lab07_1_Activity.class));
		data.add(new Lab("Lab07_2", Lab07_2_Activity.class));
		data.add(new Lab("Lab08_1", Lab08_1_Activity.class));
	}
}
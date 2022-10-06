package com.radix.garage.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.radix.garage.databinding.ActivityMainBinding;
import com.radix.garage.move_topic.MoveTopicActivity;

import java.util.ArrayList;
import java.util.function.BiConsumer;

public class MainActivity extends AppCompatActivity {
	private ActivityMainBinding bind;
	private ArrayList<Topic> data;
	private TopicAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		bind = ActivityMainBinding.inflate(getLayoutInflater());
		setContentView(bind.getRoot());

		data = new ArrayList<>();
		addTopic();

		adapter = new TopicAdapter(data);
		adapter.setListener(new BiConsumer<View, Topic>() {
			@Override
			public void accept(View view, Topic topic) {
				startActivity(new Intent(getApplicationContext(), topic.getCls()));
			}
		});

		bind.recycler.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
		bind.recycler.setAdapter(adapter);
	}

	private void addTopic() {
		data.add(new Topic("move topic", MoveTopicActivity.class));
	}
}
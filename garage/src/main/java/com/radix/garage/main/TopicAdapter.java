package com.radix.garage.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.radix.garage.R;

import java.util.ArrayList;
import java.util.function.BiConsumer;

public class TopicAdapter extends RecyclerView.Adapter<TopicViewHolder> {
	private ArrayList<Topic> data;
	private BiConsumer<View, Topic> listener;

	public TopicAdapter(ArrayList<Topic> data) {
		this.data = data;
	}

	@NonNull
	@Override
	public TopicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		return new TopicViewHolder(LayoutInflater
				.from(parent.getContext())
				.inflate(R.layout.main_item_topic, parent, false));
	}

	@Override
	public void onBindViewHolder(@NonNull TopicViewHolder holder, int position) {
		Topic topic = data.get(position);

		holder.topic_btn.setText(topic.getTitle());

		if (listener != null)
			holder.topic_btn.setOnClickListener(v -> listener.accept(v, topic));
	}

	@Override
	public int getItemCount() {
		return data.size();
	}

	public void setListener(BiConsumer<View, Topic> listener) {
		this.listener = listener;
	}
}
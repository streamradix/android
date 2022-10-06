package com.radix.garage.main;

import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.radix.garage.R;

public class TopicViewHolder extends RecyclerView.ViewHolder {
	public final Button topic_btn;

	public TopicViewHolder(@NonNull View itemView) {
		super(itemView);
		this.topic_btn = itemView.findViewById(R.id.topic_name);
	}
}
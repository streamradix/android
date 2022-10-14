package com.codelabs.java_developers.main;

import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codelabs.java_developers.R;

public class MainViewHolder extends RecyclerView.ViewHolder {
	private final Button mainBtn;

	public MainViewHolder(@NonNull View itemView) {
		super(itemView);
		this.mainBtn = itemView.findViewById(R.id.main_btn);
	}

	public Button getMainBtn() {
		return mainBtn;
	}
}

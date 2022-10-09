package com.kkang.app01;

import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LabViewHolder extends RecyclerView.ViewHolder {
	public Button btn;

	public LabViewHolder(@NonNull View itemView) {
		super(itemView);
		this.btn = itemView.findViewById(R.id.item_btn);
	}
}

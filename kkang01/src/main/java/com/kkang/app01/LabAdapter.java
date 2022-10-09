package com.kkang.app01;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.function.BiConsumer;

public class LabAdapter extends RecyclerView.Adapter<LabViewHolder> {
	private List<Lab> list;
	private BiConsumer<View, Lab> listener;

	public LabAdapter(List<Lab> list) {
		this.list = list;
	}

	public void setListener(BiConsumer<View, Lab> listener) {
		this.listener = listener;
	}

	@NonNull
	@Override
	public LabViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		return new LabViewHolder(LayoutInflater
				.from(parent.getContext())
				.inflate(R.layout.main_lab_item, parent, false));
	}

	@Override
	public void onBindViewHolder(@NonNull LabViewHolder holder, int position) {
		Lab lab = list.get(position);
		holder.btn.setText(lab.getTitle());

		if (listener != null)
			holder.btn.setOnClickListener(view -> listener.accept(view, lab));
	}

	@Override
	public int getItemCount() {
		return list.size();
	}
}

package com.codelabs.java_developers.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codelabs.java_developers.R;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainViewHolder> {
	private List<MainItem> list;
	private MainListener listener;

	public MainAdapter(List<MainItem> list) {
		this.list = list;
	}

	public void setListener(MainListener listener) {
		this.listener = listener;
	}

	@NonNull
	@Override
	public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
		View view = layoutInflater.inflate(R.layout.main_item, parent, false);
		return new MainViewHolder(view);
	}

	@Override
	public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
		MainItem item = list.get(position);
		String text = item.getText();

		if (text == null || text.equals("")) {
			holder.getMainBtn().setVisibility(View.INVISIBLE);
			return;
		}

		holder.getMainBtn().setVisibility(View.VISIBLE);
		holder.getMainBtn().setText(text);
		holder.getMainBtn().setSingleLine();
		holder.getMainBtn().setSelected(true);

		if (listener == null) return;
		holder.getMainBtn().setOnClickListener(v -> listener.clickHandler(holder, item, position));
	}

	@Override
	public int getItemCount() {
		return list.size();
	}
}

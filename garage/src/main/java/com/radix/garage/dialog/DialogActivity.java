package com.radix.garage.dialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.radix.garage.R;
import com.radix.garage.databinding.ActivityDialogBinding;

public class DialogActivity extends AppCompatActivity
		implements View.OnClickListener {
	private ActivityDialogBinding bind;
	private AlertDialog listDialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		bind = ActivityDialogBinding.inflate(getLayoutInflater());
		setContentView(bind.getRoot());

		String[] items = new String[]{"옵션 1", "옵션 2", "메뉴 1", "메뉴 2"};
		ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(),
				R.layout.dialog_list_item, items);
		bind.tv.setAdapter(adapter);

		bind.dialBtn.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		if (v == bind.dialBtn) {
			AlertDialog.Builder builder = new AlertDialog.Builder(DialogActivity.this);
			builder.setTitle("알람 벨소리");
			builder.setSingleChoiceItems(R.array.dialog_array, 0, dialogListener);

			builder.setPositiveButton("확인", null);
			builder.setNegativeButton("취소", null);

			listDialog = builder.create();
			listDialog.show();
		}
	}

	DialogInterface.OnClickListener dialogListener = new DialogInterface.OnClickListener() {
		@Override
		public void onClick(DialogInterface dialog, int which) {
			if (dialog == listDialog) {
				String[] datas = getResources().getStringArray(R.array.dialog_array);
				Toast.makeText(getApplicationContext(), datas[which] + " 선택", Toast.LENGTH_SHORT)
						.show();
			}
		}
	};
}
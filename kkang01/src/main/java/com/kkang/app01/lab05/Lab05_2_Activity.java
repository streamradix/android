package com.kkang.app01.lab05;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.kkang.app01.R;

import java.util.Calendar;

public class Lab05_2_Activity extends AppCompatActivity implements View.OnClickListener {
	private Button alertBtn;
	private Button listBtn;
	private Button dateBtn;
	private Button timeBtn;
	private Button customDialogBtn;

	// 이벤트 처리를 위해 dialog 객체를 멤버 변수로 선언
	private AlertDialog customDialog;
	private AlertDialog listDialog;
	private AlertDialog alertDialog;

	@Override

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lab05_2);

		// View 객체 획득
		alertBtn = findViewById(R.id.btn_alert);
		listBtn = findViewById(R.id.btn_list);
		dateBtn = findViewById(R.id.btn_date);
		timeBtn = findViewById(R.id.btn_time);
		customDialogBtn = findViewById(R.id.btn_custom);

		// 버튼 클릭 이벤트 등록
		alertBtn.setOnClickListener(this);
		listBtn.setOnClickListener(this);
		dateBtn.setOnClickListener(this);
		timeBtn.setOnClickListener(this);
		customDialogBtn.setOnClickListener(this);
	}

	private void showToast(String message) {
		Toast toast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
		toast.show();
	}

	DialogInterface.OnClickListener dialogListener = new DialogInterface.OnClickListener() {
		@Override
		public void onClick(DialogInterface dialog, int which) {
			if (dialog == customDialog && which == DialogInterface.BUTTON_POSITIVE) {
				showToast("custom dialog 확인 버튼 click...");
			} else if (dialog == listDialog) {
				String[] datas = getResources().getStringArray(R.array.dialog_array);
				showToast(datas[which] + " 선택하셨습니다");
			} else if (dialog == alertDialog && which == DialogInterface.BUTTON_POSITIVE) {
				showToast("alert dialog ok click...");
			}
		}
	};

	@Override
	public void onClick(View v) {
		if (v == alertBtn) {
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setIcon(android.R.drawable.ic_dialog_alert);
			builder.setTitle("알림");
			builder.setMessage("정말 종료하시겠습니까?");
			builder.setPositiveButton("OK", dialogListener);
			builder.setNegativeButton("NO", null);

			alertDialog = builder.create();
			alertDialog.show();
		} else if (v == listBtn) {
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setTitle("알람 벨소리");
			builder.setSingleChoiceItems(R.array.dialog_array, 0, dialogListener);

			builder.setPositiveButton("확인", null);
			builder.setNegativeButton("취소", null);

			listDialog = builder.create();
			listDialog.show();
		} else if (v == dateBtn) {
			// 현재 날짜로 dialog를 띄우기 위해 날짜 구함
			Calendar c = Calendar.getInstance();
			int year = c.get(Calendar.YEAR);
			int month = c.get(Calendar.MONTH);
			int day = c.get(Calendar.DAY_OF_MONTH);

			DatePickerDialog dateDialog = new DatePickerDialog(this, (view, years, monthOfYear, dayOfMonth) -> {
				showToast(years + ":" + (monthOfYear + 1) + ":" + dayOfMonth);
			}, year, month, day);
			dateDialog.show();
		} else if (v == timeBtn) {
			// 현재 시간으로 dialog를 띄우기 위해 시간을 구함
			Calendar c = Calendar.getInstance();
			int hour = c.get(Calendar.HOUR_OF_DAY);
			int minute = c.get(Calendar.MINUTE);

			TimePickerDialog timeDialog = new TimePickerDialog(this, (view, hourOfDay, minutes) -> {
				showToast(hourOfDay + ":" + minutes);
			}, hour, minute, false);
			timeDialog.show();
		} else if (v == customDialogBtn) {
			AlertDialog.Builder builder = new AlertDialog.Builder(this);

			// custom dialog를 위한 layout.xml 초기화
			LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
			View view = inflater.inflate(R.layout.dialog_layout, null);
			builder.setView(view);

			builder.setPositiveButton("확인", dialogListener);
			builder.setNegativeButton("취소", null);

			customDialog = builder.create();
			customDialog.show();
		}
	}
}
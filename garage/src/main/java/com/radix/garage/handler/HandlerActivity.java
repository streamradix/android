package com.radix.garage.handler;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;

import com.radix.garage.databinding.ActivityHandlerBinding;

public class HandlerActivity extends AppCompatActivity {
	private ActivityHandlerBinding bind;
	private MutableLiveData<Integer> num;
	private Thread thread;
	private Handler handler;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		bind = ActivityHandlerBinding.inflate(getLayoutInflater());
		setContentView(bind.getRoot());

		num = new MutableLiveData<>();
		num.setValue(20);
		num.observe(this, intV -> {
			bind.handlerShow.setText(Integer.toString(intV));
		});

		bind.handlerBtn.setOnClickListener(v -> actHandler());

		handler = new Handler(new Handler.Callback() {
			@Override
			public boolean handleMessage(@NonNull Message msg) {
				num.setValue(msg.what);
				return false;
			}
		});
	}

	private void actHandler() {
		thread = new TestThread(handler, num.getValue());
		thread.start();
	}
}
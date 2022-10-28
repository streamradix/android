package com.radix.garage.handler;

import android.os.Handler;

public class TestThread extends Thread {
	private final Handler handler;
	private int val;

	public TestThread(Handler handler, int val) {
		this.handler = handler;
		this.val = val;
	}

	@Override
	public void run() {
		val += 20;

		handler.obtainMessage(val).sendToTarget();
	}
}

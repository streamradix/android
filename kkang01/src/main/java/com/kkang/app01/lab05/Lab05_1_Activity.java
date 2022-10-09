package com.kkang.app01.lab05;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.kkang.app01.R;

public class Lab05_1_Activity extends AppCompatActivity implements View.OnClickListener {
	private Button vibrationBtn;
	private Button systemBeepBtn;
	private Button customSoundBtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lab05_1);

		vibrationBtn = findViewById(R.id.btn_vibration);
		systemBeepBtn = findViewById(R.id.btn_system_beep);
		customSoundBtn = findViewById(R.id.btn_custom_sound);

		vibrationBtn.setOnClickListener(this);
		systemBeepBtn.setOnClickListener(this);
		customSoundBtn.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		if (view == vibrationBtn) {
			Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
			vibrator.vibrate(1000);
		} else if (view == systemBeepBtn) {
			Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
			Ringtone ringtone = RingtoneManager.getRingtone(getApplicationContext(), notification);
			ringtone.play();
		} else if (view == customSoundBtn) {
			MediaPlayer player = MediaPlayer.create(getApplicationContext(), R.raw.lab05_fallbackring);
			player.start();
		}
	}
}
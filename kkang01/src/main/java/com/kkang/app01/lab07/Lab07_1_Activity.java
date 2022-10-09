package com.kkang.app01.lab07;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.kkang.app01.R;

public class Lab07_1_Activity extends AppCompatActivity {
	private ImageView imageView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lab07_1);

		imageView = findViewById(R.id.img);

		Animation anim = AnimationUtils.loadAnimation(this, R.anim.lab07_in);
		anim.setAnimationListener(new Animation.AnimationListener() {
			@Override
			public void onAnimationStart(Animation animation) {

			}

			@Override
			public void onAnimationEnd(Animation animation) {
				Animation anim = AnimationUtils.loadAnimation(Lab07_1_Activity.this, R.anim.lab07_move);
				anim.setFillAfter(true);
				imageView.startAnimation(anim);
			}

			@Override
			public void onAnimationRepeat(Animation animation) {

			}
		});

		imageView.startAnimation(anim);
	}
}
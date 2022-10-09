package com.kkang.app01.lab04;

import android.os.Bundle;
import android.widget.TabHost;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import com.kkang.app01.R;

public class Lab04_3_Activity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lab04_3);

		TabHost tabHost = findViewById(R.id.host);
		tabHost.setup();

		// 탭 화면 하나가 탭호스트의 탭스팩으로 표현
		// 스팩 하나에 버튼과 본문이 지정
		TabHost.TabSpec spec1 = tabHost.newTabSpec("tab1");
		spec1.setIndicator(null, ResourcesCompat.getDrawable(getResources(), R.drawable.lab04_tab_icon1, null));
		spec1.setContent(R.id.tab_content1);
		tabHost.addTab(spec1);

		TabHost.TabSpec spec2 = tabHost.newTabSpec("tab2");
		spec2.setIndicator(null, ResourcesCompat.getDrawable(getResources(), R.drawable.lab04_tab_icon2, null));
		spec2.setContent(R.id.tab_content2);
		tabHost.addTab(spec2);

		TabHost.TabSpec spec3 = tabHost.newTabSpec("tab3");
		spec3.setIndicator(null, ResourcesCompat.getDrawable(getResources(), R.drawable.lab04_tab_icon3, null));
		spec3.setContent(R.id.tab_content3);
		tabHost.addTab(spec3);
	}
}
package com.hbjy.customview;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.hbjy.customview.widget.TimePicker;
import com.hbjy.customview.widget.WaveView;

/**
 * <pre>
 *     @author : 李小勇
 *     date   : 2017/06/10
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		WaveView waveView = findViewById(R.id.pcv);
		waveView.setProgress(0.68f);
		findViewById(R.id.bt_select).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				showSelectTime();
			}
		});
	}

	private void showSelectTime() {
		TimePicker picker = new TimePicker.Builder(this)
				.textSize(20)
				.textColor(Color.BLACK)
				.titleBackgroundColor("#ed3b5d")
				.cancelTextColor("#FFFFFF")
				.confirTextColor("#FFFFFF")
				.visibleItemsCount(5)
				.itemPadding(10)
				.build();
		picker.show();
		picker.setOnTimeItemClickListener(new TimePicker.OnTimeItemClickListener() {
			@Override
			public void onSelected(String... timeSelected) {
				String time = timeSelected[0] + ":" + timeSelected[1] + ":00";
				Log.i("TAG", "onSelected: " + time);
			}

			@Override
			public void onCancel() {

			}
		});
	}
}

package com.yaniscounttime;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {
	private EditText inputTime;
	private Button getTime, startTime, endTime;
	private TextView time;
	private int i = 0;
	private Timer timer = null;
	private TimerTask task = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		inintView();
	}

	private void inintView() {
		inputTime = (EditText) findViewById(R.id.inputTime);
		getTime = (Button) findViewById(R.id.getTime);
		startTime = (Button) findViewById(R.id.startTime);
		endTime = (Button) findViewById(R.id.endTime);
		time = (TextView) findViewById(R.id.time);

		getTime.setOnClickListener(this);
		startTime.setOnClickListener(this);
		endTime.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.getTime:// 获取倒计时
			time.setText("倒计时：" + inputTime.getText().toString());
			i = Integer.parseInt(inputTime.getText().toString());
			break;
		case R.id.startTime:
			startTime();
			break;
		case R.id.endTime:
			endTime();
			break;
		}
	}

	private Handler mHandler = new Handler() {
		public void handleMessage(Message msg) {
			time.setText("倒计时：" + msg.arg1);// 接送消息
			startTime();
		};
	};

	/**
	 * 开始计时
	 */
	public void startTime() {
		timer = new Timer();
		task = new TimerTask() {

			@Override
			public void run() {
				i--;
				Message msg = mHandler.obtainMessage();
				msg.arg1 = i;
				mHandler.sendMessage(msg);
			}
		};
		timer.schedule(task, 1000);
	}

	/**
	 * 停止计时
	 */
	public void endTime() {
		timer.cancel();
	}
}

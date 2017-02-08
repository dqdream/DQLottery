package com.dq.caipiao;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

	
	private EditText size;
	private Button ok;
	
	private ListView listview;
	LotteryAdapter adapter;
	List<LotteryBean> beans;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		size=(EditText) findViewById(R.id.size);
		ok=(Button) findViewById(R.id.ok);
		listview=(ListView) findViewById(R.id.listview);
		beans=new ArrayList<LotteryBean>();
		adapter=new LotteryAdapter(this, new ArrayList<LotteryBean>());
		listview.setAdapter(adapter);
		ok.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String text=size.getText().toString();
				if (!TextUtils.isEmpty(text)) {
					beans.clear();
					adapter.updateData(beans);
					getMyLotterys(Integer.parseInt(text));
				}
			}
		});
	}
	
	Handler handler=new Handler(){
		public void dispatchMessage(android.os.Message msg) {
			adapter.updateData(beans);
		};
	};
	
	private void getMyLotterys(final int size){
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0; i < size; i++) {
					LotteryBean bean=new LotteryBean();
					beans.add(bean);
					for (int j = 0; j < 100; j++) {
						LotteryUtil.getRandomLottery(bean);
						handler.sendEmptyMessage(0);
						try {
							Thread.sleep(20);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}).start();
	}
	
	boolean isExit=false;
	long time=0;
	@Override
	public void onBackPressed() {
		if (isExit) {
			if (System.currentTimeMillis()-time<=1000) {
				super.onBackPressed();
			}else {
				time=0;
				isExit=false;
			}
		} else {
			Toast.makeText(this, "再次点击退出程序", 1000).show();
			time=System.currentTimeMillis();
			isExit=true;
		}
	}
}

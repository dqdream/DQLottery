package com.dq.caipiao;

import java.util.List;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class LotteryAdapter extends BaseAdapter{

	List<LotteryBean> beans;
	private LayoutInflater inflater;
	public LotteryAdapter(Context context, List<LotteryBean> beans) {
		this.beans=beans;
		inflater = LayoutInflater.from(context);
	}

	public void updateData(List<LotteryBean> beans) {
		this.beans.clear();
		this.beans.addAll(beans);
		notifyDataSetChanged();
	}
	
	
	@Override
	public int getCount() {
		return beans.size();
	}

	@Override
	public Object getItem(int position) {
		return beans.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = inflater.inflate(R.layout.adapter, null);
			holder.tv1 = (TextView) convertView.findViewById(R.id.tv1);
			holder.tv2 = (TextView) convertView.findViewById(R.id.tv2);
			holder.tv3 = (TextView) convertView.findViewById(R.id.tv3);
			holder.tv4 = (TextView) convertView.findViewById(R.id.tv4);
			holder.tv5 = (TextView) convertView.findViewById(R.id.tv5);
			holder.tv6 = (TextView) convertView.findViewById(R.id.tv6);
			holder.tv7 = (TextView) convertView.findViewById(R.id.tv7);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		LotteryBean bean=beans.get(position);
		Log.d("vv", bean.toString());
		if (bean!=null) {
			holder.tv1.setText(bean.getRed1());
			holder.tv2.setText(bean.getRed2());
			holder.tv3.setText(bean.getRed3());
			holder.tv4.setText(bean.getRed4());
			holder.tv5.setText(bean.getRed5());
			holder.tv6.setText(bean.getRed6());
			holder.tv7.setText(bean.getBlue1());
		}
		return convertView;
	}
	private class ViewHolder {
		TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7;
	}
}

package com.witskies.appmarket.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.witskies.appmarket.R;
import com.witskies.appmarket.widgets.LoopViewPager;

public class ChoiceListviewAdapter extends BaseAdapter {

	private List<String> mDatas;
	private Context mContext;

	private List<String> mAdUris;

	final int TYPE_1 = 0;
	final int TYPE_2 = 1;

	public ChoiceListviewAdapter(List<String> mDatas, List<String> mAdUris, Context mContext) {
		this.mAdUris = mAdUris;
		this.mDatas = mDatas;
		this.mContext = mContext;
		initLoopViewPager();
	}

	/**
	 * 加载顶部viewpager
	 * 
	 * @return
	 */
	private View initLoopViewPager() {
		View parentView = LayoutInflater.from(mContext).inflate(R.layout.choice_listview_viewpager, null);
		AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT,
				AbsListView.LayoutParams.WRAP_CONTENT);
		parentView.setLayoutParams(layoutParams);
		LoopViewPager loopViewPager = (LoopViewPager) parentView.findViewById(R.id.item_home_viewpager);
		loopViewPager.setAdapter(new LoopViewPagerAdapter(mContext, mAdUris), parentView);
		return parentView;
	}

	@Override
	public int getCount() {
		return mDatas.size();
	}

	@Override
	public int getViewTypeCount() {
		return 2;
	}

	// 每个convert view都会调用此方法，获得当前所需要的view样式
	@Override
	public int getItemViewType(int position) {
		int p = position;
		if (p == 0) {
			return TYPE_1;
		} else {
			return TYPE_2;
		}
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder1 holder1 = null;
		ViewHolder2 holder2 = null;
		int type = getItemViewType(position);
		if (convertView == null) {
			switch (type) {
			case TYPE_1:
				holder1 = new ViewHolder1();
				convertView = initLoopViewPager();
				convertView.setTag(holder1);
				break;
			case TYPE_2:
				holder2 = new ViewHolder2();
				convertView = LayoutInflater.from(mContext).inflate(R.layout.item_choice_listview, null);
				holder2.textView = (TextView) convertView.findViewById(R.id.item_choice_listview_text);
				convertView.setTag(holder2);
				break;
			}
		} else {
			switch (type) {
			case TYPE_1:
				holder1 = (ViewHolder1) convertView.getTag();
				break;
			case TYPE_2:
				holder2 = (ViewHolder2) convertView.getTag();
				break;
			}
		}
		switch (type) {
		case TYPE_1:
			break;
		case TYPE_2:
			holder2.textView.setText(mDatas.get(position) + "");
			break;
		}
		return convertView;
	}

	private class ViewHolder2 {
		TextView textView;
	}

	private class ViewHolder1 {
		View head;
	}
}

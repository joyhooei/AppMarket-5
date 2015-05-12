package com.witskies.appmarket.common;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.witskies.appmarket.R;
import com.witskies.appmarket.util.ToastUtils;
import com.witskies.appmarket.widgets.PagerSlidingTabStrip;

/**
 * 单例模式
 * 
 * @author Clance
 * 
 */
public class InitActionBar {

	private static InitActionBar instance;

	public static InitActionBar getInstance() {
		if (null == instance) {
			synchronized (InitActionBar.class) {
				if (null == instance) {
					instance = new InitActionBar();
				}
			}
		}
		return instance;
	}

	public void initActionBar(View view, Context context) {
		LinearLayout mSearch = (LinearLayout) view.findViewById(R.id.actionbar_search);
		ImageView mScan = (ImageView) view.findViewById(R.id.actionbar_search_scan);
		mSearch.setOnClickListener(new MyOnClick(context));
		mScan.setOnClickListener(new MyOnClick(context));

	}

	public void initIndicator(View view, ViewPager mViewPager) {
		PagerSlidingTabStrip mTabStrip;
		mTabStrip = (PagerSlidingTabStrip) view.findViewById(R.id.fragment_home_indicator);
		mTabStrip.setShouldExpand(true);
		mTabStrip.setViewPager(mViewPager);
		mTabStrip.setIndicatorHeight(5);
		mTabStrip.setSelectedTextColor(Color.parseColor("#019CAC"));
		mTabStrip.setIndicatorColor(Color.parseColor("#019CAC"));
	}

	private class MyOnClick implements OnClickListener {
		Context context;

		public MyOnClick(Context context) {
			this.context = context;
		}

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.actionbar_search:
				ToastUtils.showToast(context, "search", 1);
				break;
			case R.id.actionbar_search_scan:
				ToastUtils.showToast(context, "scan", 1);
				break;

			}
		}
	}
}

package com.witskies.appmarket.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

import com.witskies.appmarket.R;
import com.witskies.appmarket.fragment.EntertainmentFragment;
import com.witskies.appmarket.fragment.GameFragment;
import com.witskies.appmarket.fragment.HomeFragment;
import com.witskies.appmarket.fragment.ManagerFragment;
import com.witskies.appmarket.fragment.SoftFragment;
import com.witskies.appmarket.util.ToastUtils;

public class MainActivity extends FragmentActivity {
	/**
	 * 底部选项卡
	 */
	private FragmentTabHost mTabHost;
	/**
	 * fragment管理器
	 */
	private FragmentManager mManager;
	/**
	 * 布局加载器
	 */
	private LayoutInflater mInflater;
	/**
	 * Fragment数组
	 * 
	 */
	private Class<?> mFragmentArray[] = { HomeFragment.class, GameFragment.class, SoftFragment.class, EntertainmentFragment.class,
			ManagerFragment.class };
	/**
	 * fragment图标数组
	 * 
	 */
	private int mImageArray[] = { R.drawable.tab_home_btn, R.drawable.tab_game_btn, R.drawable.tab_soft_btn, R.drawable.tab_entertainment_btn,
			R.drawable.tab_manager_btn };

	/**
	 * fragment标题数组
	 * 
	 */
	private String mTextArray[] = { "推荐", "游戏", "软件", "娱乐", "管理" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initViews();
	}

	private void initViews() {

		mInflater = LayoutInflater.from(this);
		mManager = getSupportFragmentManager();
		mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
		mTabHost.setup(this, mManager, R.id.realtabcontent);
		int count = mFragmentArray.length;
		for (int i = 0; i < count; i++) {
			TabSpec spec = mTabHost.newTabSpec(mTextArray[i]).setIndicator(getTabItemView(i));
			mTabHost.addTab(spec, mFragmentArray[i], null);
			// 设置选中的背景
			// mTabHost.getTabWidget().getChildAt(i).setBackgroundResource(R.drawable.selector_tab_background);
		}

	}

	/**
	 * 
	 * tabhost的选项卡view
	 */
	private View getTabItemView(int index) {
		View view = mInflater.inflate(R.layout.item_tab_view, null);
		ImageView imageView = (ImageView) view.findViewById(R.id.imageview);
		imageView.setImageResource(mImageArray[index]);
		TextView textView = (TextView) view.findViewById(R.id.textview);
		textView.setText(mTextArray[index]);

		return view;
	}

}

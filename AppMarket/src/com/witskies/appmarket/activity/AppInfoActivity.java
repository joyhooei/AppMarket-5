package com.witskies.appmarket.activity;

import java.util.ArrayList;
import java.util.List;

import com.witskies.appmarket.R;
import com.witskies.appmarket.fragment.CommentsFragment;
import com.witskies.appmarket.fragment.IntroductionFragment;
import com.witskies.appmarket.fragment.RelevantFragment;
import com.witskies.appmarket.widgets.DragTopLayout;
import com.witskies.appmarket.widgets.PagerSlidingTabStrip;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class AppInfoActivity extends FragmentActivity {

	private PagerSlidingTabStrip mTabStrip;
	private ViewPager mViewPager;
	private DragTopLayout mDragTopLayout;
	private Button mDownLoad;
	private TextView mTitle;
	private ImageView mHeadImage;
	private final String[] mTitles = new String[] { "简介", "评论", "相关" };
	private List<Fragment> mFragments;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_appinfo);
		super.onCreate(savedInstanceState);
		initViews();
	}

	private void initViews() {
		mTabStrip = (PagerSlidingTabStrip) findViewById(R.id.activity_appinfo_indicator);
		mViewPager = (ViewPager) findViewById(R.id.activity_appinfo_viewpager);
		mDragTopLayout = (DragTopLayout) findViewById(R.id.activity_appinfo_draglayout);
		mDragTopLayout.setTopViewId(R.id.activity_appinfo_topview);
		mDragTopLayout.setDragContentViewId(R.id.activity_appinfo_contentview);
		mDragTopLayout.setOverDrag(false);
		mFragments = new ArrayList<Fragment>();
		IntroductionFragment introductionFragment = new IntroductionFragment();
		CommentsFragment commentsFragment = new CommentsFragment();
		RelevantFragment relevantFragment = new RelevantFragment();
		mFragments.add(introductionFragment);
		mFragments.add(commentsFragment);
		mFragments.add(relevantFragment);

		mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {

			@Override
			public int getCount() {
				return mFragments.size();
			}

			@Override
			public Fragment getItem(int arg0) {
				return mFragments.get(arg0);
			}

			@Override
			public CharSequence getPageTitle(int position) {
				return mTitles[position];
			}
		});

		mTabStrip.setShouldExpand(true);
		mTabStrip.setViewPager(mViewPager);
	}
}

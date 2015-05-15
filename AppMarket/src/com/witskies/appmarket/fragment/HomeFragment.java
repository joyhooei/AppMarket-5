package com.witskies.appmarket.fragment;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.witskies.appmarket.R;
import com.witskies.appmarket.common.InitActionBar;

/**
 * 首页
 * 
 * @author lance
 * 
 */
public class HomeFragment extends Fragment {
	private ViewPager mViewPager;
	private List<Fragment> mFragments;
	private final String[] mIndicatorTitles = { "精选", "分类", "榜单", "发现" };
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_home, container, false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		initViews();
		InitActionBar.getInstance().initActionBar(getView(), getActivity());
		InitActionBar.getInstance().initIndicator(getView(), mViewPager);

	}

	private void initViews() {
		mFragments = new ArrayList<Fragment>();
		// fragment
		ChoiceFragment forcusFragment = new ChoiceFragment();
		GiftFragment giftFragment = new GiftFragment();
		FindFragment findFragment = new FindFragment();
		MustFragment mustFragment = new MustFragment();
		mFragments.add(forcusFragment);
		mFragments.add(giftFragment);
		mFragments.add(findFragment);
		mFragments.add(mustFragment);
		mViewPager = (ViewPager) getActivity().findViewById(R.id.fragment_home_viewpager);
		mViewPager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
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
				return mIndicatorTitles[position];
			}
		});
		mViewPager.setCurrentItem(0);
	}

}

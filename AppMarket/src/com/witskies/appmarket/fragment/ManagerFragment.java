package com.witskies.appmarket.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.witskies.appmarket.R;
import com.witskies.appmarket.common.InitActionBar;

public class ManagerFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.fragment_manager, container, false);
		return view;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		InitActionBar.getInstance().initActionBar(getView(), getActivity());
//		InitActionBar.getInstance().initIndicator(getView(), mViewPager);
		super.onActivityCreated(savedInstanceState);
	}
}

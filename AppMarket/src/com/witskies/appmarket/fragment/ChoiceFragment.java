package com.witskies.appmarket.fragment;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.witskies.appmarket.R;
import com.witskies.appmarket.adapter.ChoiceListviewAdapter;
import com.witskies.appmarket.widgets.CustomSwipeToRefresh;
/**
 * 精选
 * @author Clance
 *
 */
public class ChoiceFragment extends Fragment {
	private List<String> mAdUris;
	private List<String> mDatas;
	private CustomSwipeToRefresh mRefreshLayout;
	private ListView mListView;
	private String[] uri = new String[] { "http://img.popoho.com/UploadPic/2011-9/201194144121332.jpg",
			"http://wenwen.soso.com/p/20131209/20131209133813-334451836.jpg",
			"http://picview01.baomihua.com/photos/20120626/m_14_634763259911718750_11073026.jpg",
			"http://tupian.qqjay.com/u/2012/0202/7e1354c474562247f0bda889bc2af2b4.jpg" };
	private ChoiceListviewAdapter mAdapter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return inflater.inflate(R.layout.fragment_choice, container, false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		initViews();
		super.onActivityCreated(savedInstanceState);
	}

	private void initViews() {
		mAdUris = new ArrayList<String>();
		for (int i = 0; i < uri.length; i++) {
			mAdUris.add(uri[i]);
		}
		mDatas = new ArrayList<String>();
		for (int i = 0; i < 50; i++) {
			mDatas.add("item" + i);
		}
		mRefreshLayout = (CustomSwipeToRefresh) getActivity().findViewById(R.id.fragment_choice_refreshlayout);
		// 设置刷新时动画的颜色，可以设置4个
//		mRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_light, android.R.color.holo_red_light, android.R.color.holo_orange_light,
//				android.R.color.holo_green_light);
		mRefreshLayout.setOnRefreshListener(new OnRefreshListener() {

			@Override
			public void onRefresh() {
				new Handler().postDelayed(new Runnable() {

					@Override
					public void run() {
						mRefreshLayout.setRefreshing(false);
						mDatas.add("refresh add");
						mAdapter.notifyDataSetChanged();
					}
				}, 3000);
			}

		});
		mAdapter = new ChoiceListviewAdapter(mDatas, mAdUris, getActivity());
		mListView = (ListView) getActivity().findViewById(R.id.fragment_choice_listview);
		mListView.setAdapter(mAdapter);

	}
}

package com.witskies.appmarket.fragment;

import com.witskies.appmarket.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class IntroductionFragment extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return inflater.inflate(R.layout.fragment_introduction, container, false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub

		ListView listView = (ListView) getActivity().findViewById(R.id.listview1);
		listView.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, new String[] { "1", "1", "1", "1", "1", "1",
				"1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1",
				"1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1" }));
		super.onActivityCreated(savedInstanceState);
	}
}

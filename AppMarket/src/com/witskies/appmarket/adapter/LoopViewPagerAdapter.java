package com.witskies.appmarket.adapter;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.witskies.appmarket.R;

public class LoopViewPagerAdapter extends PagerAdapter {

	/**
	 * 图片资源列表
	 */
	private List<String> mAdList = new ArrayList<String>();
	private ArrayList<View> mAdView = new ArrayList<View>();
	private Context mContext;
	private DisplayImageOptions mOptions;

	public LoopViewPagerAdapter(Context context, List<String> adList) {
		this.mContext = context;
		this.mAdList = adList;
		mOptions = new DisplayImageOptions.Builder()
				.showImageOnFail(R.drawable.ic_empty)
				.imageScaleType(ImageScaleType.EXACTLY)
				.resetViewBeforeLoading(true).cacheOnDisk(true)
				.bitmapConfig(Bitmap.Config.RGB_565).considerExifParams(true)
				.build();
	}

	@Override
	public int getCount() {
		return mAdList.size();
	}

	@Override
	public boolean isViewFromObject(View view, Object obj) {
		return view == obj;
	}

	@SuppressLint("InflateParams")
	@Override
	public Object instantiateItem(ViewGroup container, final int position) {
		final String imageUrl = mAdList.get(position);
		View view = LayoutInflater.from(mContext).inflate(
				R.layout.item_choice_viewpager, null);
		ImageView imageView = (ImageView) view
				.findViewById(R.id.item_choice_viewpager_imageview);
		// 设置图片点击监听
		imageView.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Uri uri = Uri.parse(imageUrl);
				Intent it = new Intent(Intent.ACTION_VIEW, uri);
				mContext.startActivity(it);
			}
		});
		ImageLoader.getInstance().displayImage(imageUrl, imageView, mOptions);
		mAdView.add(view);
		container.addView(view);
		return view;
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		// 这里不需要做任何事情
	}

}
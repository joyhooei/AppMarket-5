package com.witskies.appmarket.widgets;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

/**
 * 解决触摸焦点
 * 
 * @author Clance
 * 
 */
public class CustomSwipeToRefresh extends SwipeRefreshLayout {

	private int mTouchSlop;
	private float mPrevX;

	public CustomSwipeToRefresh(Context context, AttributeSet attrs) {
		super(context, attrs);

		mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
	}

	@SuppressLint("Recycle")
	@Override
	public boolean onInterceptTouchEvent(MotionEvent event) {

		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			mPrevX = MotionEvent.obtain(event).getX();
			break;

		case MotionEvent.ACTION_MOVE:
			final float eventX = event.getX();
			float xDiff = Math.abs(eventX - mPrevX);

			if (xDiff > mTouchSlop) {
				return false;
			}
		}

		return super.onInterceptTouchEvent(event);
	}
}
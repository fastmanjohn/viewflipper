package com.fastmanjohn.test;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

public class FlipView extends ViewGroup {

	private static final String TAG = "FlipView";
	private ViewGroup mMiddleView;

	public FlipView(Context context) {
		super(context);
	}

	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b) {

	}

	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		return super.onInterceptTouchEvent(ev);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		return super.onTouchEvent(event);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	}

	@Override
	protected void onFinishInflate() {
		super.onFinishInflate();
		mMiddleView = (ViewGroup) findViewById(R.id.float_view);
	}

	void setViewContent(View v) {
		mMiddleView.removeAllViews();
		mMiddleView.addView(v, LayoutParams.FILL_PARENT,
				LayoutParams.FILL_PARENT);
	}

	@Override
	protected void onScrollChanged(int l, int t, int oldl, int oldt) {
		AppLogger.debug(TAG, "onScrollChanged" + "   l:" + l + " t:" + t
				+ " old1:" + oldl + " oldt:" + oldt);
		super.onScrollChanged(l, t, oldl, oldt);
	}

}

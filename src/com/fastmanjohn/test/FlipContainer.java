package com.fastmanjohn.test;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

public class FlipContainer extends FrameLayout {

	private static final String TAG = "ViewFliper";
	private FlipView mTopView;
	private ViewGroup mBgView;

	@Override
	protected void onFinishInflate() {
		super.onFinishInflate();
		mBgView = (ViewGroup) findViewById(R.id.background_view);
		mTopView = (FlipView) findViewById(R.id.float_layout);
	}

	public FlipContainer(Context context) {
		super(context);
	}

	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b) {

	}

	public void setBacgroundView(View v) {
		mBgView.removeAllViews();
		mBgView.addView(v, LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT);
	}

	public void setTopView(View v) {
		mTopView.setViewContent(v);
	}

	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		AppLogger.debug(TAG, "onInterceptTouchEvent" + ev.toString());
		return super.onInterceptTouchEvent(ev);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		AppLogger.debug(TAG, "onTouchEvent" + event.toString());
		return super.onTouchEvent(event);
	}

}

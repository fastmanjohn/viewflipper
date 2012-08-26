package com.myriad.test;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Scroller;
import android.widget.TextView;

public class ViewScoller extends FrameLayout {

	private static final String TAG = "ViewScoller";
	private LinearLayout mTopView;
	private LinearLayout mButtomView;
	private int mScreenWidth;

	// public LinearLayout getTopView() {
	// return mTopView;
	// }
	//
	// public LinearLayout getButtomView() {
	// return mButtomView;
	// }

	public ViewScoller(Context context) {
		super(context);
		mScroller = new Scroller(getContext());
	}

	public ViewScoller(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		mScroller = new Scroller(getContext());
	}

	public ViewScoller(Context context, AttributeSet attrs) {
		super(context, attrs);
		// mTop = (TextView) findViewById(R.id.top_view);
		// mButtom = (TextView) findViewById(R.id.buttom_view);
		// mScreenWidth = mTop.getWidth();
		mScroller = new Scroller(getContext());
	}

	private float mLastX;
	private boolean mIsScrolling = false;
	private boolean mIsScollingEnable = true;

	// @Override
	// public boolean dispatchTouchEvent(MotionEvent ev) {
	// Log.d(TAG, "dispatchTouchEvent:" + ev.toString());
	// if (1 == 1) {
	// return true;
	// }
	// int action = ev.getAction();
	// float x = ev.getX();
	// switch (action) {
	// case MotionEvent.ACTION_DOWN: {
	// if (canScrolling(x)) {
	// return true;
	// }
	// break;
	// }
	// case MotionEvent.ACTION_MOVE: {
	// if (mIsScrolling) {
	// mLastX = x;
	// return true;
	// }
	// break;
	// }
	// case MotionEvent.ACTION_UP: {
	// if (mIsScrolling) {
	// return true;
	// }
	// break;
	// }
	// }
	// return super.onInterceptTouchEvent(ev);
	// }

	@Override
	protected void onFinishInflate() {
		mTopView = (LinearLayout) findViewById(R.id.top_view);
		mButtomView = (LinearLayout) findViewById(R.id.buttom_view);
		super.onFinishInflate();
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		getChildAt(0).measure(MeasureSpec.getSize(MeasureSpec.EXACTLY),
				heightMeasureSpec);
		getChildAt(1).measure(widthMeasureSpec, heightMeasureSpec);
		// mTopView.scrollTo((int) mLastX, 0);
	}

	@Override
	protected void onLayout(boolean changed, int left, int top, int right,
			int bottom) {
		int childLeft = 0;
		mScreenWidth = mTopView.getWidth();
		Log.d(TAG, " onLayout mScreenWidth=" + mScreenWidth);

		final int count = getChildCount();
		for (int i = 0; i < count; i++) {
			final View child = getChildAt(i);
			if (child.getVisibility() != View.GONE) {
				final int childWidth = child.getMeasuredWidth();
				if (i == 1) {
					child.layout((int) mLastX, 0, childLeft + childWidth, child
							.getMeasuredHeight());
				} else {
					child.layout(childLeft, 0, childLeft + childWidth, child
							.getMeasuredHeight());
				}
				childLeft += childWidth;
			}
		}
		// super.onLayout(changed, left, top, right, bottom);
	}

	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		Log.d(TAG, "onInterceptTouchEvent:" + ev.toString());
		int action = ev.getAction();
		float x = ev.getX();
		switch (action) {
		case MotionEvent.ACTION_DOWN: {
			if (canScrolling(x)) {
				return true;
			}
			break;
		}
		case MotionEvent.ACTION_MOVE: {
			if (mIsScrolling) {
				mLastX = x;
				return true;
			}
			break;
		}
		case MotionEvent.ACTION_UP: {
			if (mIsScrolling) {
				return true;
			}
			break;
		}
		}
		return super.onInterceptTouchEvent(ev);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		Log.d(TAG, "onTouchEvent:" + event.toString());
		int action = event.getAction();
		float x = event.getX();
		float y = event.getY();
		switch (action) {
		case MotionEvent.ACTION_DOWN: {
			mLastX = x;
			mIsScrolling = true;
			break;
		}
		case MotionEvent.ACTION_MOVE: {
			scrollTopBy(x, y);
			break;
		}
		case MotionEvent.ACTION_UP: {
			mIsScrolling = false;
			int xCoordinate = getScrollX();
			if (xCoordinate > (mScreenWidth / 2)) {
				scrollTopToRight();
			} else {
				scrollTopToLeft();
			}
			break;
		}
		}
		return true;
	}

	private Scroller mScroller;

	@Override
	public void computeScroll() {

		super.computeScroll();
		if (mScroller.computeScrollOffset()) {

			mTopView.scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
			invalidate();
			Log.d(TAG, " computeScroll mScroller.x=" + mScroller.getCurrX());
			int diff = (int) (mLastX - mScroller.getCurrX());
			mTopView.layout((int) (mLastX), 0, mTopView.getMeasuredWidth(),
					mTopView.getMeasuredWidth());
		}
		invalidate();
		// mTop.scrollTo(mScroller.getCurrX(), 0);
		// mTop.invalidate();

	}

	private void scrollTopBy(float x, float y) {
		Log.v(TAG, " scrollTopBy" + " x :" + x + " y :" + y);
		int deltaX = (int) (mLastX - x);

		Log.v(TAG, " scrollTopBy called:" + mTopView.getScrollX() + " deltaX: "
				+ deltaX);
		mTopView.scrollBy(deltaX, 0);
		mScroller.startScroll(mTopView.getScrollX(), 0, deltaX, 0, Math
				.abs(deltaX) * 2);
		// mTopView.invalidate();
		mLastX = x;
		invalidate();
	}

	private void scrollTopToLeft() {
		Log.v(TAG, " scrollTopToLeft called");
	}

	private void scrollTopToRight() {
		Log.v(TAG, " scrollTopToRight called");
	}

	public boolean canScrolling(float x) {
		int xOffSet = (int) (mScreenWidth - x);
		Log.d(TAG, "xOffSet=" + xOffSet + " = " + mScreenWidth + "-" + x);
		if (mIsScollingEnable && xOffSet < 30) {
			return true;
		}
		return false;
	}

}

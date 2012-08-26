package com.myriad.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class ViewScollerActivity extends Activity {

	private ListView mTopList;
	private ListView mButtomList;
	private String[] john = new String[] {
			"oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo0",
			"oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo01",
			"oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo02",
			"oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo03",
			"oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo04",
			"oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo05",
			"oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo06",
			"oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo07",
			"oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo0",
			"oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo01",
			"oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo02",
			"oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo03",
			"oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo04",
			"oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo05",
			"oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo06",
			"oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo07",
			"oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo0",
			"oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo01",
			"oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo02",
			"oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo03",
			"oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo04",
			"oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo05",
			"oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo06",
			"oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo07",
			"oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo0",
			"oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo01",
			"oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo02",
			"oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo03",
			"oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo04",
			"oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo05",
			"oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo06",
			"oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo07" };
	private String[] hannah = new String[] {
			"iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii",
			"iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii1",
			"iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii2",
			"iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii3",
			"iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii4",
			"iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii5",
			"iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii6",
			"iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii7",
			"iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii",
			"iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii1",
			"iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii2",
			"iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii3",
			"iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii4",
			"iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii5",
			"iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii6",
			"iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii7",
			"iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii",
			"iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii1",
			"iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii2",
			"iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii3",
			"iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii4",
			"iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii5",
			"iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii6",
			"iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii7",
			"iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii",
			"iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii1",
			"iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii2",
			"iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii3",
			"iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii4",
			"iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii5",
			"iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii6",
			"iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii7" };

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.view_scoller);

		mTopList = (ListView) findViewById(R.id.top_list);

		MyAdaptor johnAdaptor = new MyAdaptor(getApplicationContext(), Arrays
				.asList(john));
		mTopList.setAdapter(johnAdaptor);
		mTopList.setOnItemClickListener(mTopListListener);
		LinearLayout mTopView = (LinearLayout) findViewById(R.id.top_view);
//		mTopView.setVisibility(View.GONE);

		mButtomList = (ListView) findViewById(R.id.buttom_list);
		MyAdaptor hannahAdaptor = new MyAdaptor(getApplicationContext(), Arrays
				.asList(hannah));
		mButtomList.setAdapter(hannahAdaptor);
		mButtomList.setOnItemClickListener(mButtomListListener);

	}

	private OnItemClickListener mTopListListener = new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			Log.d("ViewScoller", "position = " + position + " "
					+ john[position]);
		}

	};

	private OnItemClickListener mButtomListListener = new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			Log.d("ViewScoller", "position = " + position + " "
					+ hannah[position]);
		}

	};

	public class MyAdaptor extends BaseAdapter {

		LayoutInflater mInflater;
		List<String> mNames;

		public MyAdaptor(Context context, List names) {
			mInflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			mNames = names;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return mNames.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return mNames.get(position);
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			TextView tv = (TextView) mInflater.inflate(R.layout.name, null);
			tv.setText((String) getItem(position));
			return tv;
		}

	}
}
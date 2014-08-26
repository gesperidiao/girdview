package com.example.girdviewhello;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.example.models.Category;
import com.example.models.DataHardCode;
import com.example.models.Symbol;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {

	private Context mContext;
	private DataHardCode mDatabase;
	private int color;
	private Category mCategory;

	public ImageAdapter(Context c, int color, Category category) {
		mContext = c;
		this.color = color;
		mDatabase = new DataHardCode();
		this.mCategory = category;
	}

	public int getCount() {
		return mDatabase.getCategoryList(this.mCategory).size();
	}

	public Object getItem(int position) {
		return null;
	}

	public long getItemId(int position) {
		return 0;
	}

	// create a new ImageView for each item referenced by the Adapter
	public View getView(int position, View convertView, ViewGroup parent) {
		ImageView imageView;
		Symbol symbol;
		int resourceId;

		if (convertView == null) { // if it's not recycled, initialize some
									// attributes
			imageView = new ImageView(mContext);
			imageView.setLayoutParams(new GridView.LayoutParams(180, 180));
			imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
			imageView.setPadding(5, 5, 5, 5);
			imageView.setBackgroundColor(this.color);
		} else {
			imageView = (ImageView) convertView;
		}

		symbol = mDatabase.getCategoryList(this.mCategory).get(position);
		resourceId = mContext.getResources().getIdentifier(
				symbol.getPictogram().getFileName(), "drawable",
				mContext.getPackageName());
		
		
		
		
		imageView.setImageResource(resourceId);
		// imageView.setImageResource(mThumbID.get(position));
		// String name =
		// mContext.getResources().getResourceEntryName(mThumbID.get(position));

		imageView.setTag(symbol);
		// imageView.setImageResource(mThumbIds[position]);
		return imageView;
	}

	// references to our images
	private Integer[] mThumbIds = { R.drawable.aabril, R.drawable.abecedario,
			R.drawable.abelha, R.drawable.aberto, R.drawable.abobora,
			R.drawable.abobora, R.drawable.abobrinha, R.drawable.aborrecer,
			R.drawable.aabril, R.drawable.abecedario, R.drawable.abelha,
			R.drawable.aberto, R.drawable.abobora, R.drawable.abobora,
			R.drawable.abobrinha, R.drawable.aborrecer, R.drawable.aabril,
			R.drawable.abecedario, R.drawable.abelha, R.drawable.aberto,
			R.drawable.abobora, R.drawable.abobora };

	private List<Integer> mThumbID = new ArrayList<Integer>();

	private void getResourceIds() {
		final R.drawable drawableResources = new R.drawable();
		final Class<R.drawable> c = R.drawable.class;
		final Field[] fields = c.getDeclaredFields();

		mThumbID.clear();

		for (int i = 0, max = fields.length; i < max; i++) {
			final int resourceId;
			try {
				resourceId = fields[i].getInt(drawableResources);
				mThumbID.add(resourceId);
			} catch (Exception e) {
				continue;
			}
			/* make use of resourceId for accessing Drawables here */
		}
	}
}

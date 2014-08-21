package com.example.girdviewhello;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {

	  private Context mContext;

	    public ImageAdapter(Context c) {
	        mContext = c;
	    }

	    public int getCount() {
	        return mThumbIds.length;
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
	        getResourceIds();
	        if (convertView == null) {  // if it's not recycled, initialize some attributes
	            imageView = new ImageView(mContext);
	            imageView.setLayoutParams(new GridView.LayoutParams(200, 200));
	            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
	            imageView.setPadding(5, 5, 5, 5);
	            imageView.setBackgroundColor(0xffff0000);
	        } else {
	            imageView = (ImageView) convertView;
	        }

	        imageView.setImageResource(mThumbID.get(position));
	        String name = mContext.getResources().getResourceEntryName(mThumbID.get(position));
	        imageView.setTag(name); 
	        //imageView.setImageResource(mThumbIds[position]);
	        return imageView;
	    }

	    // references to our images
	    private Integer[] mThumbIds = {
	            R.drawable.aabril, R.drawable.abecedario,
	            R.drawable.abelha, R.drawable.aberto,
	            R.drawable.abobora, R.drawable.abobora,
	            R.drawable.abobrinha, R.drawable.aborrecer,
	            R.drawable.aabril, R.drawable.abecedario,
	            R.drawable.abelha, R.drawable.aberto,
	            R.drawable.abobora, R.drawable.abobora,
	            R.drawable.abobrinha, R.drawable.aborrecer,
	            R.drawable.aabril, R.drawable.abecedario,
	            R.drawable.abelha, R.drawable.aberto,
	            R.drawable.abobora, R.drawable.abobora
	    };
	    
	    private List<Integer> mThumbID = new ArrayList<Integer>();

	    
	    
	    private void getResourceIds(){
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

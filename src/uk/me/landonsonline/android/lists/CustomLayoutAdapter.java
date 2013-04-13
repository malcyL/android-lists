package uk.me.landonsonline.android.lists;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class CustomLayoutAdapter extends ArrayAdapter<String> {

    public CustomLayoutAdapter(Context context, int textViewResourceId) {
	super(context, textViewResourceId);
    }

    public void setData(List<String> data)
    {
	clear();
	if (data != null)
	{
	    addAll(data);
	}
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
	View view = super.getView(position, convertView, parent);

	((TextView) view).setText(getItem(position));

	return view;
    }
}

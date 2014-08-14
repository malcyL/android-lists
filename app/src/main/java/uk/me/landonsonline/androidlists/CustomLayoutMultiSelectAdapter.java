package uk.me.landonsonline.androidlists;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class CustomLayoutMultiSelectAdapter extends ArrayAdapter<String>
{
	// fields -----------------------------------------------------------------
    
    	private final Context context;
    
	// constructors -----------------------------------------------------------
	
	public CustomLayoutMultiSelectAdapter(Context context, int textViewResourceId)
	{
		super(context, textViewResourceId);
		this.context = context;
	}

	// Adapter methods --------------------------------------------------------

	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		LayoutInflater inflater = (LayoutInflater) context
			.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View view = inflater.inflate(R.layout.multi_select_list_row, parent, false);
		
		String item = getItem(position);
		
		TextView authorTextView = (TextView) view.findViewById(R.id.title);
		authorTextView.setText(item);

		TextView subTitleTextView = (TextView) view.findViewById(R.id.sub_title);
		subTitleTextView.setText(item);

		TextView referenceTextView = (TextView) view.findViewById(R.id.note);
		referenceTextView.setText(item);

		return view;
	}

	// public methods ---------------------------------------------------------

	public void setData(List<String> data)
	{
		clear();
		if (data != null)
		{
			addAll(data);
		}
	}
}

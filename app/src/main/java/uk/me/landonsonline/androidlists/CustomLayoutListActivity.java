package uk.me.landonsonline.androidlists;

import java.util.Arrays;
import java.util.List;

import android.app.ListActivity;
import android.app.LoaderManager;
import android.content.AsyncTaskLoader;
import android.content.Loader;
import android.os.Bundle;

public class CustomLayoutListActivity extends ListActivity implements
	LoaderManager.LoaderCallbacks<List<String>> {

    static final String[] NUMBERS = new String[] { "One", "Two", "Three",
	    "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven",
	    "Twelve", "Thirteen" };

    private CustomLayoutAdapter adapter;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);

	getLoaderManager().initLoader(0, null, this);

	adapter = new CustomLayoutAdapter(this, android.R.layout.simple_list_item_1);
	setListAdapter(adapter);
    }

    @Override
    public Loader<List<String>> onCreateLoader(int id, Bundle args) {
	return new AsyncTaskLoader<List<String>>(this) {
	    @Override
	    protected void onStartLoading() {
		forceLoad();
	    }

	    @Override
	    public List<String> loadInBackground() {
		return Arrays.asList(NUMBERS);
	    }
	};
    }

    @Override
    public void onLoadFinished(Loader<List<String>> loader, List<String> data) {
	adapter.setData(data);
    }

    @Override
    public void onLoaderReset(Loader<List<String>> data) {
	adapter.setData(null);
    }

}
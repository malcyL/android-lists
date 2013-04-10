package uk.me.landonsonline.android.lists;

import java.util.Arrays;
import java.util.List;

import android.app.ListActivity;
import android.app.LoaderManager;
import android.content.AsyncTaskLoader;
import android.content.Loader;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;

public class MultiSelectListActivity extends ListActivity implements
LoaderManager.LoaderCallbacks<List<String>> {

    static final String[] NUMBERS = new String[] { "One", "Two", "Three",
	"Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven",
	"Twelve", "Thirteen" };

    private StringAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);

	getLoaderManager().initLoader(0, null, this);

	adapter = new StringAdapter(this, android.R.layout.simple_list_item_checked);
	setListAdapter(adapter);

        ListView lv = getListView();
	lv.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        lv.setMultiChoiceModeListener(new ModeCallback());
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

    // Multi Choice Mode Listener ---------------------------------------------------------------

    private class ModeCallback implements ListView.MultiChoiceModeListener {

	public boolean onCreateActionMode(ActionMode mode, Menu menu) {
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.multi_select_list_select_menu, menu);
	    mode.setTitle("Select Items");
	    setSubtitle(mode);
	    return true;
	}

	public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
	    return true;
	}

	public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
	    switch (item.getItemId()) {
	    case R.id.multi:
		mode.finish();
		break;
	    default:
		break;
	    }
	    return true;
	}

	public void onDestroyActionMode(ActionMode mode) {
	}

	public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {
	    setSubtitle(mode);
	}

	private void setSubtitle(ActionMode mode) {
	    final int checkedCount = getListView().getCheckedItemCount();
	    switch (checkedCount) {
	    case 0:
		mode.setSubtitle(null);
		break;
	    case 1:
		mode.setSubtitle("One item selected");
		break;
	    default:
		mode.setSubtitle("" + checkedCount + " items selected");
		break;
	    }
	}
    }
}
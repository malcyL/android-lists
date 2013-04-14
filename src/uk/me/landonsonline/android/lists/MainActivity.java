package uk.me.landonsonline.android.lists;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
	// Inflate the menu; this adds items to the action bar if it is present.
	getMenuInflater().inflate(R.menu.activity_main, menu);
	return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
	switch (item.getItemId())
	{
	case R.id.menu_simple_list:
	    Intent simpleListIntent = new Intent(this, SimpleListActivity.class);
	    startActivity(simpleListIntent);
	    return true;
	case R.id.menu_background_thread_list:
	    Intent backgroundThreadListIntent = new Intent(this, BackgroundThreadListActivity.class);
	    startActivity(backgroundThreadListIntent);
	    return true;
	case R.id.menu_custom_layout_list:
	    Intent customLayoutListIntent = new Intent(this, CustomLayoutListActivity.class);
	    startActivity(customLayoutListIntent);
	    return true;
	case R.id.menu_multi_select_list:
	    Intent multSelectListIntent = new Intent(this, MultiSelectListActivity.class);
	    startActivity(multSelectListIntent);
	    return true;
	case R.id.menu_custom_layout_multi_select_list:
	    Intent customLayoutMultSelectListIntent = new Intent(this, CustomLayoutMultiSelectListActivity.class);
	    startActivity(customLayoutMultSelectListIntent);
	    return true;
	}

	return super.onOptionsItemSelected(item);
    }

}

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
	}

	return super.onOptionsItemSelected(item);
    }

}

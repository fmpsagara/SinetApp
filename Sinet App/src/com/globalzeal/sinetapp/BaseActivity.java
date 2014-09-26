package com.globalzeal.sinetapp;

import com.javatechig.viewflipper.R;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;

public class BaseActivity extends ActionBarActivity {

	private String[] mMenuTitles;
	private ListView mDrawerList;
	private DrawerLayout mDrawerLayout;
	private ActionBarDrawerToggle mDrawerToggle;
	private CharSequence mTitle;
	private Context context;
	private FrameLayout frameContainer;
	private Fragment homeFragment, siisFragment,confFragment,indFragment,prodFragment,bestprFragment;
	private FragmentTransaction ft;
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.base_activity_layout);
		context = this;
		initDrawer();
		/*
		if(savedInstanceState==null){
			frameContainer = (FrameLayout) findViewById(R.id.frame);
			homeFragment = new HomeFragment();
									
			ft = getFragmentManager().beginTransaction();
			
			ft.replace(R.id.frame,homeFragment);
			ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);		
			ft.commit();					
		}*/
		
		
	
	}

	protected void initDrawer() {
		Log.d("CALLED", "CALLED");
		mTitle = getTitle();

		mMenuTitles = getResources().getStringArray(R.array.menu_array);
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerList = (ListView) findViewById(R.id.left_drawer);

		mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow,
				GravityCompat.START);

		mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);

		View header = getLayoutInflater().inflate(
				R.layout.header_listview_menu, null);
		mDrawerList.addHeaderView(header);

		mDrawerList.setAdapter(new ArrayAdapter<String>(this,
				R.layout.drawer_list_item, mMenuTitles));

		mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);

		mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
				R.drawable.ic_drawer, R.string.drawer_open,
				R.string.drawer_close) {

			
			public void onDrawerClosed(View view) {
				mDrawerLayout
						.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
				supportInvalidateOptionsMenu();
				Log.d("BITCHHH","BITCCHHH");
			}

			public void onDrawerOpened(View drawerView) {
				Log.d("BITCHHH","BITCCHHH");
				mDrawerLayout
						.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
				supportInvalidateOptionsMenu();
			}
		};

		mDrawerLayout.setDrawerListener(mDrawerToggle);

		if (getSupportFragmentManager().getBackStackEntryCount() == 1) {
			mDrawerToggle.setDrawerIndicatorEnabled(true);
		} else {
			mDrawerToggle.setDrawerIndicatorEnabled(false);
		}

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		switch (item.getItemId()) {
		case android.R.id.home:
			if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
				this.onBackPressed();
			} else {
				boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
				if (drawerOpen) {
					mDrawerLayout.closeDrawer(mDrawerList);
				} else {
					mDrawerLayout.openDrawer(mDrawerList);
				}
			}
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	private class DrawerItemClickListener implements
			ListView.OnItemClickListener {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {

			selectItem(position);
		}
	}

	@Override
	public void onBackPressed() {
		super.onBackPressed();

		if (getSupportFragmentManager().getBackStackEntryCount() == 0) {
			setTitle("Demo");

			mDrawerToggle.setDrawerIndicatorEnabled(true);
		}

	}

	/** Swaps fragments in the main content view */
	private void selectItem(int position) {
		switch (position) {

		case 1:
			setTitle("Sinet");

			break;
		case 2:
			setTitle("SIIS");

			// setFragment(new DefaultFragment());
			break;
		case 3:
			setTitle("Products");

			// setFragment(new DefaultFragment());
			break;
		case 4:
			setTitle("Conferences & Events");

			// setFragment(new DefaultFragment());
			break;
		case 5:
			setTitle("Industry News");

			// setFragment(new DefaultFragment());
		case 6:
			setTitle("Survey");

			// setFragment(new DefaultFragment());
			break;

		}

		if (position > 0)
			mDrawerLayout.closeDrawer(mDrawerList);

		mDrawerToggle.setDrawerIndicatorEnabled(true);

		mDrawerList.setItemChecked(position, true);

	}

	// private void setFragment(Fragment fragment)
	// {
	// FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
	// //ft.setCustomAnimations(android.R.anim.slide_in_left,
	// android.R.anim.slide_out_right);
	// ft.replace(R.id.content, fragment);
	// ft.addToBackStack(null);
	// // Commit the transaction
	// ft.commit();
	// }

	@Override
	public void setTitle(CharSequence title) {
		mTitle = title;
		getSupportActionBar().setTitle(mTitle);
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);

		mDrawerToggle.syncState();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		mDrawerToggle.onConfigurationChanged(newConfig);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}

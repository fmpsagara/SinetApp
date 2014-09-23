package com.globalzeal.sinetapp;

import com.javatechig.viewflipper.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

@SuppressLint("NewApi")
public class HomeActivity extends Activity implements HomeFragment.OnImageSelected {
		
	private Context context;
	private FrameLayout frameContainer;
	private Fragment homeFragment, siisFragment,confFragment,indFragment,prodFragment,bestprFragment;
	private FragmentTransaction ft;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		context = this;
		frameContainer = (FrameLayout) findViewById(R.id.frame);
		homeFragment = new HomeFragment();
		siisFragment = new SIISFragment();
		confFragment = new ConferenceFragment();
		indFragment = new IndustryFragment();
		prodFragment = new ProductFragment();
		bestprFragment = new BestPracticesFragment();
		
		
		ft = getFragmentManager().beginTransaction();
		
		ft.replace(R.id.frame,homeFragment);
		ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
		ft.addToBackStack(null);
		ft.commit();
	}
		
	@Override
	public void onImageClicked(int index) {
		Toast.makeText(context, Integer.toString(index), Toast.LENGTH_SHORT).show();
		ft = getFragmentManager().beginTransaction();
		if(index==0){
			ft.replace(R.id.frame,siisFragment);		
		}else if (index==1){
			ft.replace(R.id.frame,confFragment);
		}else if (index==2){
			ft.replace(R.id.frame,indFragment);
		}else if (index==3){
			ft.replace(R.id.frame,prodFragment);
		}else if (index==4){
			ft.replace(R.id.frame,bestprFragment);
		}
		ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
		ft.addToBackStack(null);
		ft.commit();
	}
}



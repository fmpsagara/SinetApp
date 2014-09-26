package com.globalzeal.sinetapp;


import com.javatechig.viewflipper.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
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
public class HomeActivity extends BaseActivity implements HomeFragment.OnImageSelected {
		
	private Context context;
	private FrameLayout frameContainer;
	private Fragment homeFragment, siisFragment,confFragment,indFragment,prodFragment,bestprFragment;
	private FragmentTransaction ft;
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		if(savedInstanceState==null){
			frameContainer = (FrameLayout) findViewById(R.id.frame);
			homeFragment = new HomeFragment();
									
			ft = getFragmentManager().beginTransaction();
			
			ft.replace(R.id.frame,homeFragment);
			ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);		
			ft.commit();					
		}
	}
		
	@Override
	public void onImageClicked(int index) {
		
		ft = getFragmentManager().beginTransaction();	
		
		if(index==0){
			siisFragment = new SIISFragment();
			ft.replace(R.id.frame,siisFragment);		
		}else if (index==1){
			confFragment = new ConferenceFragment();
			ft.replace(R.id.frame,confFragment);
		}else if (index==2){
			indFragment = new IndustryFragment();
			ft.replace(R.id.frame,indFragment);
		}else if (index==3){
			prodFragment = new ProductFragment();
			ft.replace(R.id.frame,prodFragment);
		}else if (index==4){
			bestprFragment = new BestPracticesFragment();
			ft.replace(R.id.frame,bestprFragment);
		}
		
		ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
		
		ft.addToBackStack(null);		
		ft.commit();
	}
}



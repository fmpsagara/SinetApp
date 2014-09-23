package com.globalzeal.sinetapp;

import com.javatechig.viewflipper.R;

import android.annotation.SuppressLint;
import android.app.Activity;
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
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

@SuppressLint("NewApi")
public class HomeActivity extends Activity implements HomeFragment.OnImageSelected {
		
	private Context context;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		context = this;
	}
		
	@Override
	public void onImageClicked(int index) {
		Toast.makeText(context, Integer.toString(index), Toast.LENGTH_SHORT).show();
	}
}



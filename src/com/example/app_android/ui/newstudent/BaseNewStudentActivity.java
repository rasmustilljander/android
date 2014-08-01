package com.example.app_android.ui.newstudent;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ExpandableListView;

import com.example.app_android.R;
import com.example.app_android.ui.BaseActivity;
import com.example.app_android.ui.elements.expandablelist.ExpandableListGroup;
import com.example.app_android.ui.elements.expandablelist.ExpandableListMetaButton;
import com.example.app_android.ui.elements.expandablelist.IButtonCallback;
import com.example.app_android.ui.elements.expandablelist.MyBaseExpandableListAdapter;
import com.example.app_android.util.Logger;

abstract public class BaseNewStudentActivity extends BaseActivity implements IButtonCallback{
	
	protected static final String TAG = "NewstudentMenu";
	protected MyBaseExpandableListAdapter mExpandableListAdapter;
	protected ArrayList<ExpandableListGroup> mExpandableListItems;
	protected ExpandableListView mExpandableList;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
    	Logger.VerboseLog(TAG, getClass().getSimpleName() + ":entered onCreate()");
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_studentportal); 
        
		mExpandableList = (ExpandableListView) findViewById(R.id.ExpandableList);
		mExpandableListItems = SetStandardGroups();
    }        
    
	abstract protected ArrayList<ExpandableListGroup> SetStandardGroups();

    @Override
	protected void onDestroy() {
    	Logger.VerboseLog(TAG, getClass().getSimpleName() + ":entered onDestroy()");
		super.onDestroy();
	}

	@Override
	protected void onPause() {
    	Logger.VerboseLog(TAG, getClass().getSimpleName() + ":entered onPause()");
		super.onPause();
	}

	@Override
	protected void onRestart() {
    	Logger.VerboseLog(TAG, getClass().getSimpleName() + ":entered onRestart()");
		super.onRestart();
	}

	@Override
	protected void onResume() {
    	Logger.VerboseLog(TAG, getClass().getSimpleName() + ":entered onResume()");
		super.onResume();
		
		mTitle = "About";
		mMessage = "Add text here";
	}

	@Override
	protected void onStart() {
    	Logger.VerboseLog(TAG, getClass().getSimpleName() + ":entered onStart()");
		super.onStart();
	}

	@Override
	protected void onStop() {
    	Logger.VerboseLog(TAG, getClass().getSimpleName() + ":entered onPause()");
		super.onStop();
	}

	@Override
	abstract public void onButtonClick(ExpandableListMetaButton metabutton);
}
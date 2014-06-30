package com.example.app_android;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ListFragment;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class FragmentNewStudent extends ListFragment{
	
	private static final String TAG = "NewStudentFragment";
	private InterfaceListSelectionListener mListener = null;

	private String[] mNewStudentArray;
		
	@Override
	public void onListItemClick(ListView l, View v, int pos, long id) {
		getListView().setItemChecked(pos, true);
		mListener.onListSelection(pos);
	}

	@Override
	public void onAttach(Activity activity) {
    	Logger.VerboseLog(TAG, getClass().getSimpleName() + ":entered onAttach()");
		super.onAttach(activity);
		
		try {
			mListener = (InterfaceListSelectionListener) activity;
		} catch (ClassCastException e) {
			throw new ClassCastException(activity.toString()+ " must implement OnArticleSelectedListener");
		}
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
    	Logger.VerboseLog(TAG, getClass().getSimpleName() + ":entered onCreate()");
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    	Logger.VerboseLog(TAG, getClass().getSimpleName() + ":entered onCreateView()");
		return super.onCreateView(inflater, container, savedInstanceState);
	}


	@Override
	public void onActivityCreated(Bundle savedState) {
    	Logger.VerboseLog(TAG, getClass().getSimpleName() + ":entered onActivityCreated()");
		super.onActivityCreated(savedState);
		connectTask task = new connectTask();
        task.execute();
        ShowDetails(0);
	}

	@Override
	public void onStart() {
    	Logger.VerboseLog(TAG, getClass().getSimpleName() + ":entered onStart()");
		super.onStart();
	}

	@Override
	public void onResume() {
    	Logger.VerboseLog(TAG, getClass().getSimpleName() + ":entered onResume()");
		super.onResume();
	}

	@Override
	public void onPause() {
    	Logger.VerboseLog(TAG, getClass().getSimpleName() + ":entered onPause()");
		super.onPause();
	}

	@Override
	public void onStop() {
    	Logger.VerboseLog(TAG, getClass().getSimpleName() + ":entered onStop()");
		super.onStop();
	}

	@Override
	public void onDetach() {
    	Logger.VerboseLog(TAG, getClass().getSimpleName() + ":entered onDetach()");
		super.onDetach();
	}

	@Override
	public void onDestroy() {
    	Logger.VerboseLog(TAG, getClass().getSimpleName() + ":entered onDestroy()");
		super.onDestroy();
	}

	@Override
	public void onDestroyView() {
    	Logger.VerboseLog(TAG, getClass().getSimpleName() + ":entered onDestroyView()");
		super.onDestroyView();
	}
	
	private void ShowDetails(int index)
	{
			FragmentNewStudentContent a = (FragmentNewStudentContent) getFragmentManager().findFragmentByTag("FragmentNewStudentContent");
	}
	
	/*
     * AsyncTask for connecting to server and print response in log
     */
    public class connectTask extends AsyncTask<Void, Void, String[]> {
    	//ProgressDialog mProgressDialog;
    	
    	@Override
		protected void onPreExecute() {
			super.onPreExecute();
		}
    	//Connect to server and handle response
		@Override
		protected String[] doInBackground(Void... params) {
			URL url;
			String inputLine = "";
			String result = "";
			String[] lDataArray = null;
			ArrayList<String> finalResult = new ArrayList<String>();
			try {
				url = new URL("http://194.47.131.73/database-files-and-server-script/Script/newstudent.php");
				
				HttpURLConnection urlCon = (HttpURLConnection)url.openConnection();
				InputStream inStream = urlCon.getInputStream();
				BufferedReader readBuff = new BufferedReader(new InputStreamReader(inStream));
				while((inputLine = readBuff.readLine()) != null) {
					result = result + inputLine;
				}			
				JSONArray jsonArray = new JSONArray(result);
				for (int i = 0; i < jsonArray.length(); i++) {
					JSONObject jsonObject = jsonArray.getJSONObject(i);					
					finalResult.add(jsonObject.getString("header"));
				}
				lDataArray = (String[]) finalResult.toArray(new String[finalResult.size()]);
				
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
			return lDataArray;
		}

		@Override
		protected void onProgressUpdate(Void... values) {
			// TODO Auto-generated method stub
			super.onProgressUpdate(values);
		}
		
		@Override
		protected void onPostExecute(String[] result) {
			mNewStudentArray = result;
			setListAdapter(new ArrayAdapter<String>(getActivity(), R.layout.item_main, mNewStudentArray));
			getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
			super.onPostExecute(result);
		}
    }
}
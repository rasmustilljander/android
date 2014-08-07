package com.example.app_android.database;

import java.util.ArrayList;

public interface IFavouriteCourseTable {
	
	public boolean add(String courseCode) throws DBException, NullPointerException;
	
	public boolean remove(String courseCode);
	
	public ArrayList<String> getAll();
	
	public boolean isEmpty();
}
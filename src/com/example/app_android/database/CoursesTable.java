package com.example.app_android.database;

import java.util.ArrayList;

import com.example.app_android.CourseBean;
import com.example.app_android.util.Utilities;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class CoursesTable extends BaseTable implements ICourseTable{

	private static final String TABLE_NAME = "courses";
	
	private static final String COLUMN_COURSE_CODE 			= "courseCode";
	private static final String COLUMN_COURSE_NAME 			= "courseName";
	private static final String COLUMN_COURSE_RESPONSIBLE 	= "courseResponsible";
	private static final String COLUMN_COURSE_START_DATE 	= "startDate";
	private static final String COLUMN_COURSE_END_DATE 		= "endDate";
	private static final String COLUMN_COURSE_LITERATURE 	= "courseLiterature";
	private static final String COLUMN_COURSE_NEXT_EXAM_DATE = "nextExamDate";
	private static final String COLUMN_COURSE_DESCRIPTION 	= "courseDescription";
    
    private static final String COULUMN_COURSE_CODE_TYPE 		= "VARCHAR(8) PRIMARY KEY";
    private static final String COLUMN_COURSE_NAME_TYPE 		= "VARCHAR(255)";
    private static final String COLUMN_COURSE_RESPONSIBLE_TYPE 	= "VARCHAR(50)";
    private static final String COLUMN_COURSE_START_DATE_TYPE 	= "VARCHAR(10)";
    private static final String COLUMN_COURSE_END_DATE_TYPE 	= "VARCHAR(10)";
    private static final String COLUMN_COURSE_LITERATURE_TYPE 	= "VARCHAR(255)";
    private static final String COLUMN_COURSE_NEXT_EXAM_DATE_TYPE = "VARCHAR(10)";
    private static final String COLUMN_COURSE_DESCRIPTION_TYPE 	= "TEXT";
    
	private static final String LOCAL_CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " " +
			"("+
				COLUMN_COURSE_CODE	 			+ " " + 	COULUMN_COURSE_CODE_TYPE 		+", " 	+
				COLUMN_COURSE_NAME 				+ " " + 	COLUMN_COURSE_NAME_TYPE  		+", " 	+
				COLUMN_COURSE_RESPONSIBLE		+ " " + 	COLUMN_COURSE_RESPONSIBLE_TYPE 	+", " 	+
				COLUMN_COURSE_START_DATE 		+ " " + 	COLUMN_COURSE_START_DATE_TYPE 	+", " 	+
				COLUMN_COURSE_END_DATE 			+ " " + 	COLUMN_COURSE_END_DATE_TYPE 	+", " 	+
				COLUMN_COURSE_LITERATURE 		+ " " + 	COLUMN_COURSE_LITERATURE_TYPE 	+", " 	+
				COLUMN_COURSE_NEXT_EXAM_DATE 	+ " " + 	COLUMN_COURSE_NEXT_EXAM_DATE_TYPE +", " +
				COLUMN_COURSE_DESCRIPTION 		+ " " + 	COLUMN_COURSE_DESCRIPTION_TYPE 	+
			")";
	
	private static final String RETRIEVE_COURSE = "select * from " + TABLE_NAME + " where " + COLUMN_COURSE_CODE + " = ?";
	
	public CoursesTable(SQLiteOpenHelper SQLiteOpenHelper) {
		super(SQLiteOpenHelper);
		SQL_CREATE_TABLE = LOCAL_CREATE_TABLE;
		SQL_DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
	}
	
	@Override
	public void fillTableWithDefaultData(SQLiteDatabase db) {
		super.fillTableWithDefaultData(db);
		int defaultValueCount = 6;
		
		ContentValues[] values = new ContentValues[defaultValueCount];
		for (int i = 0; i < defaultValueCount; ++i) {
			values[i] = new ContentValues();
		}
		
		//	TODO - remove test data
		values[0].put(COLUMN_COURSE_CODE, "dr1337");
		values[0].put(COLUMN_COURSE_NAME, "testName");
		values[0].put(COLUMN_COURSE_RESPONSIBLE, "testPerson");
		values[0].put(COLUMN_COURSE_START_DATE, "2014-07-01");
		values[0].put(COLUMN_COURSE_END_DATE, "2015-03-30");
		values[0].put(COLUMN_COURSE_LITERATURE, "testBook");
		values[0].put(COLUMN_COURSE_NEXT_EXAM_DATE, "2014-07-01");
		values[0].put(COLUMN_COURSE_DESCRIPTION, "THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!");
		
		values[1].put(COLUMN_COURSE_CODE, "PA1001");
		values[1].put(COLUMN_COURSE_NAME, "dr Alpack ameditati on");
		values[1].put(COLUMN_COURSE_RESPONSIBLE, "Baron & Otto");
		values[1].put(COLUMN_COURSE_START_DATE, "2015-07-01");
		values[1].put(COLUMN_COURSE_END_DATE, "2015-08-30");
		values[1].put(COLUMN_COURSE_LITERATURE, "Free your fluffy mind - Utgåva 3");
		values[1].put(COLUMN_COURSE_NEXT_EXAM_DATE, "2014-08-30");
		values[1].put(COLUMN_COURSE_DESCRIPTION, "It's so fluffy I'm gonna die!!!");
		
		values[5].put(COLUMN_COURSE_CODE, "PA1002");
		values[5].put(COLUMN_COURSE_NAME, "Alpackameditation");
		values[5].put(COLUMN_COURSE_RESPONSIBLE, "Baron & Otto");
		values[5].put(COLUMN_COURSE_START_DATE, "2015-07-01");
		values[5].put(COLUMN_COURSE_END_DATE, "2015-08-30");
		values[5].put(COLUMN_COURSE_LITERATURE, "Free your fluffy mind - Utgåva 3");
		values[5].put(COLUMN_COURSE_NEXT_EXAM_DATE, "2014-08-30");
		values[5].put(COLUMN_COURSE_DESCRIPTION, "It's so fluffy I'm gonna die!!!");
		
		values[2].put(COLUMN_COURSE_CODE, "dr1489");
		values[2].put(COLUMN_COURSE_NAME, "testName");
		values[2].put(COLUMN_COURSE_RESPONSIBLE, "testPerson");
		values[2].put(COLUMN_COURSE_START_DATE, "2014-07-01");
		values[2].put(COLUMN_COURSE_END_DATE, "2015-03-30");
		values[2].put(COLUMN_COURSE_LITERATURE, "testBook");
		values[2].put(COLUMN_COURSE_NEXT_EXAM_DATE, "2014-07-01");
		values[2].put(COLUMN_COURSE_DESCRIPTION, "THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!");
		
		values[3].put(COLUMN_COURSE_CODE, "dr1338");
		values[3].put(COLUMN_COURSE_NAME, "hestName");
		values[3].put(COLUMN_COURSE_RESPONSIBLE, "testPerson");
		values[3].put(COLUMN_COURSE_START_DATE, "2014-07-01");
		values[3].put(COLUMN_COURSE_END_DATE, "2015-03-30");
		values[3].put(COLUMN_COURSE_LITERATURE, "testBook");
		values[3].put(COLUMN_COURSE_NEXT_EXAM_DATE, "2014-07-01");
		values[3].put(COLUMN_COURSE_DESCRIPTION, "THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!");
	
		values[4].put(COLUMN_COURSE_CODE, "dr1339");
		values[4].put(COLUMN_COURSE_NAME, "drestName");
		values[4].put(COLUMN_COURSE_RESPONSIBLE, "testPerson");
		values[4].put(COLUMN_COURSE_START_DATE, "2014-07-01");
		values[4].put(COLUMN_COURSE_END_DATE, "2015-03-30");
		values[4].put(COLUMN_COURSE_LITERATURE, "testBook");
		values[4].put(COLUMN_COURSE_NEXT_EXAM_DATE, "2014-07-01");
		values[4].put(COLUMN_COURSE_DESCRIPTION, "THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!");
		
		db.beginTransaction();
		
		for (int i = 0; i < defaultValueCount; ++i) {
			db.insert(TABLE_NAME, null, values[i]);
		}

		db.setTransactionSuccessful();
		db.endTransaction();
	}
	
	@Override
	public ArrayList<String> getAllCourseCodes() {
		if(Utilities.verbose) {Log.v(TAG, mClass + ":getAllCourseCodes()");}
		ArrayList<String> courseCodes = new ArrayList<String>();
		
		SQLiteDatabase db = mHelper.getReadableDatabase();
		String[] columns = {COLUMN_COURSE_CODE};
		Cursor cursor = db.query(TABLE_NAME, columns, null, null, null, null, null);
		
		int index;
		while(cursor.moveToNext()) {
			index = cursor.getColumnIndex(COLUMN_COURSE_CODE);
			String courseCode = cursor.getString(index);
			courseCodes.add(courseCode);
		}
		db.close();
		return courseCodes;
	};
	
	@Override
	public ArrayList<String> getAllCourseNames() {
		if(Utilities.verbose) {Log.v(TAG, mClass + ":getAllCourseNames()");}
		ArrayList<String> courseNames = new ArrayList<String>();
		
		SQLiteDatabase db = mHelper.getReadableDatabase();
		String[] columns = {COLUMN_COURSE_NAME};
		Cursor cursor = db.query(TABLE_NAME, columns, null, null, null, null, null);
		
		int index;
		while(cursor.moveToNext()) {
			index = cursor.getColumnIndex(COLUMN_COURSE_NAME);
			String courseCode = cursor.getString(index);
			courseNames.add(courseCode);
		}
		db.close();
		return courseNames;
	};
	
	@Override
	public CourseBean getCourse(String courseCode) {
		if(Utilities.verbose) {Log.v(TAG, mClass + ":getCourse()");}
		
		SQLiteDatabase db = mHelper.getReadableDatabase();
		CourseBean fetchedCourse = null;
		
		Cursor cursor = db.rawQuery(RETRIEVE_COURSE, new String[] { courseCode });
		if (cursor.moveToFirst()) {
			fetchedCourse = new CourseBean(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3),
					cursor.getString(4), cursor.getString(5), cursor.getString(6), cursor.getString(7));
		}
		
		db.close();
		return fetchedCourse;
	}
}
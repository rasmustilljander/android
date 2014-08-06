package com.example.app_android.database;

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
		db.beginTransaction();
		
		//	TODO - remove test data
		ContentValues values = new ContentValues();
		values.put(COLUMN_COURSE_CODE, "testCode");
		values.put(COLUMN_COURSE_NAME, "testName");
		values.put(COLUMN_COURSE_RESPONSIBLE, "testPerson");
		values.put(COLUMN_COURSE_START_DATE, "2014-07-01");
		values.put(COLUMN_COURSE_END_DATE, "2015-03-30");
		values.put(COLUMN_COURSE_LITERATURE, "testBook");
		values.put(COLUMN_COURSE_NEXT_EXAM_DATE, "2014-07-01");
		values.put(COLUMN_COURSE_DESCRIPTION, "THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!");
		/*long result = */db.insert(TABLE_NAME, null, values);
		
		values.put(COLUMN_COURSE_CODE, "PA1001");
		values.put(COLUMN_COURSE_NAME, "Alpackameditation");
		values.put(COLUMN_COURSE_RESPONSIBLE, "Baron & Otto");
		values.put(COLUMN_COURSE_START_DATE, "2015-07-01");
		values.put(COLUMN_COURSE_END_DATE, "2015-08-30");
		values.put(COLUMN_COURSE_LITERATURE, "Free your fluffy mind - Utgåva 3");
		values.put(COLUMN_COURSE_NEXT_EXAM_DATE, "2014-08-30");
		values.put(COLUMN_COURSE_DESCRIPTION, "Move along, nothing to see here!");
		/*long result = */db.insert(TABLE_NAME, null, values);

		db.setTransactionSuccessful();
		db.endTransaction();
	}
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
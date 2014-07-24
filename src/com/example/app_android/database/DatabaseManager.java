package com.example.app_android.database;   

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseManager extends SQLiteOpenHelper{
		
	/*
	 * HOW TO ADD A NEW TABLE to this databasemanager
	 * 1. Add the new table to the enum
	 * 2. Create a new <TableClass> that derives from BaseTable.
	 * 3. Create an interface, <ITableClass> that will be used for the rest of the application to use this class, 
	 * 	this should contain access function to the DB ex. "void getCity(int i)", "boolean isTableEmpty()"
	 * 4. Add an allocation entry in the constructor of this file.
	 * 5. Create method in this class called "get<TableClass>" in which returns the type <ITableClass>
	 * 6. The newly created function "get<TableClass>" should call the private function getTable with an enum.
	 * 
	 * 
	 *  * Decided to NOT return BaseTable or derived class.
     *  * As this would result in public access to create and drop table, which is not very nice.
     *  * Could not come up with a way which would be less tricky than this. Im sorry for the inconvenience.
     *  
     *  Good fun and have luck
     *  
     *  Rasmus Tilljander - tilljander.rasmus@gmail.com
	 */
          
    private static String DB_NAME = "bthapp.sqlite";
	private static final int DB_VERSION = 1;
    private static BaseTable[] TABLES;
    private static DatabaseManager mDatabaseManager;
    
    public enum TableIndex {
        TOKEN (0), 
        COURSES (1);
        
        private final int index;
        private TableIndex(int index) {this.index = index;}        
        public int getIndex() {return index;}        
    }
    
    // Singleton getinstance
    public static DatabaseManager getInstance(Context context) {
    	if(mDatabaseManager == null)
    		mDatabaseManager = new DatabaseManager(context);
    	return mDatabaseManager;
    }

    // Constructor
    private DatabaseManager(Context context) {	     
	    super(context, DB_NAME, null, DB_VERSION);
	    
	    // Allocate array
	    TABLES = new BaseTable[TableIndex.values().length];
	    
	    // Create specific table
	    TABLES[0] = new TokenTable(this);
	    
    }
      
    private BaseTable getTable(TableIndex table) {
    	return TABLES[table.getIndex()];
    }
    
    /* 
     * Decided to NOT return BaseTable or derived class.
     * As this would result in public access to create and drop table, which is not very nice.
     */
    public ITokenTable getTokenTable() {
    	return (ITokenTable)getTable(TableIndex.TOKEN);
    }
    
    /*
     * Overridden functions from  SQLiteOpenHelper
     */     
    @Override
    public void onCreate(SQLiteDatabase db) {
	    for(int i = 0; i < TABLES.length; i++) {
			TABLES[i].createTable(db);
	    }
	    
	    for(int i = 0; i < TABLES.length; i++) {
			TABLES[i].fillTableWithDefaultData(db);
	    }	    
    }
    
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
	    for(int i = 0; i < TABLES.length; i++) {
			TABLES[i].dropTable(db);
	    }
        onCreate(db);
    }
    
    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }   
}
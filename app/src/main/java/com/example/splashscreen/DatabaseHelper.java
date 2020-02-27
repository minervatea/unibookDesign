package com.example.splashscreen;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    /** columns in the database, you can see it visually by using DB Browser for SQL **/

    public static final String DATABASE_NAME = "courses.db";
    public static final String TABLE_NAME = "course_table";
    public static final String ID = "ID";
    public static final String COURSE_NAME = "NAME";


    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table " + TABLE_NAME +"(ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    /** This inserts data from user input to the database **/
    public boolean insertData(String coursename){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COURSE_NAME,coursename);
    long result = db.insert(TABLE_NAME,null,contentValues);
    if(result == -1)
        return false;
    else
        return true;
    }

    /** View all data that has been added **/
    public Cursor getAllData(){
        /** Cursor class : This interface provides random read-wrtie access to the result set returned by a database query **/
        /** This will get the database and show it to user **/

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME, null); // what's cursor class?
        return res;
    }

    /** built-in database delete method returns an integer **/
    public Integer deleteData (String courseName){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "NAME = ?",new String[] {courseName});

    }
}

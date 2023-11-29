package com.example.nolan_rayner_sean_brasil_finalproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {
    // creating a constant variables for our database.
// below variable is for our database name.
    private static final String DB_NAME = "birdDB";
    // below int is our database version
    private static final int DB_VERSION = 1;
    // below variable is for our table name.
    private static final String TABLE_NAME = "mybirds";
    private static final String ID_COL = "id";
    private static final String NAME_COL = "name";
    private static final String LOCATION_COL = "location";
    private static final String DESCRIPTION_COL = "description";
    private static final String STATUS_COL = "status";

    // creating a constructor for our database handler.
    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }
    // below method is for creating a database by running a sqlite query
    @Override
    public void onCreate(SQLiteDatabase db) {
// on below line we are creating
// an sqlite query and we are
// setting our column names
// along with their data types.
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_COL + " TEXT,"
                + LOCATION_COL + " TEXT,"
                + DESCRIPTION_COL + " TEXT,"
                + STATUS_COL + " TEXT)";
// at last we are calling a exec sql
// method to execute above sql query
        db.execSQL(query);
    }

    // this method is use to add new bird to our sqlite database.
    public void addNewBird(String birdName, String birdLocation, String
            birdDescription, String birdStatus) {
// on below line we are creating a variable for
// our sqlite database and calling writable method
// as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();
// on below line we are creating a
// variable for content values.
        ContentValues values = new ContentValues();
// on below line we are passing all values
// along with its key and value pair.
        values.put(NAME_COL, birdName);
        values.put(LOCATION_COL, birdLocation);
        values.put(DESCRIPTION_COL, birdDescription);
        values.put(STATUS_COL, birdStatus);
// after adding all values we are passing
// content values to our table.
        db.insert(TABLE_NAME, null, values);
// at last we are closing our
// database after adding database.
        db.close();
    }
    // we have created a new method for reading all the courses.
    public ArrayList<BirdModel> readCourses() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursorBirds = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        ArrayList<BirdModel> birdModalArrayList = new ArrayList<>();
        if (cursorBirds.moveToFirst()) {
            do {
                birdModalArrayList.add(new
                        BirdModel(cursorBirds.getString(1),
                        cursorBirds.getString(2),
                        cursorBirds.getString(4),
                        cursorBirds.getString(3)));
            } while (cursorBirds.moveToNext());
// moving our cursor to next.
        }
// at last closing our cursor
// and returning our array list.
        cursorBirds.close();
        return birdModalArrayList;
    }

    // below is the method for updating our courses
    public void updateCourse(String originalBirdName, String birdName, String
            birdDescription,String birdStatus, String birdLocation)
    {
// calling a method to get writable database.
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
// on below line we are passing all values
// along with its key and value pair.
        values.put(NAME_COL, birdName);
        values.put(LOCATION_COL, birdLocation);
        values.put(DESCRIPTION_COL, birdDescription);
        values.put(STATUS_COL, birdStatus);
// on below line we are calling a update method to update our database and passing our values.
// and we are comparing it with name of our bird which is stored in original name variable.
        db.update(TABLE_NAME, values, "name=?", new String[]
                {originalBirdName});
        db.close();
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
// this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    // below is the method for deleting our bird.
    public void deleteCourse(String birdName) {
// on below line we are creating
// a variable to write our database.
        SQLiteDatabase db = this.getWritableDatabase();
// on below line we are calling a method to delete our
// course and we are comparing it with our course name.
        db.delete(TABLE_NAME, "name=?", new String[]{birdName});
        db.close();
    }
}

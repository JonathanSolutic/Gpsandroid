package com.example.gpscoordonate;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHelper extends SQLiteOpenHelper{
    private static final String DATABASE_NAME = "coordinates.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "Coordinates";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_POINT = "point";
    private static final String COLUMN_LATITUDE = "latitude";
    private static final String COLUMN_LONGITUDE = "longitude";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_LATITUDE + " REAL, " +
                COLUMN_POINT+ " TEXT, " +
                COLUMN_LONGITUDE + " REAL)";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void insertCoordinates(double latitude, double longitude, String point) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_LATITUDE, latitude);
        values.put(COLUMN_POINT, point);
        values.put(COLUMN_LONGITUDE, longitude);
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

}

package com.example.android.pets.data;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class PetDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "shelter.db";

    public static final String TEXT_TYPE = "TEXT";
    public static final String COMMA_SEP = ",";
    public static final String SQL_CREATE_ENTRIES = "CREATE TABLE " + PetContract.PetEntry.TABLE_NAME + " (" +
            PetContract.PetEntry._ID + " INTEGER PRIMARY KEY" + COMMA_SEP + PetContract.PetEntry.COLUMN_PET_NAME + " TEXT NOT NULL"
             + COMMA_SEP + PetContract.PetEntry.COLUMN_PET_BREED + " " + TEXT_TYPE + COMMA_SEP + PetContract.PetEntry.COLUMN_PET_GENDER
             + " INTEGER NOT NULL" + COMMA_SEP + PetContract.PetEntry.COLUMN_PET_WEIGHT + " INTEGER NOT NULL DEFAULT 0);";

    public static final String SQL_DELETE_ENTRIES = "DROP TABLE " + PetContract.PetEntry.TABLE_NAME + ";";

    public PetDbHelper(android.content.Context context){
        super( context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(SQL_DELETE_ENTRIES);
        onCreate(sqLiteDatabase);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}

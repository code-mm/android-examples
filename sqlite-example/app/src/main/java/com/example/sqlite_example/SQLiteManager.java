package com.example.sqlite_example;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class SQLiteManager {

    private static final SQLiteManager manager = new SQLiteManager();

    public static SQLiteManager getInstance() {
        return manager;
    }


    private static int VERSION = 1;

    private  interface SQL {

        String DATABASE_NAME = "user-database";
        String TABLE_NAME = "user";
        String ID = "_id";
        String NAME = "name";
        String AGE = "age";
        String SEX = "sex";
        String CITY = "city";


    }


    static class SQLDataBase extends SQLiteOpenHelper {


        public SQLDataBase(Context context) {
            super(context, SQL.DATABASE_NAME, null, VERSION);
        }


        public SQLDataBase(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        public SQLDataBase(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version, @Nullable DatabaseErrorHandler errorHandler) {
            super(context, name, factory, version, errorHandler);
        }

        public SQLDataBase(@Nullable Context context, @Nullable String name, int version, @NonNull SQLiteDatabase.OpenParams openParams) {
            super(context, name, version, openParams);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {

            db.execSQL("create table user(" + SQL.ID + " int ,"
                    + SQL.NAME + " varchar ,"
                    + SQL.AGE + "int )");


        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }


}

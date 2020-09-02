package com.example.roomdb;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Employee.class}, version = 1)         //для каждого Entity класса из списка entities будет создана таблица, можно указывать через запятую
public abstract class AppDatabase extends RoomDatabase {
   private static AppDatabase database;
    private static final String DB_NAME = "database1.db";
    private static final Object LOCK = new Object();

    public static AppDatabase getInstance(Context context) {
        synchronized (LOCK) {
            if (database == null) {
                database = Room.databaseBuilder(context, AppDatabase.class, DB_NAME).build(); //убрать разрешение на работу в главном потоке!.allowMainThreadQueries()
            }
        }
        return database;
    }

    public abstract EmployeeDao employeeDao();
}

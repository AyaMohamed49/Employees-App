package com.example.assignmentemployees;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DepartmentDBHelper extends SQLiteOpenHelper {

    private static String databaseName="departmentDatabase";
    SQLiteDatabase departmentDatabase;

    public DepartmentDBHelper(Context context)
    {
        super(context, databaseName,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table department(DeptID integer primary key autoincrement," +
                " name text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("drop table if exists department");
        onCreate(sqLiteDatabase);

    }
}

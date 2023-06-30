package com.example.assignmentemployees;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class EmployeeDBHelper extends SQLiteOpenHelper {

    private static String databaseName="employeeDatabase";
    SQLiteDatabase employeeDatabase;

    public EmployeeDBHelper(Context context)
    {
        super(context, databaseName,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table employee (EmpID integer primary key autoincrement , " +
                "Name text not null , Title text not null , Phone text not null , " +
                "Email text not null , Dept_id integer, FOREIGN KEY(Dept_id) REFERENCES Department (DeptID))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("drop table if exists employee");
        onCreate(sqLiteDatabase);
    }

    public void createNewEmployee(String name,String title, String phone,String email, int deptID)
    {
        ContentValues row =new ContentValues();
        row.put("Name",name);
        row.put("Title",title);
        row.put("Phone",phone);
        row.put("Email",email);
        row.put("Dept_id",deptID);

        employeeDatabase=getWritableDatabase();
        employeeDatabase.insert("employee",null,row);
        employeeDatabase.close();
    }

    public Cursor fetchAllEmployee()
    {
        employeeDatabase=getReadableDatabase();
        String[] rowDetails={"Name","Title","Phone","Email","Dept_id","EmpID"};
        Cursor cursor=employeeDatabase.query("employee",rowDetails,null,null,null,null,null);
        if (cursor!= null)
            cursor.moveToFirst();
        employeeDatabase.close();
        return cursor;
    }
}

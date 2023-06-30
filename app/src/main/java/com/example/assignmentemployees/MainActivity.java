package com.example.assignmentemployees;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    EmployeeDBHelper employeeDB;
    Button addEmp, search;
    EditText name, title, phone, email, id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addEmp = findViewById(R.id.btnAdd);
        search = findViewById(R.id.btnSearch);
        name = findViewById(R.id.edit_name);
        email = findViewById(R.id.edit_email);
        phone = findViewById(R.id.edit_phone);
        title = findViewById(R.id.edit_title);
        id = findViewById(R.id.edit_id);

        employeeDB = new EmployeeDBHelper(this);

        addEmp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                employeeDB.createNewEmployee(name.getText().toString(), title.getText().toString(),
                        phone.getText().toString(), email.getText().toString(), Integer.parseInt(id.getText().toString()));

                Toast.makeText(MainActivity.this, "Employee Added", Toast.LENGTH_LONG).show();
            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent SearchEmp =new Intent(MainActivity.this,HomeActivity.class);
                startActivity(SearchEmp);
            }
        });

    }



    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }
}



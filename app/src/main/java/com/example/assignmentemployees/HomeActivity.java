package com.example.assignmentemployees;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.MenuItemCompat;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Locale;

public class HomeActivity extends AppCompatActivity {

    ArrayList<String> listView;
    ArrayAdapter<String> adapter;
    ListView employeeList;
    SearchView myviewSearch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        myviewSearch=findViewById(R.id.search_view);
        employeeList=findViewById(R.id.my_list);

        listView.add("A");
        listView.add("m");
        listView.add("jj");

        adapter =new ArrayAdapter<String>(HomeActivity.this,
                android.R.layout.simple_list_item_1,listView);

        employeeList.setAdapter(adapter);

        myviewSearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                adapter.getFilter().filter(newText);
                return false;
            }
        });


    }

}
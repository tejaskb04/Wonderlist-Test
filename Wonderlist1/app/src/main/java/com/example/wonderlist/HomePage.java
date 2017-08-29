package com.example.wonderlist;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ListViewCompat;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends AppCompatActivity implements createCatDialog.Communicator {

    List categories = new ArrayList();
    ArrayAdapter adapter;
    ListView listView;
    createCatDialog dialog;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_dashboard:
                    return true;
                case R.id.navigation_notifications:
                    return true;
                case R.id.navigation_search:
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        listView = (ListView) findViewById(R.id.cat_list);


        adapter = new ArrayAdapter(HomePage.this, android.R.layout.simple_list_item_1, categories);
        listView.setAdapter(adapter);


    }

    public void createCategory(View view){
        android.app.FragmentManager manager = getFragmentManager();
        dialog = new createCatDialog();
        dialog.show(manager, "MyDialog");


    }

    @Override
    public void addCategory(String newTitle) {
        categories.add(newTitle);
        listView.setAdapter(adapter);
    }
}

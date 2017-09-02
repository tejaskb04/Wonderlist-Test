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

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import java.io.FileWriter;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends AppCompatActivity implements createCatDialog.Communicator, DeleteWarningDialog.ItemCommunicator, EditCatDialog.itemEditor {

    List categories = new ArrayList();
    CatAdapter adapter;
    ListView listView;
    createCatDialog dialog;
    Scanner scan;
    InputStream catList;
    FileWriter write;


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

        //read categories in from file
        try {
            catList = getApplicationContext().getAssets().open("categories");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            write = new FileWriter(this.getFileStreamPath("categories"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        scan = new Scanner(catList);
        while (scan.hasNextLine()){
            String line = scan.nextLine();
            categories.add(line);
        }


        adapter = new CatAdapter(categories, HomePage.this);
        listView.setAdapter(adapter);

    }

    public void createCategory(View view){
        android.app.FragmentManager manager = getFragmentManager();
        dialog = new createCatDialog();
        dialog.show(manager, "MyDialog");


    }

    @Override
    public void addCategory(String newTitle) throws IOException {
        categories.add(newTitle);
        write.append(newTitle);
    }

    @Override
    public void removeCategory(boolean b, int position) {
        if (b){
            categories.remove(position);
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void changeItem(int pos, String newName) {
        categories.set(pos, newName);
        adapter.notifyDataSetChanged();
    }
}

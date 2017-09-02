package com.example.wonderlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class CategoryMainActivity extends AppCompatActivity {
    List items = new ArrayList();
    ItemAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_main);

        ListView listItem = (ListView) findViewById(R.id.item_list);
        adapter = new ItemAdapter();
        listItem.setAdapter(adapter);
    }
}

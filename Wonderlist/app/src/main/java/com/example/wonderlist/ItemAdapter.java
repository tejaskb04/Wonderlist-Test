package com.example.wonderlist;

import android.content.Context;
import android.support.constraint.solver.ArrayLinkedVariables;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Falak on 9/2/17.
 */

public class ItemAdapter extends BaseAdapter implements ListAdapter {
    private List items  = new ArrayList();
    private Context context;
    int position;

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0; //User entered items
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = view;
        position = i;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.list_category_layout, null);
        }

        ImageButton mapView = (ImageButton) v.findViewById(R.id.map_btn);
        ImageButton galView = (ImageButton) v.findViewById(R.id.gal_btn);

        //code to set dynamic image for galView and mapView

        mapView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //code to open map
            }
        });
        galView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //code to open gallery

            }
        });

        TextView title = (TextView) v.findViewById(R.id.catTitle);
        title.setText(items.get(i).toString());
        return v;
    }

}

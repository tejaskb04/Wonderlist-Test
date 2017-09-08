package com.example.wonderlist;

import android.content.Context;
import android.support.constraint.solver.ArrayLinkedVariables;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Falak on 9/2/17.
 */

public class ItemAdapter extends BaseAdapter implements ListAdapter {
    private List items  = new ArrayList();
    private Context context;
    int position;
    Random rand;
    int color;
    LinearLayout lay;
    ItemDialog d;
    FragmentActivity activity;
    android.app.FragmentManager manager;

    public ItemAdapter(List list, Context context){
        items = list;
        this.context = context;
        activity = (FragmentActivity) context;
        manager = activity.getFragmentManager();
    }

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
    public View getView(final int i, View view, ViewGroup viewGroup) {
        View v = view;
        position = i;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.list_category_layout, null);
        }


        TextView title = (TextView) v.findViewById(R.id.catTitle);
        title.setText(items.get(i).toString());
        title.setTextSize(20);

        title.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                d = new ItemDialog();
                d.name = items.get(i).toString();
                d.show(manager, "ItemDialog");
            }
        });
        lay = (LinearLayout) v.findViewById(R.id.linearLayout);

        rand = new Random();
        color = rand.nextInt(5);

        if(color==0){
            lay.setBackgroundResource(R.drawable.item_border);
        }
        else if (color==1){
            lay.setBackgroundResource(R.drawable.item_border2);
        }
        else if (color==2){
            lay.setBackgroundResource(R.drawable.item_border3);
        }
        else if (color==3){
            lay.setBackgroundResource(R.drawable.item_border4);
        }
        else {
            lay.setBackgroundResource(R.drawable.item_border5);
        }

        return v;
    }

}

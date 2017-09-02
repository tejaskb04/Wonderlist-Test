package com.example.wonderlist;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Falak on 8/29/17.
 */

public class CatAdapter extends BaseAdapter implements ListAdapter {
    private List categories = new ArrayList();
    private Context context;
    int position;
    DeleteWarningDialog dialog;
    EditCatDialog dialogEdit;
    FragmentActivity activity;
    FragmentManager manager;

    public CatAdapter(List list, Context c){
        categories = list;
        context = c;
        activity = (FragmentActivity) context;
        manager = activity.getFragmentManager();
    }

    @Override
    public int getCount() {
        return categories.size();
    }

    @Override
    public Object getItem(int i) {
        return categories.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0; //user created list has no item ID
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        View v = view;
        position = i;
        if (view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.list_item_layout, null);
        }

        final TextView listItem = (TextView) v.findViewById(R.id.list_item_string);
        listItem.setText(categories.get(i).toString());

        ImageButton editName = (ImageButton) v.findViewById(R.id.edit_btn);
        ImageButton deleteCat = (ImageButton) v.findViewById(R.id.delete_btn);

        deleteCat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog = new DeleteWarningDialog();
                dialog.position = i;
                dialog.show(manager, "DeleteDialog");

            }
        });

        editName.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                dialogEdit = new EditCatDialog();
                dialogEdit.currentName = categories.get(position).toString();
                dialogEdit.show(manager, "EditDialog");
            }
        });

        listItem.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                //open new activity specific to that category
            }
        });

    return v;
    }

}

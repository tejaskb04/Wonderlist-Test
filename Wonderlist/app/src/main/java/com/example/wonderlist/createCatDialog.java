package com.example.wonderlist;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;

public class createCatDialog extends DialogFragment implements View.OnClickListener{
    private Button cancel, setNew;
    private EditText edit;
    private Communicator communicator;
    private Typeface tf;

    public void onAttach(Activity activity){
        super.onAttach(activity);
        communicator = (Communicator) activity;
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_create_cat_dialog, null);
        tf = Typeface.createFromAsset(getActivity().getApplicationContext().getAssets(), "fonts/JosefinSans-Bold.ttf");

        cancel = (Button) view.findViewById(R.id.cancelButton);
        cancel.setTypeface(tf);
        setNew = (Button) view.findViewById(R.id.setCatButton);
        setNew.setTypeface(tf);
        cancel.setOnClickListener(this);
        setNew.setOnClickListener(this);
        edit = (EditText) view.findViewById(R.id.editNewCat);
        edit.setTypeface(tf);
        edit.setTextSize(25);

        setCancelable(false);
        return view;
    }

    public void onClick(View view){
        if(view.getId()==R.id.cancelButton){
            dismiss();

        }
        else {
            String title = edit.getText().toString();
            try {
                communicator.addCategory(title);
            } catch (IOException e) {
                e.printStackTrace();
            }
            dismiss();

        }
    }

    interface Communicator{
        void addCategory(String newTitle) throws IOException;
    }
}

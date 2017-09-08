package com.example.wonderlist;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by Falak on 9/8/17.
 */

public class ItemDialog extends DialogFragment implements View.OnClickListener {
    String name = "";
    ImageButton mapView, galView;
    TextView place;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_item, null);

        place = (TextView) view.findViewById(R.id.title_text);
        place.setText(name);
        mapView = (ImageButton) view.findViewById(R.id.map_btn);
        galView = (ImageButton) view.findViewById(R.id.gal_btn);

        mapView.setOnClickListener(this);
        galView.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.map_btn){
            //start map activity
        }
        else {
            //start gallery activity
        }

    }
}

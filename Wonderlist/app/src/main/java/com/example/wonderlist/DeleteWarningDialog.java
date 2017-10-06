package com.example.wonderlist;

import android.app.Activity;
import android.app.DialogFragment;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Falak on 8/30/17.
 */

public class DeleteWarningDialog extends DialogFragment implements OnClickListener {
    private Button cancel, ok;
    ItemCommunicator communicator;
    int position;
    private TextView warn;

    public void onAttach(Activity activity){
        super.onAttach(activity);
        communicator = (ItemCommunicator) activity;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_delete_warning, null);
        Typeface tf = Typeface.createFromAsset(getActivity().getApplicationContext().getAssets(), "fonts/JosefinSans-Regular.ttf");
        Typeface tfBold = Typeface.createFromAsset(getActivity().getApplicationContext().getAssets(), "fonts/JosefinSans-Bold.ttf");

        cancel = (Button) view.findViewById(R.id.cancel_btn);
        cancel.setTypeface(tfBold);
        ok = (Button) view.findViewById(R.id.ok_btn);
        ok.setTypeface(tfBold);
        cancel.setOnClickListener(this);
        ok.setOnClickListener(this);

        warn = (TextView) view.findViewById(R.id.textViewWarn);
        warn.setTypeface(tf);
        warn.setTextSize(25);

        setCancelable(false);
        return view;
    }



    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.ok_btn){
            communicator.removeCategory(true, position);
            dismiss();
        }
        else {
            dismiss();
        }

    }

    interface ItemCommunicator {
        void removeCategory(boolean b, int position);
    }
}

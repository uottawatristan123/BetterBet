package com.betterbet.betterbet;


import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class CollectWinningsFragment extends Fragment {

    TextView balance_text;
    Button collect_button;
    Button add_button;



    public static CollectWinningsFragment newInstance() {
        CollectWinningsFragment fragment = new CollectWinningsFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_collect_winnings, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstancestate){
        super.onActivityCreated(savedInstancestate);

        balance_text = (TextView) getView().findViewById(R.id.balance_text);
        collect_button = (Button) getView().findViewById(R.id.credit_winnings_button);
        add_button = (Button) getView().findViewById(R.id.add_funds_button);

        collect_button.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                Context context = getContext();
                AlertDialog dialog = new AlertDialog.Builder(context).create();
                dialog.setTitle("Collect your winnings");
                dialog.setMessage("Are you sure you want to collect your winnings? This will withdraw all credit from your account");
                dialog.setButton(AlertDialog.BUTTON_POSITIVE, "Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        balance_text.setText("$0.00");
                        dialogInterface.dismiss();
                    }
                });

                dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                dialog.show();
            }
        });

        add_button.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                Context context = getContext();
                AlertDialog dialog = new AlertDialog.Builder(context).create();
                dialog.setTitle("Add funds");
                dialog.setMessage("Please confirm that you would like to add funds to your account");
                dialog.setButton(AlertDialog.BUTTON_POSITIVE, "Confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });

                dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });

                dialog.show();
            }
        });
    }
}

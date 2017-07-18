package com.betterbet.betterbet;


import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



//        Tristan comments delete (Example on were to add business logic)

        final View view = inflater.inflate(R.layout.fragment_home, container, false);
        CardView myLiveBets = (CardView) view.findViewById(R.id.liveBetsOne);

        myLiveBets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Context context = getContext();
                final Dialog dialog;
                dialog = new Dialog(context);
                dialog.setContentView(R.layout.game_info_dialog);

                Button close = (Button)dialog.findViewById(R.id.close);
      dialog.setTitle("Quick Bet");

                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

        dialog.show();

            }
        });

        CardView featuredGames = (CardView)view.findViewById(R.id.featuredGamesOne);

        featuredGames.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Context context = getContext();
                final Dialog dialog;
                dialog = new Dialog(context);
                dialog.setContentView(R.layout.quick_bet_dialog);

                Button close = (Button)dialog.findViewById(R.id.close);
                Button confirm = (Button)dialog.findViewById(R.id.betButton);
                final TextInputLayout amountToBet = (TextInputLayout)dialog.findViewById(R.id.amountToBet);
                final EditText betAmount = (EditText)dialog.findViewById(R.id.bet_amount);
                dialog.setTitle("Quick Bet");

                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();

            }

        });
                confirm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (betAmount.getText().toString().isEmpty()   ){
                            amountToBet.setError("You must enter an amount to bet.");
                        }
                        else if ( betAmount.getText().toString().equals("0")){
                            amountToBet.setError("You must bet higher than zero !");
                        }
                        else{
                            Toast.makeText(getContext(),"Your bet of $"+betAmount.getText().toString()+ " has been placed.",Toast.LENGTH_LONG ).show();
                            dialog.dismiss();
                        }
                    }
                });
                dialog.show();
            }
        });
//        TextInputLayout editText2 = (TextInputLayout) view.findViewById(R.id.input_layout_1);

//        ..........Place business logic here

       return view;


        // Inflate the layout for this fragment


//        return inflater.inflate(R.layout.fragment_home, container, false);
    }

}

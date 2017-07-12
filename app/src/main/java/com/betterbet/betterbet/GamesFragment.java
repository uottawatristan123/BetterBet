package com.betterbet.betterbet;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class GamesFragment extends Fragment {


    public static GamesFragment newInstance() {
        GamesFragment fragment = new GamesFragment();
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

//        final View view = inflater.inflate(R.layout.fragment_welcome, container, false);
//
//        TextInputLayout editText2 = (TextInputLayout) view.findViewById(R.id.input_layout_1);

//        ..........Place business logic here

//        return view;

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_games, container, false);
    }

}

package com.betterbet.betterbet;


import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyBetsFragment extends Fragment {

    private ListView gamesList;
    ArrayAdapter<Game> gamesListAdapter;
    private ArrayList<Game> games = new ArrayList<Game>();


    public static MyBetsFragment newInstance() {
        MyBetsFragment fragment = new MyBetsFragment();
        return fragment;
    }

    public MyBetsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        final View view = inflater.inflate(R.layout.fragment_my_bets, container, false);

        return inflater.inflate(R.layout.fragment_my_bets, container, false);


    }

    @Override
    public void onActivityCreated(Bundle savedInstancestate){
        super.onActivityCreated(savedInstancestate);
        gamesList = (ListView) getView().findViewById(R.id.gamesList);
        final Context context = getContext();

        createGames();

        gamesListAdapter = new CustomAdapter(context, games);


        gamesList.setAdapter(gamesListAdapter);

        //Action when ListItem is clicked
        gamesList.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id){

                        Game game = (Game) parent.getItemAtPosition(position);

                        final Dialog dialog = new Dialog(context);
                        dialog.setTitle("Quick Bet");
                        dialog.setContentView(R.layout.game_info_dialog);
                        dialog.show();


                    }
                }
        );
    }

    public void createGames(){
        Game first = new Game("Date", "", "", "Odds", "Odds");
        games.add(first);
        for(int i =0; i<5; i++){
            Game gameToAdd = new Game();
            games.add(gameToAdd);
        }
    }

}

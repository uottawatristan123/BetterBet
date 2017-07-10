package com.betterbet.betterbet;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class GamesList extends AppCompatActivity {

    private ListView gamesList;

    private ArrayList<Game> games = new ArrayList<Game>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games_list);

        gamesList = (ListView) findViewById(R.id.gamesList);

        createGames();

        ListAdapter gamesListAdapter = new CustomAdapter(this, games);

        gamesList.setAdapter(gamesListAdapter);

        //Action when ListItem is clicked
        gamesList.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                        String game = String.valueOf(parent.getItemAtPosition(position));
                        Toast.makeText(GamesList.this, game, Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    public void createGames(){
        for(int i =0; i<30; i++){
            Game gameToAdd = new Game();
            games.add(gameToAdd);
        }
    }
}

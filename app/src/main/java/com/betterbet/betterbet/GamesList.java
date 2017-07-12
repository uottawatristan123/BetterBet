package com.betterbet.betterbet;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class GamesList extends AppCompatActivity {

    private ListView gamesList;
    private Spinner filter_spinner;
    ArrayAdapter<Game> gamesListAdapter;

    private ArrayList<Game> games = new ArrayList<Game>();
    private ArrayList<Game> filteredGames1 = new ArrayList<Game>();
    private ArrayList<Game> filteredGames2 = new ArrayList<Game>();
    private ArrayList<Game> filteredGames3 = new ArrayList<Game>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games_list);

        gamesList = (ListView) findViewById(R.id.gamesList);
        filter_spinner = (Spinner) findViewById(R.id.filter_spinner);



        spinnerSetup();
        createGames();
        createFilteredGames();

        gamesListAdapter = new CustomAdapter(this, games);


        gamesList.setAdapter(gamesListAdapter);



        //Action when ListItem is clicked
        gamesList.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id){

                        Game game = (Game) parent.getItemAtPosition(position);

                        final Dialog dialog = new Dialog(GamesList.this);
                        dialog.setTitle("Quick Bet");
                        dialog.setContentView(R.layout.quick_bet_dialog);

                        final RadioButton left_team_name = (RadioButton) dialog.findViewById(R.id.left_team_name);
                        final RadioButton right_team_name = (RadioButton) dialog.findViewById(R.id.right_team_rdo);

                        left_team_name.setText(game.getLeftTeamName());
                        right_team_name.setText(game.getRightTeamName());



                        Button betButton = (Button) dialog.findViewById(R.id.betButton);
                        betButton.setOnClickListener(new View.OnClickListener(){
                            @Override
                            public void onClick(View v){
                                //When Bet Button is clicked
                                //Should probably show message saying bet went through
                                Log.d("LOG", "Bet Accepted");
                            }
                        });

                        dialog.show();


                    }
                }
        );

        //When filter is applied to the games
        filter_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d("LOG", "Filter applied");
                games.clear();
                createGames();
                gamesListAdapter.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }


    public void createGames(){
        Game first = new Game("Date", "", "", "Odds", "Odds");
        games.add(first);
        for(int i =0; i<30; i++){
            Game gameToAdd = new Game();
            games.add(gameToAdd);
        }
    }

    public void createFilteredGames(){
        Game first = new Game("Date", "", "", "Odds", "Odds");
        filteredGames1.add(first);
        filteredGames2.add(first);
        filteredGames3.add(first);
        for(int i =0; i<30; i++){
            Game gameToAdd = new Game();
            filteredGames1.add(gameToAdd);
        }
        for(int i =0; i<30; i++){
            Game gameToAdd = new Game();
            filteredGames2.add(gameToAdd);
        }
        for(int i =0; i<30; i++){
            Game gameToAdd = new Game();
            filteredGames3.add(gameToAdd);
        }
    }

    public void spinnerSetup(){
        List<String> filters = new ArrayList<String>();
        filters.add("All");
        filters.add("Hockey");
        filters.add("Basketball");
        filters.add("Football");
        filters.add("Baseball");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, filters);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        filter_spinner.setAdapter(dataAdapter);
    }
}

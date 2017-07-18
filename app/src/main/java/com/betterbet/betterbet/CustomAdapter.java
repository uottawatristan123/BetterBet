package com.betterbet.betterbet;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;


class CustomAdapter extends ArrayAdapter<Game>{
    private TypedArray imgs;

    CustomAdapter(Context context, ArrayList<Game> game){
        super(context, R.layout.custom_game_row, game);
        imgs = context.getResources().obtainTypedArray(R.array.teams);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater rowInflater = LayoutInflater.from(getContext());
        View customView = rowInflater.inflate(R.layout.custom_game_row, parent, false);

        String left_team_odds_str = getItem(position).getLeftTeamOdds();
        String left_team_name_str = getItem(position).getLeftTeamName();
        String date_time = getItem(position).getTime();
        String date_str = getItem(position).getDate();
        String right_team_odds_str = getItem(position).getRightTeamOdds();
        String right_team_name_str = getItem(position).getRightTeamName();


        TextView left_team_odds = (TextView) customView.findViewById(R.id.left_team_odds);
        TextView left_team_name = (TextView) customView.findViewById(R.id.left_team_name);
        TextView time = (TextView) customView.findViewById(R.id.time);
        TextView date = (TextView) customView.findViewById(R.id.date);
        TextView right_team_odds = (TextView) customView.findViewById(R.id.right_team_odds);
        TextView right_team_name = (TextView) customView.findViewById(R.id.right_team_name);

        ImageView left_team_img = (ImageView) customView.findViewById(R.id.left_team_img);
        ImageView right_team_img = (ImageView) customView.findViewById(R.id.right_team_img);

        left_team_odds.setText(left_team_odds_str);
//        left_team_name.setText(left_team_name_str);
        time.setText(date_time);
        date.setText(date_str);
//        right_team_name.setText(right_team_name_str);
        right_team_odds.setText(right_team_odds_str);

        left_team_img.setImageResource(getImageID());
        right_team_img.setImageResource(getImageID());


        return customView;
    }

    public int getImageID(){
        final Random random = new Random();
        final int rndInt = random.nextInt(imgs.length());
        return  imgs.getResourceId(rndInt, 0);
    }



}

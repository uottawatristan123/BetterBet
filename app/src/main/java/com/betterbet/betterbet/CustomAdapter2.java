package com.betterbet.betterbet;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;


class CustomAdapter2 extends ArrayAdapter<Game>{

    CustomAdapter2(Context context, ArrayList<Game> game){
        super(context, R.layout.custom_game_row, game);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater rowInflater = LayoutInflater.from(getContext());
        View customView = rowInflater.inflate(R.layout.custom_game_row, parent, false);

        String left_team_odds_str = getItem(position).getLeftTeamOdds();
        String left_team_name_str = getItem(position).getLeftTeamName();
        boolean completed = getItem(position).getCompleted();
        String date_time = null;
        String date_str=null;
        if(!completed) {
            date_time = getItem(position).getTime();
            date_str = getItem(position).getDate();
        } else {
            date_time = "Completed";
            date_str = "45 - 10";
        }
        String right_team_odds_str = getItem(position).getRightTeamOdds();
        String right_team_name_str = getItem(position).getRightTeamName();


        TextView left_team_odds = (TextView) customView.findViewById(R.id.left_team_odds);
        TextView left_team_name = (TextView) customView.findViewById(R.id.left_team_name);
        TextView time = (TextView) customView.findViewById(R.id.time);
        TextView date = (TextView) customView.findViewById(R.id.date);
        TextView right_team_odds = (TextView) customView.findViewById(R.id.right_team_odds);
        TextView right_team_name = (TextView) customView.findViewById(R.id.right_team_name);

        FrameLayout frm1 = (FrameLayout) customView.findViewById(R.id.frm1);
        LinearLayout lin1 = (LinearLayout) customView.findViewById(R.id.lin1);
        FrameLayout frm2 = (FrameLayout) customView.findViewById(R.id.frm2);
        LinearLayout lin2 = (LinearLayout) customView.findViewById(R.id.lin2);
        Random ran = new Random();
        int ranNum = ran.nextInt(2);

        Random ran2 = new Random();
        int ranNum2 = ran2.nextInt(4);

        if(ranNum==0){
            if(completed) {
                if(ranNum2<1)
                {
                    frm1.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.potentialLoss));
                    lin1.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.potentialLoss));
                }else{
                    frm1.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.potentialWining));
                    lin1.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.potentialWining));
                }
            } else {
                frm1.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.potentialOutcome));
                lin1.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.potentialOutcome));
            }
        }else{
            if(completed) {
                if(ranNum2<1)
                {
                    frm2.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.potentialLoss));
                    lin2.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.potentialLoss));
                }else{
                    frm2.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.potentialWining));
                    lin2.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.potentialWining));
                }
            } else {
                frm2.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.potentialOutcome));
                lin2.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.potentialOutcome));
            }
        }

        left_team_odds.setText(left_team_odds_str);
//        left_team_name.setText(left_team_name_str);
        time.setText(date_time);
        date.setText(date_str);
//        right_team_name.setText(right_team_name_str);
        right_team_odds.setText(right_team_odds_str);


        return customView;
    }



}

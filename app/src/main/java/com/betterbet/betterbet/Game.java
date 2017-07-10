package com.betterbet.betterbet;

import java.util.Random;

public class Game {
    //Class variables
    private String left_team_odds;
    private String left_team_name;
    private String date;
    private String right_team_name;
    private String right_team_odds;

    private String[] teams = new String[]
            {
                    "Sens",
                    "Leafs",
                    "Pens",
                    "Canucks",
                    "Flames",
                    "Habs",
                    "Nets",
                    "Heat",
                    "Warriors",
                    "Lakers",
                    "Furry",
                    "White Caps",
                    "Bills",
                    "Pats",
                    "Yankees",
                    "Cowboys",
                    "Knicks",
                    "Redskins",
                    "Giants",
                    "76ers",
                    "Clippers",
                    "Packers",
                    "Wizards",
                    "49ers",
                    "Mets",
                    "Raptors",
                    "Cavaliers",
                    "Chargers",
                    "Dodgers",
                    "Mavericks",
                    "Pistons",
                    "Rams",
                    "Red Sox",
                    "Tigers",
                    "Celtics",
                    "Raiders",
                    "Bears"
            };
    private String[] months = new String[]
            {
                    "January",
                    "February",
                    "March",
                    "April",
                    "May",
                    "June",
                    "July",
                    "August",
                    "September",
                    "October",
                    "November",
                    "December"
            };

    public Game(){
        this.left_team_name = generateRandomTeam();
        this.right_team_name = generateRandomTeam();
        this.date = generateRandomDate();
        this.right_team_odds = generateRandomOdds();
        this.left_team_odds = generateRandomOdds();
    }

    public String generateRandomTeam(){
        Random random = new Random();
        int index = random.nextInt(teams.length);
        return teams[index];
    }

    public String generateRandomOdds(){
        int low = 0;
        int high = 1000;
        Random random = new Random();
        int num = random.nextInt(high - low + 1);
        return Integer.toString(num);
    }

    public String generateRandomDate(){
        String day;
        String month;
        String year = "2017";

        Random rday = new Random();
        int dayInt = rday.nextInt(30);

        Random rMonth = new Random();
        int mIndex = rMonth.nextInt(months.length);
        month = months[mIndex];

        String toReturn = Integer.toString(dayInt);
        toReturn.concat(month + " ,");
        toReturn.concat(year);

        return toReturn;
    }

    public String getLeftTeamOdds(){
        return this.left_team_odds;
    }

    public String getRightTeamOdds(){
        return this.right_team_odds;
    }

    public String getLeftTeamName(){
        return this.left_team_name;
    }

    public String getRightTeamName(){
        return this.right_team_name;
    }

    public String getDate(){
        return this.date;
    }


}

package com.betterbet.betterbet;

import java.util.Random;

public class Game {
    //Class variables
    private String left_team_odds;
    private String left_team_name;
    private String time;
    private String date;
    private String right_team_name;
    private String right_team_odds;
    private boolean completed;

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
                    "Whites",
                    "Bills",
                    "Pats",
                    "Yankees",
                    "Cowboys",
                    "Knicks",
                    "Reds",
                    "Giants",
                    "76ers",
                    "Clips",
                    "Packs",
                    "49ers",
                    "Mets",
                    "Rapts",
                    "Cavs",
                    "Mavs",
                    "Pistons",
                    "Rams",
                    "Red Sox",
                    "Tigers",
                    "Celtics",
                    "Raids",
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
        this.time = generateRandomTime();
        this.date = generateRandomDate();
        Random randomNum = new Random();
        int result = randomNum.nextInt(2);
        if(result == 0) {
            this.right_team_odds = "-"+generateRandomOdds();
            this.left_team_odds = "+"+generateRandomOdds();
        } else {
            this.right_team_odds = "+"+generateRandomOdds();
            this.left_team_odds = "-"+generateRandomOdds();
        }
        Random ranNum = new Random();
        int ranNumR = ranNum.nextInt(3);
        if(ranNumR==0){
            this.completed = true;
        } else
        {
            this.completed = false;
        }
    }

    public Game(String date, String lTeam, String rTeam, String right_team_odds, String left_team_odds){
        this.date = date;
        this.left_team_name = lTeam;
        this.right_team_name = rTeam;
        this.right_team_odds = right_team_odds;
        this.left_team_odds = left_team_odds;
    }

    public String generateRandomTeam(){
        Random random = new Random();
        int index = random.nextInt(teams.length);
        return teams[index];
    }

    public String generateRandomOdds(){
        int low = 100;
        int high = 1000;
        Random random = new Random();
        int num = random.nextInt(high - low + 1);
        return Integer.toString(num);
    }

    public String generateRandomTime(){
        String time;

        Random rTime = new Random();
        int timeInt = rTime.nextInt(10)+1;

        String toReturn = timeInt + ":00 pm";
        return toReturn;
    }

    public String generateRandomDate(){
        String day;
        String month;
        String year = "2017";

        Random rday = new Random();
        int dayInt = rday.nextInt(30)+1;

        Random rmonth = new Random();
        int monthInt = rday.nextInt(12)+1;

//        Random rMonth = new Random();
//        int mIndex = rMonth.nextInt(months.length);
//        month = months[mIndex];

        String toReturn = dayInt + "/" + monthInt + "/" + year;
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

    public String getTime () { return this.time; }

    public boolean getCompleted () { return this.completed; }


}

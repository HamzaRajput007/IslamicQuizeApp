package com.school.islamicquizeapp;

import java.util.ArrayList;

public class GameLevel {

    String videoID ;
    ArrayList<Question> questionsList = new ArrayList<>();
    int LevelNumber;

    public GameLevel(String videoID, ArrayList<Question> questionsList, int levelNumber) {
        this.videoID = videoID;
        this.questionsList = questionsList;
        LevelNumber = levelNumber;

    }


}

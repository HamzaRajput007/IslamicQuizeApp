package com.school.islamicquizeapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class VideoTutorial extends YouTubeBaseActivity {

    String videoId = "XQKFNFCsAAY";
    YouTubePlayerView youtubePlayerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_tutorial);

        youtubePlayerView = findViewById(R.id.youtubePlayerView);
        youtubePlayerView.initialize("AIzaSyAw0LcItvmAeAS6KLxP26cIrQfo9SXf9oA",
                new YouTubePlayer.OnInitializedListener() {
                    @Override
                    public void onInitializationSuccess(YouTubePlayer.Provider provider,
                                                        YouTubePlayer youTubePlayer, boolean b) {
                        youTubePlayer.cueVideo(videoId);
                    }

                    @Override
                    public void onInitializationFailure(YouTubePlayer.Provider provider,
                                                        YouTubeInitializationResult youTubeInitializationResult) {

                    }
                });

        Toast.makeText(this, "Reached Here !", Toast.LENGTH_LONG).show();
    }

    /*public void playVideo(final String videoId, YouTubePlayerView youTubePlayerView) {
        //initialize youtube player view

    }*/


}

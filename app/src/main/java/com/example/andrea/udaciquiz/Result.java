package com.example.andrea.udaciquiz;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.VideoView;

public class Result extends AppCompatActivity {

    @Override
    public void onBackPressed() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView scoreText = (TextView)findViewById(R.id.score_text);

        TextView messageBox = (TextView)findViewById(R.id.message_box);

        int score = getIntent().getExtras().getInt("result");

        scoreText.setText(MainActivity.nickName+", "+getString(R.string.score_message) + score);

        VideoView gif = (VideoView)findViewById(R.id.gif);


        if (score<6){

            Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.loose);
            gif.setVideoURI(uri);
            gif.setZOrderOnTop(true);
            gif.start();
            gif.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mp.setLooping(true);
                }
            });

            messageBox.setText(getString(R.string.loose_message));

        }else if (score<8){
            Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.good);
            gif.setVideoURI(uri);
            gif.setZOrderOnTop(true);
            gif.start();
            gif.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mp.setLooping(true);
                }
            });

            messageBox.setText(getString(R.string.good_message));
        }else{
            Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.win);
            gif.setVideoURI(uri);
            gif.setZOrderOnTop(true);
            gif.start();
            gif.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mp.setLooping(true);
                }
            });

            messageBox.setText(getString(R.string.win_message));
        }


    }
}

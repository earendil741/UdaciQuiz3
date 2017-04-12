package com.example.andrea.udaciquiz;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    static String nickName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText nickBox = (EditText)findViewById(R.id.nick_box);
        VideoView gif = (VideoView)findViewById(R.id.gif);
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.android_dance);
        gif.setVideoURI(uri);
        gif.setZOrderOnTop(true);
        gif.start();
        gif.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });

        Button startButton = (Button)findViewById(R.id.button_start);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nickBox.getText().toString().trim().length()==0){
                    nickName = getResources().getString(R.string.user_name);
                    Intent iStart = new Intent(MainActivity.this,QuizActivity.class);
                    startActivity(iStart);
                }else{
                    nickName = nickBox.getText().toString();
                    Intent iStart = new Intent(MainActivity.this,QuizActivity.class);
                    startActivity(iStart);}
            }
        });
    }
}

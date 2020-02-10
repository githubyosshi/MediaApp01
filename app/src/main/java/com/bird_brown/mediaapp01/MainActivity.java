package com.bird_brown.mediaapp01;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private MediaPlayer player; //メディアプレイヤー

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //MediaPlayerのオブジェクト生成
        //
        player = MediaPlayer.create(this,R.raw.music);

        //「再生」ボタンのオブジェクトの取得とイベントリスナ登録
        Button start = (Button)findViewById(R.id.button1);
        start.setOnClickListener(this);

        //「停止」ボタンのオブジェクト取得とイベントリスナ登録
        Button stop = (Button)findViewById(R.id.button2);
        stop.setOnClickListener(this);

        //「一時停止」ボタンのオブジェクトの取得とイベントリスナ登録
        Button pause = (Button)findViewById(R.id.button3);
        pause.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id =view.getId();   //押されたボタンのリソースIDを取得

        switch (id) {
            case R.id.button1 : //「再生」ボタンを押された時の処理
                if (!player.isPlaying()) {  //再生されていなければ
                    player.start();         //再生する
                }
                break;
            case R.id.button2 : //「停止」ボタンを押した時の処理
                if (player.isPlaying()) {   //再生されていれば
                    player.stop();          //停止処理を行う

                    try {
                        player.prepare();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    player.seekTo(0);   //巻き戻して最初から再生
                }
                break;
            case R.id.button3 : //「一時停止」ボタンを押した時の処理
                if (player.isPlaying()) {
                    player.pause();
                }
                break;
        }
    }
}

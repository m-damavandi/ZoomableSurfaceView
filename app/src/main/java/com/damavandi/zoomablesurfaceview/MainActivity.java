package com.damavandi.zoomablesurfaceview;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceHolder;

public class MainActivity extends AppCompatActivity implements SurfaceHolder.Callback {

    ZoomableSurfaceView surfaceView;
    private MediaPlayer mediaPlayer;
//    String path = "http://www.sample-videos.com/video/mp4/240/big_buck_bunny_240p_10mb.mp4";
    String path = "http://192.168.1.203/note5.mp4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        surfaceView = (ZoomableSurfaceView) findViewById(R.id.surfaceView);
        surfaceView.getHolder().addCallback(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        mediaPlayer = MediaPlayer.create(getApplicationContext(), Uri.parse(path), holder);
        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener(){
            public void onPrepared(MediaPlayer arg0) {
                mediaPlayer.start();
            }} );
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }
}

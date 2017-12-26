package mshopkeeper.misa.com.vn.demomutimedia;

import android.annotation.SuppressLint;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements SurfaceHolder.Callback, MediaPlayer.OnPreparedListener {

    String videoSource =
            "https://sites.google.com/site/androidexample9/download/RunningClock.mp4";

    MediaPlayer mediaplayer;

    SurfaceView svVideo;

    SurfaceHolder surfaceHolder;

    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        svVideo=findViewById(R.id.svVideo);
        surfaceHolder = svVideo.getHolder();
        surfaceHolder.addCallback(this);

    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        mediaplayer=new MediaPlayer();
        mediaplayer.setDisplay(surfaceHolder);
        try {
            mediaplayer.setDataSource(videoSource);
            mediaplayer.prepare();
            mediaplayer.setOnPreparedListener(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

    }

    @Override
    public void onPrepared(MediaPlayer mediaPlayer) {
        mediaPlayer.start();
    }
}


package in.blogspot.tecnopandit.tutorialsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoPlayer extends AppCompatActivity {
VideoView vv;
MediaController mc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);
        vv=(VideoView)findViewById(R.id.videoView);
        mc=new MediaController(this);
        vv.setMediaController(mc);
        vv.setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.demovideo);
        vv.start();
    }
}

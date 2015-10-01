package rancherita.ooblinkoo.rancheritav2.views;

import android.app.FragmentTransaction;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import android.view.Menu;
import android.view.MenuItem;

import java.util.concurrent.TimeUnit;

import rancherita.ooblinkoo.rancheritav2.R;

//public class MainActivity extends ActionBarActivity {
    public class MainActivity extends AppCompatActivity  {
    private MediaPlayer mediaPlayer;
    public int song=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        mediaPlayer = MediaPlayer.create(this, R.raw.blink);
        mediaPlayer.setLooping(true);
        setContentView(R.layout.activity_main);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.MnuOpc1: {
                mediaPlayer.start();
                return true;
            }
            case R.id.MnuOpc2:{

                mediaPlayer.pause();

                return true;}
            case R.id.MnuOpc3:{
                if(song==0){
                    mediaPlayer.stop();
                    mediaPlayer=MediaPlayer.create(this, R.raw.ranchera);

                    mediaPlayer.start();
                    song++;
                }else{
                    mediaPlayer.stop();
                    mediaPlayer=MediaPlayer.create(this, R.raw.blink);
                    mediaPlayer.start();
                    song++;
                }

                return true;}
            default:
                return super.onOptionsItemSelected(item);
        }


    }


}

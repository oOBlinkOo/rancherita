package rancherita.ooblinkoo.rancheritav2.views;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.media.MediaPlayer;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.ListFragment;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


import java.util.ArrayList;
import java.util.List;

import rancherita.ooblinkoo.rancheritav2.R;
import rancherita.ooblinkoo.rancheritav2.views.demo.MyAdapter;

//public class MainActivity extends ActionBarActivity {
    public class MainActivity extends FragmentActivity implements ActionBar.TabListener {
    private MediaPlayer mediaPlayer;
    public int song=0;
    MyAdapter myAdapter;
    ViewPager mpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager);



        mediaPlayer = MediaPlayer.create(this, R.raw.blink);
        mediaPlayer.setLooping(true);

        final ActionBar actionBar = getActionBar();


        actionBar.setDisplayShowHomeEnabled(false);
        getActionBar().setDisplayShowTitleEnabled(false);

        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setNavigationMode(android.app.ActionBar.NAVIGATION_MODE_TABS);


        myAdapter= new MyAdapter(getSupportFragmentManager(),getFragments());
        mpager=(ViewPager)findViewById(R.id.pager);
        mpager.setAdapter(myAdapter);
        mpager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                // Coordinar el item del pager con la pestaña
                actionBar.setSelectedNavigationItem(position);
            }
        });

        for (int i = 0; i < myAdapter.getCount(); i++) {
            actionBar.addTab(
                    actionBar.newTab()
                            .setText(myAdapter.getPageTitle(i))
                            .setTabListener(this));

        }


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

    private List<ListFragment> getFragments()
    {
        List<ListFragment> listFragments = new ArrayList<ListFragment>();

        listFragments.add(new MyListFragment());
        listFragments.add(new MyListFragment());
        listFragments.add(new MyListFragment());

        return listFragments;
    }


    @Override
    public void onTabSelected(android.app.ActionBar.Tab tab, FragmentTransaction ft) {
        mpager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(android.app.ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(android.app.ActionBar.Tab tab, FragmentTransaction ft) {

    }
}

package ooblinkoo.swipe3;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.ListFragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity implements ActionBar.TabListener{
    static final int NUMBER_LIST=4;
    MyAdapter myAdapter;
    ViewPager mpager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ActionBar actionBar = getActionBar();
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
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

}

    private List<ListFragment> getFragments()
    {
        List<ListFragment> listFragments = new ArrayList<ListFragment>();

        listFragments.add(new NewsListFragment());
        listFragments.add(new NewsListFragment());
        listFragments.add(new NewsListFragment());

        return listFragments;
    }
}

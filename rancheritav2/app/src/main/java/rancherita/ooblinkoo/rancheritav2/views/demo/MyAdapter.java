package rancherita.ooblinkoo.rancheritav2.views.demo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import android.support.v4.app.ListFragment;

import java.util.List;

/**
 * Created by oOBlinkOo on 9/30/15.
 */
public class MyAdapter extends FragmentPagerAdapter {
    private List<ListFragment> datos;
    public MyAdapter(FragmentManager fm, List<ListFragment> datos) {
        super(fm);
        this.datos=datos;
    }

    @Override
    public Fragment getItem(int i) {
        return datos.get(i);
    }

    @Override
    public int getCount() {
        return 3;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        switch(position){
            case 0: return "Principales";
            case 1: return "Eagle Pass";
            case 2: return "Editoriales";
            default: return "";
        }
    }

}

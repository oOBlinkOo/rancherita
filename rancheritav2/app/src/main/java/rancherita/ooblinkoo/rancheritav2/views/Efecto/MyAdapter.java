package rancherita.ooblinkoo.rancheritav2.views.Efecto;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import rancherita.ooblinkoo.rancheritav2.R;

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

        switch (i) {
            case 1:
                // The first section of the app is the most interesting -- it offers
                // a launchpad into the other demonstrations in this example application.
                return datos.get(i);

            default:
                // The other sections of the app are dummy placeholders.
                Fragment fragment = new DummySectionFragment();
                Bundle args = new Bundle();
                args.putInt(DummySectionFragment.ARG_SECTION_NUMBER, i + 1);
                fragment.setArguments(args);
                return fragment;
        }




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

    public static class DummySectionFragment extends Fragment {

        public static final String ARG_SECTION_NUMBER = "section_number";

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_section_dummy, container, false);
            Bundle args = getArguments();
            ((TextView) rootView.findViewById(android.R.id.text1)).setText(
                    getString(R.string.dummy_section_text, args.getInt(ARG_SECTION_NUMBER)));
            return rootView;
        }
    }

}

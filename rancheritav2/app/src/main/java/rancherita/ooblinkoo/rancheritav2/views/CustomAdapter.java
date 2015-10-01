package rancherita.ooblinkoo.rancheritav2.views;

/**
 * Created by oOBlinkOo on 9/27/15.
 */

import android.app.Activity;
import android.content.Context;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import rancherita.ooblinkoo.rancheritav2.R;
import rancherita.ooblinkoo.rancheritav2.entities.Noticia;

public class CustomAdapter extends BaseAdapter {

    Context context;
    List<Noticia> rowItem;

    CustomAdapter(Context context, List<Noticia> rowItem) {
        this.context = context;
        this.rowItem = rowItem;

    }

    @Override
    public int getCount() {

        return rowItem.size();
    }

    @Override
    public Object getItem(int position) {

        return rowItem.get(position);
    }

    @Override
    public long getItemId(int position) {

        return rowItem.indexOf(getItem(position));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater) context
                    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.list_item, null);
        }

//        TextView fecha = (TextView) convertView.findViewById(R.id.fecha);
        TextView txtTitle = (TextView) convertView.findViewById(R.id.title);
        ImageView imageView = (ImageView)convertView.findViewById(R.id.icon);




        Noticia noticia = rowItem.get(position);
        // setting the image resource and title
//        fecha.setText(noticia.getFecha());
        txtTitle.setText(noticia.getTitulo());
        Picasso.with(context.getApplicationContext()).load(noticia.getImageURl()).into(imageView);


        return convertView;

    }

}

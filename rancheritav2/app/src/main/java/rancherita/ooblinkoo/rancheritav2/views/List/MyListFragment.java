package rancherita.ooblinkoo.rancheritav2.views.List;

/**
 * Created by oOBlinkOo on 9/27/15.
 */



import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;


import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import rancherita.ooblinkoo.rancheritav2.R;
import rancherita.ooblinkoo.rancheritav2.entities.Noticia;
import rancherita.ooblinkoo.rancheritav2.views.List.CustomAdapter;

public class MyListFragment extends ListFragment implements AdapterView.OnItemClickListener {


    private JSONArray news;

    CustomAdapter adapter;
    private List<Noticia> rowItems;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.list_fragment, null, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        callService2();
        getListView().setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {

        Toast.makeText(getActivity(), rowItems.get(position).getTitulo(), Toast.LENGTH_SHORT)
                .show();

    }

    public void callService2(){
//		ArrayList<String> aux;

        AsyncHttpClient client = new AsyncHttpClient();
        client.get("http://rancherita.com.mx/apiv2/fgt9bbcd8dgb99/news", new AsyncHttpResponseHandler() {

            //aqui va todo el codigo, es lo que pasa si hubo succes en el servicio web
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] response) {

                try {
                    String obj = new String(response); //el response es el json
                    news = new JSONArray(obj);
                    rowItems = new ArrayList<Noticia>();
                    for (int i = 0; i < news.length(); i++) {
                        JSONObject individualNew = (JSONObject) news.get(i);
                        String str = individualNew.getString("content");
                        Spanned sp = Html.fromHtml(str);
                        Noticia pro = new Noticia(individualNew.getString("title"),individualNew.getString("fecha"),individualNew.getString("foto_src"),individualNew.getString("content"));
                        rowItems.add(pro);
                    }
                    adapter = new CustomAdapter(getActivity(), rowItems);
                    setListAdapter(adapter);
//                    getListView().setOnItemClickListener(this);


                } catch (JSONException e) {
                    Log.i("Entro al ingresar", "esta falladno");
                    Toast.makeText(getActivity().getApplicationContext(), "error", Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(int i, org.apache.http.Header[] headers, byte[] bytes, Throwable throwable) {
                Log.i("Entro al ingresar", "esta falladno");

            }


        });

    }

}

package info.androidhive.materialtabs.fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import info.androidhive.materialtabs.R;
import info.androidhive.materialtabs.activity.ActividadDetalle;
import info.androidhive.materialtabs.activity.AdaptadorDeCoches;
import info.androidhive.materialtabs.activity.Coche;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class OneFragment extends Fragment implements AdapterView.OnItemClickListener {
    private GridView gridView;
    private AdaptadorDeCoches adaptador;


    public OneFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

          //  return inflater.inflate(R.layout.fragment_one, container, false);
        View rootView = inflater.inflate(R.layout.fragment_one, container, false);

        try {
            gridView = (GridView) rootView.findViewById(R.id.grid);
            adaptador = new AdaptadorDeCoches(this.getContext());
            gridView.setAdapter(adaptador);
            gridView.setOnItemClickListener(this);

        } catch (Exception e) {
            e.printStackTrace();
        }


        return rootView;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Coche item = (Coche) parent.getItemAtPosition(position);

        Intent intent = new Intent(this.getContext(), ActividadDetalle.class);
        intent.putExtra(ActividadDetalle.EXTRA_PARAM_ID, item.getId());

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            ActivityOptionsCompat activityOptions =
                    ActivityOptionsCompat.makeSceneTransitionAnimation(
                            this.getActivity(),
                            new Pair<View, String>(view.findViewById(R.id.imagen_coche),
                                    ActividadDetalle.VIEW_NAME_HEADER_IMAGE)
                    );

            ActivityCompat.startActivity(this.getActivity(), intent, activityOptions.toBundle());
        } else
            startActivity(intent);
    }

}

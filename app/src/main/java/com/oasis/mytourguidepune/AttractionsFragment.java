package com.oasis.mytourguidepune;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * {@link Fragment} that displays a list of number vocabulary words.
 */
public class AttractionsFragment extends Fragment {

    /* Empty constructor.*/
    public AttractionsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        // Create a list of locations
        final ArrayList<Location> locations = new ArrayList<Location>();

        locations.add(new Location(getString(R.string.shaniwarwada), R.drawable.shanivarwada, R.drawable.shanivarwada_details, getString(R.string.shaniwarawada_description)));

        locations.add(new Location(getString(R.string.sinhgad_fort), R.drawable.sinhagadfort, R.drawable.sinhagadfort_details,getString(R.string.sinhgad_description)));

        locations.add(new Location(getString(R.string.rajgad_fort), R.drawable.rajgadfort, R.drawable.rajgadfort_details, getString(R.string.rajgad_description)));

        locations.add(new Location(getString(R.string.parvati_hill), R.drawable.parvati, R.drawable.parvati_details, getString(R.string.parvati_description)));

        locations.add(new Location(getString(R.string.lal_mahal), R.drawable.lalmahal, R.drawable.lalmahal_details, getString(R.string.lal_mahal_description)));

        locations.add(new Location(getString(R.string.aga_khan_palace), R.drawable.agakhanpalace, R.drawable.agakhanpalace_details, getString(R.string.aga_khan_palace_description)));

        // Create an {@link WordAdapter}, whose data source is a list of {@link Location}s. The
        // adapter knows how to create list items for each item in the list.
        WordAdapter adapter = new WordAdapter(getActivity(), locations, R.color.category_attractions);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Location} in the list.
        listView.setAdapter(adapter);

        // Set a click listener to play the audio when the list item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Get the {@link Location} object at the given position the user clicked on
                Location location = locations.get(position);

                Intent intent = new Intent(getActivity(), SpecificDetailsActivity.class);
                intent.putExtra(getString(R.string.details_image_resource_id), location.getDetailsImageResourceId());
                intent.putExtra(getString(R.string.detais_text), location.getDetailsText());
                startActivity(intent);

            }
        });

        return rootView;
    }

}
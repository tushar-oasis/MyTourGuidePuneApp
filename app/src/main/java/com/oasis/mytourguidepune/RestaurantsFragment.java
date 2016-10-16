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
public class RestaurantsFragment extends Fragment {

    /* Empty constructor.*/
    public RestaurantsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        // Create a list of locations
        final ArrayList<Location> locations = new ArrayList<Location>();

        locations.add(new Location(getString(R.string.sukanta_thali), getString(R.string.deccan_gymkhana), "\n"+getString(R.string.sukanta_thali)+"\n" +
                getString(R.string.vegetarian_restaurant) +
                getString(R.string.sukanta_address) +
                getString(R.string.sukanta_contact)
        ));

        locations.add(new Location(getString(R.string.oaks_1000), getString(R.string.pune_camp),"\n" + getString(R.string.oaks_restaurant) +
                getString(R.string.oaks_address) +
                getString(R.string.oaks_contact)));

        locations.add(new Location(getString(R.string.durvankura_dining_hall), getString(R.string.sadashiv_peth),
                "\n"+getString(R.string.durvankura_dining_hall) +"\n" +
                getString(R.string.fine_dining_restaurant) +
                getString(R.string.durvankura_address) +
                getString(R.string.durvankura_contact)));

        // Create an {@link WordAdapter}, whose data source is a list of {@link Location}s. The
        // adapter knows how to create list items for each item in the list.
        WordAdapter adapter = new WordAdapter(getActivity(), locations, R.color.category_restaurants);

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
                intent.putExtra(getString(R.string.detais_text), location.getDetailsText());
                startActivity(intent);

            }
        });

        return rootView;
    }

}
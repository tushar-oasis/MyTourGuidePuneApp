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
public class HotelsFragment extends Fragment {

    /* Empty constructor.*/
    public HotelsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        // Create a list of locations
        final ArrayList<Location> locations = new ArrayList<Location>();

        locations.add(new Location(getString(R.string.the_westin), getString(R.string.koregaon_park), "\n"+getString(R.string.the_westin)+"\n\n" +
                getString(R.string.the_westin_address) +
                getString(R.string.the_westin_contact)));

        locations.add(new Location(getString(R.string.jw_mariott), getString(R.string.sbb_road), "\n"+getString(R.string.jw_hotel)+"\n\n" +
                getString(R.string.jw_address) +
                getString(R.string.jw_contact)));

        locations.add(new Location(getString(R.string.the_o_hotel), getString(R.string.koregaon_park), "\n"+getString(R.string.the_o_hotel)+"\n\n" +
                getString(R.string.the_o_address) +
                getString(R.string.the_o_contact)));
        locations.add(new Location(getString(R.string.hyatt), getString(R.string.kalyani_nagar), "\n"+getString(R.string.hyatt)+"\n\n" +
                getString(R.string.hyatt_address) +
                getString(R.string.hyatt_contact)));
        locations.add(new Location(getString(R.string.royal_orchid_central), getString(R.string.kalyani_nagar), "\n"+getString(R.string.royal_orchid_central)+"\n\n" +
                getString(R.string.royal_orchid_address) +
                getString(R.string.royal_orchid_contact)));

        // Create an {@link WordAdapter}, whose data source is a list of {@link Location}s. The
        // adapter knows how to create list items for each item in the list.
        WordAdapter adapter = new WordAdapter(getActivity(), locations, R.color.category_hotels);

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
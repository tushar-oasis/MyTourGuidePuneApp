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
 * A simple {@link Fragment} subclass.
 */
public class ParksFragment extends Fragment {

    // Constructor
    public ParksFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        final ArrayList<Location> locations = new ArrayList<Location>();

        locations.add(new Location(getString(R.string.rajiv_gandhi_zoological_park), getString(R.string.katraj), R.drawable.rajivgandhizoopark, R.drawable.rajivgandhizoopark_details, getString(R.string.rajiv_gandhi_park_decription)));

        locations.add(new Location(getString(R.string.the_empress_garden), getString(R.string.ghorpadi), R.drawable.empressgarden, R.drawable.empressgarden_details, getString(R.string.empress_garden_description)));

        locations.add(new Location(getString(R.string.pu_la_deshpande_garden), getString(R.string.sinhgad_road), R.drawable.pulagarden, R.drawable.pulagarden_details, getString(R.string.pu_la_garden_description)));

        // Create an {@link ArrayAdapter}, whose data source is a list of Strings. The
        // adapter knows how to create layouts for each item in the list, using the
        // simple_list_item_1.xml layout resource defined in the Android framework.
        // This list item layout contains a single {@link TextView}, which the adapter will set to
        // display a single word.
        WordAdapter adapter =
                new WordAdapter(getActivity(), locations, R.color.category_parks);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // activity_numbers.xml layout file.

        ListView listView = (ListView) rootView.findViewById(R.id.list);


        // Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
        // {@link ListView} will display list items for each word in the list of locations.
        // Do this by calling the setAdapter method on the {@link ListView} object and pass in
        // 1 argument, which is the {@link ArrayAdapter} with the variable name itemsAdapter.
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
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

    @Override
    public void onStop() {
        super.onStop();
    }



}

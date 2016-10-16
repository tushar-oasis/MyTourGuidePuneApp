package com.oasis.mytourguidepune;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Oasis on 03-10-2016.
 */

public class WordAdapter extends ArrayAdapter<Location> {

    /**
     * Resource Id for the background color of the textcontainer linear layout.
     */
    int mColorResouceId;

    public WordAdapter(Activity context, ArrayList<Location> locations, int colorResouceId) {
        super(context, 0, locations);
        mColorResouceId = colorResouceId;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Location currentLocation = getItem(position);

        LinearLayout textLinearLayout = (LinearLayout) listItemView.findViewById(R.id.textLinearLayout);
        textLinearLayout.setBackgroundColor(ContextCompat.getColor(getContext(), mColorResouceId));

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);

        if(currentLocation.hasImage()){
            imageView.setImageResource(currentLocation.getImageResourceId());
            imageView.setVisibility(View.VISIBLE);
        }else{
            imageView.setVisibility(View.GONE);
        }



        TextView nameOfPlace = (TextView) listItemView.findViewById(R.id.name_of_place);
        nameOfPlace.setText(currentLocation.getNameOfPlace());

        TextView addressofPlace = (TextView) listItemView.findViewById(R.id.address_of_place);
        addressofPlace.setText(currentLocation.getAddressOfPlace());

        return listItemView;
    }
}

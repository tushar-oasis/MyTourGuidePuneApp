package com.oasis.mytourguidepune;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Oasis on 06-10-2016.
 */

public class CategoryAdapter extends FragmentPagerAdapter {

    Context mContext;

    public CategoryAdapter(FragmentManager fm, Context context) {
        super(fm);
        mContext = context;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new AttractionsFragment();

            case 1:
                return new ParksFragment();

            case 2:
                return new HotelsFragment();

            case 3:
                return new RestaurantsFragment();

            default:
                return null;
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return mContext.getResources().getString(R.string.category_attractions);

            case 1:
                return mContext.getResources().getString(R.string.category_parks);

            case 2:
                return mContext.getResources().getString(R.string.category_hotels);

            case 3:
                return mContext.getResources().getString(R.string.category_restaurants);

            default:
                return mContext.getString(R.string.no_tab);
        }
    }
}

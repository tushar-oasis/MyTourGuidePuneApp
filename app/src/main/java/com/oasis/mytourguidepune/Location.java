package com.oasis.mytourguidepune;

/**
 * Created by Oasis on 03-10-2016.
 */

/**
 * Represents a vocabulary word that the user wants to learn.
 * It contains the default translation and a Miwok translation for that word.
 */

public class Location {

    /**
     * Name of the place
     */
    private String mNameOfPlace;

    /* Address of the place.*/
    private String mAddressOfPlace;

    /* Image for the word.*/
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    private int mDetailsImageResourceId = NO_IMAGE_PROVIDED;

    /* Details of the place.*/
    private String mDetailsText;

    /* Stores whether or not a word has an address.*/
    private boolean mHasImage = false;

    private static final int NO_IMAGE_PROVIDED = -1;


    /**
     * Constructor for attractions
     *
     * @param nameOfPlace
     * @param imageResourceId
     * @param detailsText
     */
    public Location(String nameOfPlace, int imageResourceId, int detailsImageResourceId,
                    String detailsText) {
        mNameOfPlace = nameOfPlace;
        mImageResourceId = imageResourceId;
        mDetailsImageResourceId = detailsImageResourceId;
        mDetailsText = detailsText;
        mAddressOfPlace = "";
    }

    /**
     * Constructor for all the other three categories.
     *
     * @param nameOfPlace
     * @param addressOfPlace
     * @param imageResourceId
     * @param detailsText
     */
    public Location(String nameOfPlace, String addressOfPlace, int imageResourceId, int detailsImageResourceId,
                    String detailsText) {
        mNameOfPlace = nameOfPlace;
        mAddressOfPlace = addressOfPlace;
        mImageResourceId = imageResourceId;
        mDetailsImageResourceId = detailsImageResourceId;
        mDetailsText = detailsText;
    }

    /**
     *
     * @param nameOfPlace
     * @param addressOfPlace
     * @param detailsText
     */
    public Location(String nameOfPlace, String addressOfPlace, String detailsText) {
        mNameOfPlace = nameOfPlace;
        mAddressOfPlace = addressOfPlace;
        mDetailsText = detailsText;
    }

    public String getNameOfPlace() {
        return mNameOfPlace;
    }

    public String getAddressOfPlace() {
        return mAddressOfPlace;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public int getDetailsImageResourceId() {return mDetailsImageResourceId;}

    public String getDetailsText() {
        return mDetailsText;
    }

    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }


}

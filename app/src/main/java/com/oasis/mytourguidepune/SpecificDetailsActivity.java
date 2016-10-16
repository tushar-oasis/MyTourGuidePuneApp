package com.oasis.mytourguidepune;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SpecificDetailsActivity extends AppCompatActivity {

    private int mImageResourceId;
    private String mSpecificDetails;
    private ImageView mImageView;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specific_details);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mImageView = (ImageView) findViewById(R.id.imageView);
        mTextView = (TextView) findViewById(R.id.textViewSpecificDetails);
        Intent intent = getIntent();
        mImageResourceId = intent.getIntExtra(getString(R.string.details_image_resource_id), 0);
        mSpecificDetails = intent.getStringExtra(getString(R.string.detais_text));

        if(mImageResourceId != 0){
            mImageView.setImageResource(mImageResourceId);
        } else{
            mImageView.setVisibility(View.GONE);
        }
        mTextView.setText(mSpecificDetails);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

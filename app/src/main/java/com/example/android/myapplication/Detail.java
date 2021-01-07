package com.example.android.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class Detail extends AppCompatActivity {
    // defining a key name for bundle to be used with intent
    public static final String KEY_EXTRA = "com.example.android.myapplication.KEY_BOOK";
    public static final String KEY_EXTRA_2 = "com.example.android.myapplication.KEY_BOOK_2";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_xml);

        // object for receiving bundle's data passed with intent
        Bundle bundle = null;

        // if receiving intent has key namely KEY_EXTRA then populate bundle object with it's data
        if(getIntent().hasExtra(KEY_EXTRA))
        {
            //retrieving content from received bundle object
            bundle = getIntent().getBundleExtra(KEY_EXTRA);
        }

        // if bundle has data then do the following.
        if(bundle!=null) {
            //bundle was holding string array so populating the res array for further use
            String[] res = bundle.getStringArray("key");

//            //setting up the image view in detail page
//            ImageView imageView = findViewById(R.id.detail_image);
//            imageView.setImageResource(Integer.parseInt(res[0]));

            //setting up the text view in detail page
            TextView textView = findViewById(R.id.place_detail);
            textView.setText(res[1]);
            textView.setLetterSpacing(0.05f);
            textView.setLineSpacing(2,1);
            textView.setMovementMethod(new ScrollingMovementMethod());

            //setting up the image view having geolocation in detail page
            ImageView imageView = findViewById(R.id.location_icon);
            //setting up OnClickListener on ImageView
            imageView.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("QueryPermissionsNeeded")
                @Override
                public void onClick(View v) {
                    //Creating intent to google map to open the geo location sent in URI format
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    Uri uri = Uri.parse(res[2]);
                    intent.setData(uri);
                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent);
                    }
                }
            });

            //Setting up the name of Place in toolbar defined in detail_xml file
            androidx.appcompat.widget.Toolbar detail_Toolbar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.detail_toolbar);
            detail_Toolbar.setTitle(res[3]);        // Setting title of appbar or toolbar
            setSupportActionBar(detail_Toolbar);

            // Enabling the UP button in toolbar using action bar and remember to add android:parentActivityName=".MainActivity" in manifest.xml
            // under the current activity.
            ActionBar actionBar = getSupportActionBar();
            assert actionBar != null;
            actionBar.setDisplayHomeAsUpEnabled(true);
        }


        if(getIntent().hasExtra(KEY_EXTRA_2))
        {
            int[] detail_images = getIntent().getIntArrayExtra(KEY_EXTRA_2);

            LinearLayout layout = (LinearLayout) findViewById(R.id.linear_image);
            for(int i=0; i< detail_images.length; i++)
            {
                ImageView imageView = new ImageView(this);
                int height = layout.getHeight();
                imageView.setMinimumHeight(height);
                imageView.setMaxHeight(height);

                int width =  layout.getWidth();
                imageView.setMinimumWidth(width);
                imageView.setMaxWidth(width);


                imageView.setId(i);
                imageView.setPadding(2,2,2,2);
                imageView.setImageBitmap(BitmapFactory.decodeResource(getResources(), detail_images[i]));
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                layout.addView(imageView);
            }
        }
    }
}
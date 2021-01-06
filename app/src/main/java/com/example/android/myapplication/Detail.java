package com.example.android.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Detail extends AppCompatActivity {
    public static final String KEY_EXTRA = "com.example.android.myapplication.KEY_BOOK";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_xml);

        Bundle bundle = null;
        if(getIntent().hasExtra(KEY_EXTRA))
        {
            bundle = getIntent().getBundleExtra(KEY_EXTRA);
        }
        if(bundle!=null) {
            String[] res = bundle.getStringArray("key");

            ImageView imageView = findViewById(R.id.detail_image);
            imageView.setImageResource(Integer.parseInt(res[0]));

            TextView textView = findViewById(R.id.place_detail);
            textView.setText(res[1]);
            textView.setMovementMethod(new ScrollingMovementMethod());

            imageView = findViewById(R.id.location_icon);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    Uri uri = Uri.parse(res[2]);
                    intent.setData(uri);
                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent);
                    }
                }
            });

            //Setting up the name of Place in toolbar
            androidx.appcompat.widget.Toolbar detail_Toolbar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.detail_toolbar);
            detail_Toolbar.setTitle(res[3]);
            setSupportActionBar(detail_Toolbar);

            // Enabling the UP button in toolbar using action bar
            ActionBar actionBar = getSupportActionBar();
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }
}
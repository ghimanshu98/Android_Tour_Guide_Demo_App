package com.example.android.myapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setting up the appbar:
        androidx.appcompat.widget.Toolbar myToolbar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        //Getting object of viewpager to connect it to page adapter
        ViewPager2 viewPager = (ViewPager2) findViewById(R.id.viewpager);

        //Creating object of page adapter and connecting it with the viewpager
        SimplePageAdapter pageAdapter = new SimplePageAdapter(MainActivity.this);
        viewPager.setAdapter(pageAdapter);

        //Creating the Tablayout and attaching it to the viewpager
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tablay);

        // To connect Tablayout with the view, we need to use the TabLayoutMediator
        TabLayoutMediator.TabConfigurationStrategy tabConfigurationStrategy = new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position)
            {
                switch (position)
                {
                    case 0:
                    {
                        tab.setText("Places");
                        break;
                    }
                    case 1:
                    {
                        tab.setText("Food");
                        break;
                    }
                    case 2:
                    {
                        tab.setText("Fun");
                        break;
                    }
                }
            }
        };
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabLayout, viewPager, tabConfigurationStrategy);
        tabLayoutMediator.attach();
    }
}
package com.example.android.myapplication;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class SimplePageAdapter extends FragmentStateAdapter {
    public SimplePageAdapter(FragmentActivity fragmentActivity)
    {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position)
        {
            case 0:
            {
                return new Places();
            }
            case 1:
            {
                return new Food();
            }
            case 2:
            {
                return new Fun();
            }
            default:
                return null;
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}

package com.example.a2pa;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
public class CustomPagerAdapter extends FragmentPagerAdapter {
    public CustomPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }
    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new Page1Fragment();
        } else if (position == 1) {
            return new Page2Fragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
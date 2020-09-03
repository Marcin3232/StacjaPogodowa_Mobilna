package com.example.czujnik5;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.Enumeration;

public class PagerAdapter extends FragmentPagerAdapter {

    private int numOfTabs;
public PagerAdapter(FragmentManager fm,int numOfTabs){
    super(fm);
    this.numOfTabs= numOfTabs;
}
    @NonNull
    @Override
    public Fragment getItem(int position) {
    switch(position){
        case 0:
            return new TempFragment();
        default:
            return null;
    }

    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}

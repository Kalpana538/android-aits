package com.example.whatapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class TabAdapter extends FragmentStatePagerAdapter {
    List<Fragment> fragmentList=new ArrayList<>();
    List<String>  titles=new ArrayList<>();
    public TabAdapter(FragmentManager fm){
        super (fm);
    }
    @NonNull
    @Override
    public Fragment getItem(int position) {
        return  fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        return titles.get(position);
    }

    public void addFragment(Fragment f, String s) {
        fragmentList.add(f);
        titles.add(s);
    }
}

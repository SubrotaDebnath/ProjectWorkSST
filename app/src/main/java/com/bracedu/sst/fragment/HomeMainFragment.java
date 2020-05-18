package com.bracedu.sst.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;

import com.bracedu.sst.R;
import com.google.android.material.tabs.TabLayout;

public class HomeMainFragment extends Fragment {
    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_main, container, false);
        viewPager = view.findViewById(R.id.homeListContainerViewpager);
        tabLayout = view.findViewById(R.id.homeTabLayout);


        HomePagerAdapter adapter = new HomePagerAdapter(getFragmentManager(),  tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(tapTab);
        return view;
    }

    TabLayout.OnTabSelectedListener tapTab =new TabLayout.OnTabSelectedListener() {
        @Override
        public void onTabSelected(TabLayout.Tab tab) {
            viewPager.setCurrentItem(tab.getPosition());
        }

        @Override
        public void onTabUnselected(TabLayout.Tab tab) {

        }

        @Override
        public void onTabReselected(TabLayout.Tab tab) {

        }
    };

    private class HomePagerAdapter extends FragmentPagerAdapter{
        private int tabCount;

        public HomePagerAdapter(FragmentManager fm, int tabCount) {
            super(fm, tabCount);
            this.tabCount = tabCount;
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return new HomeAttendanceListContainer();
                case 1:
                    return new HomeVisitedListContainer();
                case 2:
                    return new HomeEnvironmentListContainer();
                case 3:
                    return new HomeAssessmentListContainer();
            }
            return null;
        }

        @Override
        public int getCount() {
            return tabCount;
        }
    }
}

package com.example.smarthome.Intro;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class SliderAdapter extends FragmentStatePagerAdapter {
    public SliderAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }
    public SliderAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }
    @NonNull
    @Override
    public Fragment getItem(int position) {
        //add your fragments here
        switch (position) {
            case 0:
                return new SlideOne();

            case 1:
                return new SlideTwo();
            case 2:
                return new SlideThree();


            default:
                return new SlideOne();
        }
    }
    @Override
    public int getCount() {
        //count of your screen
        return 3;
    }
}

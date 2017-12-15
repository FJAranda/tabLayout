package com.example.tablayoutapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by usuario on 13/12/17.
 */

class ViewPagerAdapter extends FragmentPagerAdapter {

    private int pageCount;
    private List<String> titulos;

    public ViewPagerAdapter(FragmentManager supportFragmentManager, int pageCount, String[] titulos) {
        super(supportFragmentManager);
        this.pageCount = pageCount;
        this.titulos = Arrays.asList(titulos);
    }

    public ViewPagerAdapter(FragmentManager supportFragmentManager) {
        super(supportFragmentManager);
    }

    @Override
    public Fragment getItem(int position) {
        CustomFragment customFragment = null;
        Bundle bundle = new Bundle();
        switch (position){
            case 0:
                bundle.putString(CustomFragment.KEY_MENSAJE, "Fragment 1");
                customFragment = CustomFragment.newInstance(bundle);
                break;
            case 1:
                bundle.putString(CustomFragment.KEY_MENSAJE, "Fragment 2");
                customFragment = CustomFragment.newInstance(bundle);
                break;
            case 2:
                bundle.putString(CustomFragment.KEY_MENSAJE, "Fragment 3");
                customFragment = CustomFragment.newInstance(bundle);
                break;
            case 3:
                bundle.putString(CustomFragment.KEY_MENSAJE, "Fragment 4");
                customFragment = CustomFragment.newInstance(bundle);
                break;
            case 4:
                bundle.putString(CustomFragment.KEY_MENSAJE, "Fragment 5");
                customFragment = CustomFragment.newInstance(bundle);
                break;
        }
        return customFragment;
    }

    @Override
    public int getCount() {
        return pageCount;
    }

    /*
    @Override
    public CharSequence getPageTitle(int position) {
        return titulos.get(position);
    }*/


}

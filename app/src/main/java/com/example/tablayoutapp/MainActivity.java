package com.example.tablayoutapp;

import android.content.res.TypedArray;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;

import java.util.ArrayList;

/**
 * Para vincular el tablayout con el viewpager debemos implementar el metodo setupWithViewPager.
 * VIEWPAGER TIENE QUE TENER EL MISMO
 */

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /**
         * Configurar TabLayout
         */

        tabLayout = (TabLayout)findViewById(R.id.tabs);
        /*
        //Opcion separada
        viewPager = (ViewPager)findViewById(R.id.vpViewpager);
        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(), 5));
        viewPager.setPageTransformer(true, new ZoomOutPageTransformer());*/

        //Permite movernos por las pestañas del TabLayout
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        //Añadir el titulo a las tab mediante un array
        //Opcion separada
        /*for (int i = 1; i< 6; i++){
            tabLayout.addTab(tabLayout.newTab().setText("Tab " + i));
        }*/

        viewPager = (ViewPager)findViewById(R.id.vpViewpager);
        //Metodo separado
        //viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount()));
        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(), 5, new String[]{"Tab 1", "Tab 1", "Tab 1", "Tab 1", "Tab 1"}));
        viewPager.setPageTransformer(true, new ZoomOutPageTransformer());

        tabLayout.setupWithViewPager(viewPager);

        setTabIcons();

        /*
        //Tabs y viewpager por separado : Listener seleccion tab
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
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
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //tabLayout.getTabAt(position).select();
                tabLayout.setScrollPosition(position, 0f, true);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });*/

    }

    private void setTabIcons() {
        //Metodo de obtener un array desde xml
        //TypedArray imagenes = getResources().obtainTypedArray(R.array.nombre);

        for (int i = 0; i < tabLayout.getTabCount(); i++){
            tabLayout.getTabAt(i).setIcon(getResources().getIdentifier("gato"+(i+1), "drawable", getPackageName()));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = new MenuInflater(this);
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public void onBackPressed() {
        if (viewPager.getCurrentItem() == 0){
            super.onBackPressed();
        }else{
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
        }

    }
}

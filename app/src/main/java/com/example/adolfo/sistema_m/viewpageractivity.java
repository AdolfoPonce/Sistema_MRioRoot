package com.example.adolfo.sistema_m;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;


/**
 * Created by adolfo on 18/06/17.
 */

public class viewpageractivity extends FragmentActivity {
    private static  final int NUM=5;
    private ViewPager vp;
    private PagerAdapter pa;

    public  void onCreate(Bundle b){
        super.onCreate(b);
        setContentView(R.layout.viewpager);
        vp=(ViewPager)findViewById(R.id.vp);
        pa=new ScreenSlidePagerAdapter(getSupportFragmentManager());
      /*  vp.setPageTransformer(true, new zoom()); */
        vp.setAdapter(pa);
    }

    public void onBackPressed(){
        if(vp.getCurrentItem()==0){
            super.onBackPressed();
        }else{
            vp.setCurrentItem(vp.getCurrentItem()-1);
        }
    }
    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if(position==1){
                return new fragment2();
            }else {
                return new fragment();
            }

        }

        @Override
        public int getCount() {
            return NUM;
        }
    }


}



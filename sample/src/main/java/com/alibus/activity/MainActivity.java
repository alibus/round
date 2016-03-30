package com.alibus.activity;


import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import com.alibus.R;

import com.alibus.fragment.ImageListFragment;


/**
 * 项目名称：round
 * 类描述：
 * 创建人：alibus
 * 创建时间：16-3-25 下午5:33
 * 修改人：alibus
 * 修改时间：16-3-25 下午5:33
 * 修改备注：
 */
public class MainActivity extends FragmentActivity {
    ViewPager viewPager;

    ImageListFragment imageFragment;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        ViewPagerFragment adapter = new ViewPagerFragment(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

    }


    public class ViewPagerFragment extends FragmentStatePagerAdapter {


        public ViewPagerFragment(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            if(null == imageFragment){
                imageFragment = new ImageListFragment();
            }

            return imageFragment;
        }

        @Override
        public int getCount() {
            return 1;
        }
    }
}

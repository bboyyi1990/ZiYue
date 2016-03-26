package com.yi.ziyue.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;


import com.yi.ziyue.R;
import com.yi.ziyue.adapter.ReadAdapter;
import com.yi.ziyue.base.BaseFragment;

import java.util.ArrayList;

/**
 * Created by Yi on 16/3/3.
 */
public class ReadFragment extends BaseFragment {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ReadAdapter readAdapter;


    @Override
    protected int setContent() {
        return R.layout.fragment_read;
    }

    @Override
    protected void initView() {
        tabLayout = bindView(R.id.read_tabLayout);
        viewPager = bindView(R.id.read_viewpager);

    }

    @Override
    protected void initData() {
        readAdapter = new ReadAdapter(getFragmentManager());
        viewPager.setAdapter(readAdapter);
        tabLayout.setupWithViewPager(viewPager);

        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            if (tab != null) {
                tab.setCustomView(readAdapter.getTabView(i));
            }
        }

        viewPager.setCurrentItem(1);
        viewPager.setCurrentItem(0);

    }


}

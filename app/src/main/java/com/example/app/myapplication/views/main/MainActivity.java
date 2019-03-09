package com.example.app.myapplication.views.main;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.app.myapplication.R;
import com.example.app.myapplication.views.account.FragmentAccount;
import com.example.app.myapplication.views.history.FragmentHistory;
import com.example.app.myapplication.views.post.FragmentPost;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    private MainViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();
    }

    private void init() {

        adapter = new MainViewPagerAdapter(getSupportFragmentManager());

        adapter.addFragment(new FragmentPost(),"");
        adapter.addFragment(new FragmentHistory(),"");
        adapter.addFragment(new FragmentAccount(),"");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.house_color);
        tabLayout.getTabAt(1).setIcon(R.drawable.list);
        tabLayout.getTabAt(2).setIcon(R.drawable.settings);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setElevation(0);
        viewPager.setOffscreenPageLimit(3);

        viewPager.addOnPageChangeListener(
                new ViewPager.OnPageChangeListener() {

                    @Override
                    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) { }

                    @Override
                    public void onPageSelected(int position) {
                        switch (position) {
                            case 0:
                                tabLayout.getTabAt(0).setIcon(R.drawable.house_color);
                                tabLayout.getTabAt(1).setIcon(R.drawable.list);
                                tabLayout.getTabAt(2).setIcon(R.drawable.settings);
                                break;
                            case 1:
                                tabLayout.getTabAt(0).setIcon(R.drawable.house);
                                tabLayout.getTabAt(1).setIcon(R.drawable.list_color);
                                tabLayout.getTabAt(2).setIcon(R.drawable.settings);
                                break;
                            case 2:
                                tabLayout.getTabAt(0).setIcon(R.drawable.house);
                                tabLayout.getTabAt(1).setIcon(R.drawable.list);
                                tabLayout.getTabAt(2).setIcon(R.drawable.settings_color);
                                break;
                        }
                    }

                    @Override
                    public void onPageScrollStateChanged(int state) {
                    }
                }
        );
    }
}

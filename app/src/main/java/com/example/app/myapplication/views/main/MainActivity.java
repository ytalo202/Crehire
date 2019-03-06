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
    TabLayout tabLayout1;
    @BindView(R.id.viewPager)
    ViewPager viewPager1;
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

        viewPager1.setAdapter(adapter);
        tabLayout1.setupWithViewPager(viewPager1);

        tabLayout1.getTabAt(0).setIcon(R.drawable.review);
        tabLayout1.getTabAt(1).setIcon(R.drawable.ic_history_ac);
        tabLayout1.getTabAt(2).setIcon(R.drawable.ic_ac_unit);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setElevation(0);


        viewPager1.addOnPageChangeListener(
                new ViewPager.OnPageChangeListener() {

                    @Override
                    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) { }

                    @Override
                    public void onPageSelected(int position) {
                        switch (position) {
                            case 0:
                                tabLayout1.getTabAt(0).setIcon(R.drawable.review);
                                tabLayout1.getTabAt(1).setIcon(R.drawable.ic_history);
                                tabLayout1.getTabAt(2).setIcon(R.drawable.ic_ac_unit);
                                Toast.makeText(MainActivity.this, "1", Toast.LENGTH_SHORT).show();
                                break;
                            case 1:
                                tabLayout1.getTabAt(0).setIcon(R.drawable.ic_home);
                                tabLayout1.getTabAt(1).setIcon(R.drawable.ic_history_ac);
                                tabLayout1.getTabAt(2).setIcon(R.drawable.ic_ac_unit);
                                Toast.makeText(MainActivity.this, "2", Toast.LENGTH_SHORT).show();
                                break;
                            case 2:
                                tabLayout1.getTabAt(0).setIcon(R.drawable.ic_home);
                                tabLayout1.getTabAt(1).setIcon(R.drawable.ic_history);
                                tabLayout1.getTabAt(2).setIcon(R.drawable.ic_ac_unit);
                                Toast.makeText(MainActivity.this, "3", Toast.LENGTH_SHORT).show();
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

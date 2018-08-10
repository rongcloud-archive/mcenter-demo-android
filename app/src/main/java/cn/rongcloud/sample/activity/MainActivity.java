package cn.rongcloud.sample.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;

import cn.rongcloud.sample.MainApp;
import cn.rongcloud.sample.R;
import cn.rongcloud.sample.fragments.MainFragment;
import cn.rongcloud.sample.fragments.MeFragment;
import cn.rongcloud.sample.fragments.TabFragment;
import cn.rongcloud.sample.utils.StatusBarUtils;
import cn.rongcloud.sample.views.CustomTabView;
import io.rong.common.RLog;
import io.rong.imkit.RongIM;
import io.rong.imlib.RongIMClient;
import io.rong.mcenter.MCAccountInfoManager;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private TabLayout tabLayout;
    private ViewPager pager;
    private FragmentPagerAdapter adapter;

    private CustomTabView mainView;
    private CustomTabView discoverView;
    private CustomTabView meView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StatusBarUtils.setMainStatusBar(this);
        initViews();
    }

    private void initViews() {
        pager = findViewById(R.id.pager);
        adapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                if (position == 0) {
                    return new MainFragment();
                }
                if (position == 2) {
                    return new MeFragment();
                }
                return new TabFragment();
            }

            @Override
            public int getCount() {
                return tabLayout.getTabCount();
            }

        };
        tabLayout = findViewById(R.id.layout_tab);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.setupWithViewPager(pager, false);
        pager.setAdapter(adapter);
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (positionOffset > 0) {
                    StatusBarUtils.lightStatusBar(MainActivity.this, true);
                } else if (position == 0) {
                    StatusBarUtils.lightStatusBar(MainActivity.this, false);
                }
            }

            @Override
            public void onPageSelected(int position) {
                if (position != 0) {
                    StatusBarUtils.lightStatusBar(MainActivity.this, true);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        addTabs();
    }

    private void addTabs() {
        mainView = new CustomTabView(this).setText(R.string.text_main).setIcon(R.drawable.selector_tab_main);
        tabLayout.addTab(tabLayout.newTab().setCustomView(mainView));
        discoverView = new CustomTabView(this).setText(R.string.text_discover).setIcon(R.drawable.selector_tab_discover);
        tabLayout.addTab(tabLayout.newTab().setCustomView(discoverView));
        meView = new CustomTabView(this).setText(R.string.text_me).setIcon(R.drawable.selector_tab_me);
        tabLayout.addTab(tabLayout.newTab().setCustomView(meView), true);
        adapter.notifyDataSetChanged();
    }

}

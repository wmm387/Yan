package com.example.administrator.yan;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * 日语类
 */

public class JpaWordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jpa_word);

        //添加fragment
        ViewPager viewPager = (ViewPager)findViewById(R.id.viewpager);
        JpaCategoryAdapter jpaCategoryAdapter = new JpaCategoryAdapter(this,getSupportFragmentManager());
        viewPager.setAdapter(jpaCategoryAdapter);

        TabLayout tabLayout = (TabLayout)findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }
}

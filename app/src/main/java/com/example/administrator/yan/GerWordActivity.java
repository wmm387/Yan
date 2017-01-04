package com.example.administrator.yan;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * 德语类
 */

public class GerWordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ger_word);

        //添加fragment
        ViewPager viewPager = (ViewPager)findViewById(R.id.viewpager);
        GerCategoryAdapter gerCategoryAdapter = new GerCategoryAdapter(this,getSupportFragmentManager());
        viewPager.setAdapter(gerCategoryAdapter);

        TabLayout tabLayout = (TabLayout)findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }
}

package com.example.administrator.yan;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * 法语类
 */

public class FraWordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fre_word);

        //添加2个fragment
        ViewPager viewPager = (ViewPager)findViewById(R.id.viewpager);
        FraCategoryAdapter fraCategoryAdapter = new FraCategoryAdapter(this,getSupportFragmentManager());
        viewPager.setAdapter(fraCategoryAdapter);

        //标题
        TabLayout tabLayout = (TabLayout)findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }
}

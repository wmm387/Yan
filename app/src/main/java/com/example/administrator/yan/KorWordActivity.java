package com.example.administrator.yan;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * 韩语类
 */

public class KorWordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kor_word);

        //添加fragment
        ViewPager viewPager = (ViewPager)findViewById(R.id.viewpager);
        KorCategoryAdapter korCategoryAdapter = new KorCategoryAdapter(this,getSupportFragmentManager());
        viewPager.setAdapter(korCategoryAdapter);

        TabLayout tabLayout = (TabLayout)findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }
}

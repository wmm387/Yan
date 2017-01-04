package com.example.administrator.yan;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * 西班牙语类
 */

public class SpaWordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spa_word);

        //添加fragment
        ViewPager viewPager = (ViewPager)findViewById(R.id.viewpager);
        SpaCategoryAdapter spaCategoryAdapter = new SpaCategoryAdapter(this,getSupportFragmentManager());
        viewPager.setAdapter(spaCategoryAdapter);

        TabLayout tabLayout = (TabLayout)findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }
}

package com.example.administrator.yan;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * 加载法语的2个fragment
 */

public class FraCategoryAdapter extends FragmentPagerAdapter {

    //定义content
    private Context mContext;

    //categoryAdapter方法
    public FraCategoryAdapter(Context context, FragmentManager fm){
        super(fm);
        mContext = context;
    }

    @Override
    //判断并加载数字和短语界面
    public Fragment getItem(int position) {
        if (position == 0) {
            return new FraNumbersFragment();
        }else {
            return new FraPhrasesFragment();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    //标题
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.category_numbers);
        }else {
            return mContext.getString(R.string.category_phrases);
        }
    }
}

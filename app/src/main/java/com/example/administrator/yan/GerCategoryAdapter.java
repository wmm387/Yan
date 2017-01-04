package com.example.administrator.yan;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * 加载德语的fragment
 */

public class GerCategoryAdapter extends FragmentPagerAdapter {

    //定义content
    private Context mContext;

    //categoAdapater方法
    public GerCategoryAdapter(Context context, FragmentManager fm){
        super(fm);
        mContext = context;
    }

    @Override
    //判断并加载数字和短语
    public Fragment getItem(int position) {
        if (position == 0) {
            return new GerNumbersFragment();
        }else {
            return new GerPhrasesFragment();
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

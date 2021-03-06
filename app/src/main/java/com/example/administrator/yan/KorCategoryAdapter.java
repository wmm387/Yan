package com.example.administrator.yan;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


public class KorCategoryAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public KorCategoryAdapter(Context context, FragmentManager fm){
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new KorNumbersFragment();
        }else {
            return new KorPhrasesFragment();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.category_numbers);
        }else {
            return mContext.getString(R.string.category_phrases);
        }
    }
}

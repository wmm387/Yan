package com.example.administrator.yan;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


public class SpaCategoryAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public SpaCategoryAdapter(Context context, FragmentManager fm){
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new SpaNumbersFragment();
        }else {
            return new SpaPhrasesFragment();
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

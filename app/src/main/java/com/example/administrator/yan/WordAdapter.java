package com.example.administrator.yan;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Word数组适配器
 */

public class WordAdapter extends ArrayAdapter<Word> {

    //背景颜色
    private int mColorResourceId;

    //构造函数
    public WordAdapter(Activity context, ArrayList<Word> words, int colorResourceId) {
        super(context, 0, words);
        mColorResourceId = colorResourceId;
    }


    @NonNull
    @Override
    //获取视图
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.layout, parent, false);
        }

        Word currentWord = getItem(position);

        TextView waiyuTextView = (TextView) listItemView.findViewById(R.id.waiyu_text_view);
        //获取外语视图，并添加到列表
        waiyuTextView.setText(currentWord.getmWordTranslation());

        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        //获取中文视图，并添加到列表
        defaultTextView.setText(currentWord.getmDefaultTranslation());

        //判断是否有图片，并添加图片
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image_view);
        if(currentWord.hasImage()) {
            imageView.setImageResource(currentWord.getmImageResourceId());
            imageView.setVisibility(View.VISIBLE);
        }else{
            imageView.setVisibility(View.GONE);
        }

        //获取背景颜色，并添加
        View textContainer = listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(),mColorResourceId);
        textContainer.setBackgroundColor(color);

        //将列表整体添加到布局
        return listItemView;
    }

}


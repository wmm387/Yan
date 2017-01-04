package com.example.administrator.yan;

/**
 * Word类
 */

public class Word {

    //中文
    private String mDefaultTranslation;

    //外语
    private String mWordTranslation;

    //定义常量图片资源
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;

    //音频
    private int mAudioResourceId;

    /**
     * 3个参数的构造函数
     * 有中文、外语和音频
     * 主要是短语集合
     */
    public Word(String defaultTranslation, String wordTranslation, int audioResourceId){
        mDefaultTranslation = defaultTranslation;
        mWordTranslation = wordTranslation;
        mAudioResourceId = audioResourceId;
    }

    /**
     * 4个参数的构造函数
     * 有中文、外语、图片和音频
     * 主要是数字集合
     */
    public Word(String defaultTranslation, String wordTranslation, int imageResourceId,
                int audioResourceId){
        mDefaultTranslation = defaultTranslation;
        mWordTranslation = wordTranslation;
        mImageResourceId = imageResourceId;
        mAudioResourceId = audioResourceId;
    }

    /**
     * 获取以上变量
     * @return
     */
    public String getmDefaultTranslation(){
        return mDefaultTranslation;
    }

    public String getmWordTranslation(){
        return mWordTranslation;
    }

    public int getmImageResourceId(){
        return mImageResourceId;
    }

    public boolean hasImage(){
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    public int getmAudioResourceId(){
        return mAudioResourceId;
    }

}

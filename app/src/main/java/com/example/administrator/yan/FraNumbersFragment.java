package com.example.administrator.yan;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * 法语数字类
 */

public class FraNumbersFragment extends Fragment {

    //定义媒体播放器
    private MediaPlayer mMediaPlayer;

    private AudioManager mAudioManager;

    //获取媒体播放器焦点
    AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener =
            new AudioManager.OnAudioFocusChangeListener() {
                public void onAudioFocusChange(int focusChange) {
                    if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                            focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                        //Pause playback
                        mMediaPlayer.pause();
                        mMediaPlayer.seekTo(0);
                    } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                        //Resume playback
                        mMediaPlayer.start();
                    } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                        releaseMediaPlayer();
                    }
                }
            };

    private MediaPlayer.OnCompletionListener mOnCompletionListener =
            new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    releaseMediaPlayer();
                }
            };


    public FraNumbersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        mAudioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

        //添加集合
        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("一", "un", R.drawable.number_one, R.raw.fra_one));
        words.add(new Word("二", "deux", R.drawable.number_two, R.raw.fra_two));
        words.add(new Word("三", "trois", R.drawable.number_three, R.raw.fra_three));
        words.add(new Word("四", "quatre", R.drawable.number_four, R.raw.fra_four));
        words.add(new Word("五", "cinq", R.drawable.number_five, R.raw.fra_five));
        words.add(new Word("六", "six", R.drawable.number_six, R.raw.fra_six));
        words.add(new Word("七", "sept", R.drawable.number_seven, R.raw.fra_seven));
        words.add(new Word("八", "huit", R.drawable.number_eight, R.raw.fra_eight));
        words.add(new Word("九", "neuf", R.drawable.number_nine, R.raw.fra_nina));
        words.add(new Word("十", "dix", R.drawable.number_ten, R.raw.fra_ten));

        WordAdapter itemsAdapter = new WordAdapter(getActivity(), words, R.color.category_juS);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);

        //点击监听事件，播放声音
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Word word = words.get(i);
                releaseMediaPlayer();

                int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,
                        AudioManager.STREAM_MUSIC,
                        AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    mMediaPlayer = MediaPlayer.create(getActivity(),
                            word.getmAudioResourceId());
                    mMediaPlayer.start();
                    mMediaPlayer.setOnCompletionListener(mOnCompletionListener);
                }
            }
        });
        return rootView;
    }

    @Override
    //停止音频方法
    public void onStop() {

        super.onStop();

        releaseMediaPlayer();
    }

    //释放播放器
    private void releaseMediaPlayer() {

        if (mMediaPlayer != null) {

            mMediaPlayer.release();

            mMediaPlayer = null;

            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }

}

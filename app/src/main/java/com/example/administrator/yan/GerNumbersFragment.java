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
 * 德语数字类
 */

public class GerNumbersFragment extends Fragment {

    //定义媒体播放器
    private MediaPlayer mMediaPlayer;

    private AudioManager mAudioManager;

    //获取播放器焦点
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


    public GerNumbersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        mAudioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

        //添加集合
        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("一", "eins", R.drawable.number_one, R.raw.ger_one));
        words.add(new Word("二", "zwei", R.drawable.number_two, R.raw.ger_two));
        words.add(new Word("三", "drei", R.drawable.number_three, R.raw.ger_three));
        words.add(new Word("四", "vier", R.drawable.number_four, R.raw.ger_four));
        words.add(new Word("五", "fünf", R.drawable.number_five, R.raw.ger_five));
        words.add(new Word("六", "sechs", R.drawable.number_six, R.raw.ger_six));
        words.add(new Word("七", "sieben", R.drawable.number_seven, R.raw.ger_seven));
        words.add(new Word("八", "acht", R.drawable.number_eight, R.raw.ger_eight));
        words.add(new Word("九", "neun", R.drawable.number_nine, R.raw.ger_nine));
        words.add(new Word("十", "zehn", R.drawable.number_ten, R.raw.ger_ten));

        WordAdapter itemsAdapter = new WordAdapter(getActivity(), words, R.color.category_zS);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);

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
    public void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer() {
        if (mMediaPlayer != null) {
            mMediaPlayer.release();

            mMediaPlayer = null;

            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }

}

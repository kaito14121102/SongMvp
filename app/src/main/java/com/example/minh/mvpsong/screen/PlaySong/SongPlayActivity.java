package com.example.minh.mvpsong.screen.PlaySong;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.BitmapFactory;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.minh.mvpsong.R;
import com.example.minh.mvpsong.data.model.Song;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class SongPlayActivity extends AppCompatActivity {
    private ImageButton mButtonBack;
    private ImageButton mButtonNext;
    private ImageButton mButtonPlay;
    private TextView mTextCurrentTime;
    private TextView mTextTotalTime;
    private TextView mTextNameSong;
    private ImageView mImageSong;
    private SeekBar mSeekBar;
    //
    private List<Song> mSongList;
    private int mPosition;
    //service
    private SongService mSongService;
    private boolean mBound = false;
    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            SongService.MyBinder mBinder = (SongService.MyBinder) iBinder;
            mSongService = mBinder.getInstance();
            mBound = true;
        }
        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            mBound = false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_song);
        initWidget();
        init();
        startSongSerVice();
    }

    private void startSongSerVice() {
        Intent mIntent = new Intent(this, SongService.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("song_list", (Serializable) mSongList);
        mIntent.putExtras(bundle);
        mIntent.putExtra("position", mPosition);
        bindService(mIntent, mConnection, this.BIND_AUTO_CREATE);
        startService(mIntent);
    }

    private void init() {
        mSongList = new ArrayList<>();
        Intent mIntent = getIntent();
        mPosition = mIntent.getIntExtra("position",0);
        Bundle bundle = mIntent.getExtras();
        mSongList = (List<Song>) bundle.getSerializable("song_list");
        UpdateUI();
    }

    private void initWidget() {
        mButtonBack = findViewById(R.id.button_backward);
        mButtonNext = findViewById(R.id.button_forward);
        mButtonPlay = findViewById(R.id.button_play);
        mSeekBar = findViewById(R.id.seek_bar);
        mTextCurrentTime = findViewById(R.id.text_current_time);
        mTextTotalTime = findViewById(R.id.text_total_time);
        mTextNameSong = findViewById(R.id.text_name_song);
        mImageSong = findViewById(R.id.image_song);
    }

    public void UpdateUI(){
        mTextNameSong.setText(mSongList.get(mPosition).getTitle());
        mImageSong.setImageBitmap(BitmapFactory.decodeByteArray(mSongList.get(mPosition).getImage(),0,mSongList.get(mPosition).getImage().length));
        SimpleDateFormat dinhDangGio = new SimpleDateFormat("mm:ss");
        mTextTotalTime.setText(dinhDangGio.format(Integer.parseInt(mSongList.get(mPosition).getSongDuration())));
    }

}

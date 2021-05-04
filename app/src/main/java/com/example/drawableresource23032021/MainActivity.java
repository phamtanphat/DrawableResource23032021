package com.example.drawableresource23032021;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView mTvHex, mTvRgb;
    SeekBar mSkAlpha, mSkRed, mSkGreen, mSkBlue;
    LinearLayout mLinearBackGround;
    int mAlpha = 0;
    int mRed = 0;
    int mGreen = 0;
    int mBlue = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTvHex = findViewById(R.id.textViewHex);
        mTvRgb = findViewById(R.id.textViewRGB);
        mLinearBackGround = findViewById(R.id.linearBackGround);
        mSkAlpha = findViewById(R.id.seekBarAlpha);
        mSkRed = findViewById(R.id.seekBarRed);
        mSkGreen = findViewById(R.id.seekBarGreen);
        mSkBlue = findViewById(R.id.seekBarBlue);

        mSkAlpha.setMax(255);
        mSkBlue.setMax(255);
        mSkRed.setMax(255);
        mSkGreen.setMax(255);

        mSkAlpha.setOnSeekBarChangeListener(onSeekBarChangeListener);
        mSkBlue.setOnSeekBarChangeListener(onSeekBarChangeListener);
        mSkGreen.setOnSeekBarChangeListener(onSeekBarChangeListener);
        mSkRed.setOnSeekBarChangeListener(onSeekBarChangeListener);
    }
    private OnSeekBarChangeListener onSeekBarChangeListener = new OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
            switch (seekBar.getId()){
                case R.id.seekBarAlpha :
                    mAlpha = i;
                    break;
                case R.id.seekBarRed :
                    mRed = i;
                    break;
                case R.id.seekBarGreen :
                    mGreen = i;
                    break;
                case R.id.seekBarBlue :
                    mBlue = i;
                    break;
            }
            mLinearBackGround.setBackgroundColor(Color.argb(mAlpha,mRed,mGreen,mBlue));
            mTvHex.setText(String.format("HEX # %s %s %s %s",
                    Integer.toHexString(mAlpha),
                    Integer.toHexString(mRed),
                    Integer.toHexString(mGreen),
                    Integer.toHexString(mBlue))
            );
            mTvRgb.setText(String.format("RGB %s %s %s %s",mAlpha,mRed,mGreen,mBlue));
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };
}
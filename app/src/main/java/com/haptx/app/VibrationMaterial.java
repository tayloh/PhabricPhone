package com.haptx.app;


import android.content.Context;
import android.media.MediaPlayer;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.View;

public class VibrationMaterial {

    public static float WOOL_DISTANCE = 200;
    public static int WOOL_LENGTH = 100;
    public static float SILK_DISTANCE = 150;
    public static int SILK_LENGTH = 40;
    public static float LEATHER_DISTANCE = 50;
    public static int LEATHER_LENGTH = 60;
    public static float DENIM_DISTANCE = 25;
    public static int DENIM_LENGTH = 100;

    private float[] mPrevVibrPos = {0, 0};

    private float mVibrDistance;
    private float mVibrLength;

    private Vibrator mVibrator;
    private Context mMediaContext;
    private MediaPlayer mMediaPlayer;

    private View.OnTouchListener mOnTouchVibrator;

    public VibrationMaterial(float vibrDistance, int vibrLength, Vibrator vibrator,
                             Context mediaContext, int audioFile) {
        mVibrDistance = vibrDistance;
        mVibrLength = vibrLength;

        mVibrator = vibrator;
        mMediaContext = mediaContext;

        mMediaPlayer = MediaPlayer.create(mMediaContext, audioFile);

        mOnTouchVibrator = new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                int eventAction = motionEvent.getAction();

                float currX = motionEvent.getX();
                float currY = motionEvent.getY();
                float movedDistance = mCalcDistance(mPrevVibrPos[0], mPrevVibrPos[1], currX, currY);

                if (movedDistance > mVibrDistance) {
                    mVibrator.vibrate((long) mVibrLength);
                    mPrevVibrPos[0] = currX;
                    mPrevVibrPos[1] = currY;

                    if (mMediaPlayer.isPlaying()){
                        mMediaPlayer.stop();
                        mMediaPlayer.release();
                        mMediaPlayer = MediaPlayer.create(mMediaContext, audioFile);
                    }
                    mMediaPlayer.start();
                }

                return false;
            }
        };
    }

    private float mCalcDistance(float x1, float y1, float x2, float y2){
        return (float) Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
    }

    public View.OnTouchListener getOnTouchVibrator(){
        return mOnTouchVibrator;
    }

    public float getVibrLength() {
        return mVibrLength;
    }

    public void setVibrLength(float vibrLength) {
        this.mVibrLength = mVibrLength;
    }

    public float getVibrDistance() {
        return mVibrDistance;
    }

    public void setVibrDistance(float vibrDistance) {
        this.mVibrDistance = mVibrDistance;
    }

}

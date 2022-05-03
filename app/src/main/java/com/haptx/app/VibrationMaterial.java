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

    private long mLastVibrationTime;

    private Vibrator mVibrator;
    private Context mMediaContext;
    private MediaPlayer mMediaPlayer;

    private View.OnTouchListener mOnTouchVibrator;

    public static void resetVibrationMaterialSettings() {
        WOOL_DISTANCE = 200;
        WOOL_LENGTH = 100;
        SILK_DISTANCE = 150;
        SILK_LENGTH = 40;
        LEATHER_DISTANCE = 50;
        LEATHER_LENGTH = 60;
        DENIM_DISTANCE = 25;
        DENIM_LENGTH = 100;
    }

    public VibrationMaterial(float vibrDistance, int vibrLength, Vibrator vibrator,
                             Context mediaContext, int audioFile) {
        // See if I can get the mediaContext in some other way
        // See if I can get the vibrator in some other way
        // => Perform all instantiation in the onTouch method
        // since I can get the View there, and therefore the
        // context, and maybe access the activity for the vibrator as
        // well?
        // Maybe it isn't super efficient to instantiate new objects
        // on every onTouch event... but it's ugly to have the
        // mediaContext and vibrator as arguments in the constructor.
        // Could check if vibr and context is null in
        // onTouch, and instantiate member variables if they are.
        // OR I just leave it as it is, since it WORKS.

        mVibrDistance = vibrDistance;
        mVibrLength = vibrLength;

        mVibrator = vibrator;
        mMediaContext = mediaContext;
        mLastVibrationTime = System.currentTimeMillis();

        mMediaPlayer = MediaPlayer.create(mMediaContext, audioFile);

        mOnTouchVibrator = new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                int eventAction = motionEvent.getAction();

                float currX = motionEvent.getX();
                float currY = motionEvent.getY();
                float movedDistance = mCalcDistance(mPrevVibrPos[0], mPrevVibrPos[1], currX, currY);

                if (movedDistance > mVibrDistance) {

                    // Play material sound
                    if (!mMediaPlayer.isPlaying()){
                        //mMediaPlayer.stop();
                        mMediaPlayer.release();
                        mMediaPlayer = MediaPlayer.create(mMediaContext, audioFile);
                    }
                    mMediaPlayer.start();

                    // Check if last vibration is done
                    long now = System.currentTimeMillis();
                    if (now - mLastVibrationTime >= mVibrLength * 2) {
                        mLastVibrationTime = now;

                        // Vibrate
                        mVibrator.vibrate(0); // Or cancel() have to test
                        mVibrator.vibrate((long) mVibrLength);
                        mPrevVibrPos[0] = currX;
                        mPrevVibrPos[1] = currY;
                    }
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

package com.haptx.app;

public class LineCollider {

    private float y;
    private boolean isCollidable = true;
    private long mVibrLength;

    public LineCollider(float y, long vibrLength) {
        this.y = y;
        mVibrLength = vibrLength;
    }

    public long getVibrLength() {
        return mVibrLength;
    }

    public boolean checkForCollision(float x, float y){
        float collisionWidth = 20;
        float borderMargin = collisionWidth / 2;


        // If finger exactly on edge of y+width, then vibration goes crazy
        // This is the attempted fix...:
        // Prevent vibrations on the edge of the collision box
        if (y > this.y - collisionWidth - borderMargin && y < this.y - collisionWidth + borderMargin) {
            return false;
        }

        if (y > this.y + collisionWidth - borderMargin && y < this.y + collisionWidth + borderMargin) {
            return false;
        }

        if (y > this.y - collisionWidth && y < this.y + collisionWidth && isCollidable) {

            // Turn off the collision with this line if it is
            // already inside the collision width
            isCollidable = false;
            return true;
        }

        // Turn it back on once the finger leaves the lines collision width
        isCollidable = true;
        return false;
    }

}

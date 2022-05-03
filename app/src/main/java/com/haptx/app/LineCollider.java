package com.haptx.app;

public class LineCollider {

    private float y;
    private boolean isCollidable = true;

    public LineCollider(float y) {
        this.y = y;
    }

    public boolean checkForCollision(float x, float y){
        int collisionWidth = 20;

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

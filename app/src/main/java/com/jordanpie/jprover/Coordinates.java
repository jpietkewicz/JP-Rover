package com.jordanpie.jprover;

class Coordinates {

    private float x;
    private float y;
    private final float centerX;
    private final float centerY;
    private final float base = JoystickView.getBaseRadius();
    private String result;
    private float displacement;

    Coordinates(float centerX, float centerY) {

        this.centerX = centerX;
        this.centerY = centerY;

    }

    void setCoordinates(float xIn, float yIn) {

        x = xIn - centerX;
        y = centerY - yIn;

        displacement = (float) Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));

        convert();

    }

    // used for debugging log.d
    float getX() {
        return x;
    }
    float getY() {
        return y;
    }
    String getResult() {
        return result;
    }

    private void constrain() {

        if (x > base) {
            x = base;
        }

        if (y > base) {
            y = base;
        }

        if (x < -base) {
            x = -base;
        }

        if (y < -base) {
            y = -base;
        }

    }

    private void convert() {

        constrain();

        float power = displacement / base;

        result = power + ",";

        //origin
        if (x == 0 && y == 0) {
            result += "0,0";
        }

        // on y axis positive
        if (x == 0 && y / displacement == 1) {
            result += "1,1";
        }

        // on y axis negative
        if (x == 0 && y / displacement == -1) {
            result += "-1,-1";
        }

        // on x axis positive
        if (x / displacement == 1) {
            result += "1,-1";
        }

        // on x axis negative
        if (x / displacement == -1) {
            result += "-1,1";
        }

        // I
        if (x > 0 && y > 0) {
            result += "1," + (2*Math.pow((y/displacement),2.0)-1);
        }

        // II
        else if (x < 0 && y > 0) {
            result += (2*Math.pow((y/displacement),2.0) - 1) + ",1";
        }

        // III
        else if (x < 0 && y < 0) {
            result +=  "-1," + (1 - 2*Math.pow((y/displacement),2.0));
        }

        // IV
        else {
            result += (1 - 2*Math.pow((y/displacement),2.0)) + ",-1";
        }

    }

}

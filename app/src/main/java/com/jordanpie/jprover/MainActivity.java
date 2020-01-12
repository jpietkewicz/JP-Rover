package com.jordanpie.jprover;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements JoystickView.JoystickListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        JoystickView joystick = new JoystickView(this);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onJoystickMoved(float xPercent, float yPercent, int id) {}

}

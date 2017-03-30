package com.example.willi_000.dcmotorarm;

import android.view.MotionEvent;
import android.view.View;

import static com.example.willi_000.dcmotorarm.R.id.*;

public class buttonListener implements View.OnTouchListener {

    int m1state = 0;
    int m2state = 0;
    int m5state = 0;

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_UP) {
            switch (v.getId()) {
                case motor1Close:
                    m1state=0;
                    break;
                case motor1Open:
                    m1state = 0;
                    break;
                case motor2Down:
                    m2state = 0;
                    break;
                case motor2Up:
                    m2state = 0;
                    break;
                case motor5Left:
                    m5state = 0;
                    break;
                case motor5Right:
                    m5state = 0;
                    break;
            }
            return true;
        }
        switch (v.getId()) {
            case motor1Close:
                m1state = 1;
                break;
            case motor1Open:
                m1state = 2;
                break;
            case motor2Down:
                m2state = 1;
                break;
            case motor2Up:
                m2state = 2;
                break;
            case motor5Left:
                m5state = 1;
                break;
            case motor5Right:
                m5state = 2;
                break;
        }
        return false;
    }
}
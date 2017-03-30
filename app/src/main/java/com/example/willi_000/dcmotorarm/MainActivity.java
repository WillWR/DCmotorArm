package com.example.willi_000.dcmotorarm;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements SensorEventListener{

    int m1state=0;
    int m2state=0;
    int m3state=0;
    int m4state=0;
    int m5state=0;

    Sensor accelerometer;
    SensorManager sm;

    //Text boxes for accelerometer Displays
    TextView xValDisp = (TextView)findViewById(R.id.xValueDisp);
    TextView yValDisp = (TextView)findViewById(R.id.yValueDisp);
    //Motor 1 declarations
    Button m1Close = (Button)findViewById(R.id.motor1Close);
    Button m1Open = (Button)findViewById(R.id.motor1Open);
    //Motor 2 declarations
    Button m2Down = (Button)findViewById(R.id.motor2Down);
    Button m2Up = (Button)findViewById(R.id.motor2Up);
    //Motor 5 declarations
    Button m5Left = (Button)findViewById(R.id.motor5Left);
    Button m5Right = (Button)findViewById(R.id.motor5Right);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        /* SENSOR Manager */
        sm=(SensorManager)getSystemService(SENSOR_SERVICE);
        accelerometer=sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sm.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);


        //EVENT LISTENERS
        //Motor 1 Close
        m1Close.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_UP){
                    m1state=0;
                    return true;
                }
                m1state=1;
                return false;
            }
        });
        //Motor 1 Open
        m1Open.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_UP){
                    m1state=0;
                    return true;
                }
                m1state=2;
                return false;
            }
        });
        //Motor 2 down
        m2Down.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_UP){
                    m2state=0;
                    return true;
                }
                m2state=1;
                return false;
            }
        });
        //Motor 2 Up
        m2Up.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_UP){
                    m2state=0;
                    return true;
                }
                m2state=2;
                return false;
            }
        });
        //Motor 5 Left
        m5Left.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_UP){
                    m5state=0;
                    return true;
                }
                m5state=1;
                return false;
            }
        });
        //Motor 5 Right
        m5Right.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_UP){
                    m5state=0;
                    return true;
                }
                m5state=2;
                return false;
            }
        });
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if((event.values[0]>=-4)&&(event.values[0]<=4)){
            m4state=0;
            xValDisp.setText("0");
        }
        else if(event.values[0]<-4){
            m4state=1;
            xValDisp.setText("1");
        }
        else if(event.values[0]>4){
            m4state=2;
            xValDisp.setText("2");
        }

        if((event.values[1]>=-4)&&(event.values[1]<=4)){
            m3state=0;
            yValDisp.setText("0");
        }
        else if(event.values[1]<-4){
            m3state=1;
            yValDisp.setText("1");
        }
        else if(event.values[1]>4){
            m3state=2;
            yValDisp.setText("2");
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

}



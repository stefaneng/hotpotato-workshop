package com.example.hotpotato_2;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    Button host, connect;
    TextView txtInfo;
    EditText txtIP;
    Vibrator vibe;
    SensorManager sensorManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        host = (Button) findViewById(R.id.butHost);
        connect = (Button) findViewById(R.id.butConnect);
        txtInfo = (TextView) findViewById(R.id.txtInfo);
        txtIP = (EditText) findViewById(R.id.txtIP);
        host.setOnClickListener(onClickListener);
        connect.setOnClickListener(onClickListener);

        initializeVibrator();

    }

    void initializeSensors() {
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        Sensor sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(eventListener, sensor, SensorManager.SENSOR_DELAY_GAME);
    }

    SensorEventListener eventListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
                txtInfo.setText(String.valueOf(event.values[0]));
                Log.i("workshop", String.valueOf(event.values[0]));
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };

    void initializeVibrator() {
        vibe = (Vibrator) getSystemService(VIBRATOR_SERVICE);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v.equals(host)) {
                Server server = new Server(null);
                server.start();
            } else if (v.equals(connect)) {
                Client client = new Client(String.valueOf(txtIP.getText()));
                client.start();
            }
        }
    };
}






















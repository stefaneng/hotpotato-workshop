package com.example.hotpotato_workshop;

import android.app.Activity;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MyActivity extends Activity {
    Button host, connect;
    TextView txtInfo;
    EditText txtIP;
    Vibrator vibe;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        host = (Button) findViewById(R.id.butHost);
        connect = (Button) findViewById(R.id.butConnect);
        txtInfo = (TextView) findViewById(R.id.textInfo);
        txtIP = (EditText) findViewById(R.id.txtIP);
        host.setOnClickListener(onClickListener);
        connect.setOnClickListener(onClickListener);

        initializeVibrator();
    }

    void initializeVibrator() {
        vibe = (Vibrator) getSystemService(VIBRATOR_SERVICE);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v.equals(host)) {
                Log.i("workshop", "host");
                vibe.vibrate(500);
            } else if (v.equals(connect)) {
                Log.i("workshop", "connect");
            }

        }
    };
}

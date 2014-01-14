package com.example.hotpotato_workshop;

import android.app.Activity;
import android.os.Bundle;
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

    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v.equals(host)) {
                Log.i("workshop", "host");
            } else if (v.equals(connect)) {
                Log.i("workshop", "connect");
            }

        }
    };
}

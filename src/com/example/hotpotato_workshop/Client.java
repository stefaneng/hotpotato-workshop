package com.example.hotpotato_workshop;

import android.util.Log;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * Created by Stefan Eng on 1/13/14.
 */
public class Client extends Thread {
    String ip;
    public Client(String ip) {
        this.ip = ip;
    }

    @Override
    public void run() {
        super.run();

        try {
            Log.i("workshop", "starting connection");
            Socket socket = new Socket(ip, 12345);
            socket.setReuseAddress(true);
            socket.setKeepAlive(true);
            Log.i("workshop", "connection established");

            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(
                            socket.getOutputStream()));
            writer.write("Hello world");
            Log.i("workshop", "wrote data");
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

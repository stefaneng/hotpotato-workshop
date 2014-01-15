package com.example.hotpotato_2;

import android.util.Log;

import java.io.*;
import java.net.Socket;

/**
 * Created by ngorgi on 1/13/14.
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
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                            socket.getInputStream()));



            writer.write("Hello from client");
            writer.newLine();
            Log.i("workshop", "wrote data");
            writer.flush();


            String s = reader.readLine();
            Log.i("workshop", "read in " + String.valueOf(s));



            writer.close();
            Log.i("workshop", "connection closed");


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

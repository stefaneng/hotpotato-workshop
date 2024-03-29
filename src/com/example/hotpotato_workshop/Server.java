package com.example.hotpotato_2;

import android.util.Log;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

/**
 * Created by ngorgi on 1/13/14.
 */
public class Server extends Thread {
    ServerInterface serverInterface;
    boolean keepRunning = true;

    synchronized public void shutDown() {
        keepRunning = false;
    }

    public Server(ServerInterface serverInterface) {
        this.serverInterface = serverInterface;
    }

    @Override
    public void run() {
        super.run();
        try {
            ServerSocket serverSocket = new ServerSocket(12345);
            serverSocket.setReuseAddress(true);
            Log.i("workshop", "waiting for connection");

            Socket clientSocket = serverSocket.accept();
            clientSocket.setKeepAlive(true);
            clientSocket.setTcpNoDelay(true);

            clientSocket.setSoTimeout(10);

            Log.i("workshop", "connection established");
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                            clientSocket.getInputStream()));
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(
                            clientSocket.getOutputStream()));


            while (keepRunning) {

                try {
                    String s = reader.readLine();
                    Log.i("workshop", "read in " + String.valueOf(s));
                } catch (IOException e) {
                  //  e.printStackTrace();
                }
//

            }

            clientSocket.close();
            serverSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public interface ServerInterface {
        public void gotData(String data);
    }
}

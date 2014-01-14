package com.example.hotpotato_workshop;

import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by stefan on 1/13/14.
 */
public class Server extends Thread{
ServerInterface serverInterface;

    public Server(ServerInterface serverInterface) {
        this.serverInterface = serverInterface;
    }

    @Override
    public void run() {
        super.run();
        try {
            ServerSocket serverSocket = new ServerSocket(12345);
            serverSocket.setReuseAddress(true);
            Log.i("workshop", "waiting for connsection");
            Socket clientSocket;
            clientSocket = serverSocket.accept();
            Log.i("workshop", "connection established");
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
            String s = reader.readLine();
            Log.i("workshop", "read in " + String.valueOf(s));
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

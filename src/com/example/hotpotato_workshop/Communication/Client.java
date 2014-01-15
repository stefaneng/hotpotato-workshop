package com.example.hotpotato_2.Communication;

import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Queue;

/**
 * Created by ngorgi on 1/14/14.
 */
public class Client extends CommsHandler {
    ClientThread clientThread;

    @Override
    public void establishConnection() {
        super.establishConnection();
    }

    @Override
    public void closeConnection() {
        super.closeConnection();
        clientThread.shutDown();
    }

    @Override
    public void writeData(String data) {
        super.writeData(data);

    }

    public Client(int port, String ip, CommsHandlerInterface commsHandlerInterface) {
        super(port, ip, commsHandlerInterface);
        clientThread = new ClientThread();
    }

    public class ClientThread extends Thread {
        boolean keepRunning = true;
        Queue<String> outgoingCommandQueue;


        synchronized public void shutDown() {
            keepRunning = false;
        }

        @Override
        public void run() {
            super.run();
            try {
                Socket socket = new Socket(ip, 12345);
                socket.setReuseAddress(true);
                socket.setKeepAlive(true);

                BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(
                                socket.getOutputStream()));
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                socket.getInputStream()));
                while (keepRunning) {

                    if (outgoingCommandQueue.size() > 0) {
                        final String data = outgoingCommandQueue.remove();
                        writer.write(data);
                        writer.flush();
                    }

                    try {
                        final String s = reader.readLine();

                    } catch (Exception e) {
                    }

                }
                writer.close();


            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

package com.example.hotpotato_2.Communication;

/**
 * Created by ngorgi on 1/14/14.
 */
public class CommsHandler {
    public int port;
    public String ip;
    public CommsHandlerInterface commsHandlerInterface;
    public CommsHandler(int port,
                        CommsHandlerInterface commsHandlerInterface) {
        this.port = port;
        this.commsHandlerInterface = commsHandlerInterface;
    }

    public CommsHandler(int port, String ip,
                        CommsHandlerInterface commsHandlerInterface) {
        this.port = port;
        this.commsHandlerInterface = commsHandlerInterface;
        this.ip = ip;
    }

    public void establishConnection() {

    }

    public void writeData(String data) {

    }

    public void closeConnection() {

    }

    public interface CommsHandlerInterface {
        public void dataReceived(String data);
    }
}

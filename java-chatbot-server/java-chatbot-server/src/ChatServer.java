package com.example;
import java.io.*;
import java.net.*;

import com.corundumstudio.socketio.SocketIOServer;

// import io.socket.server.*;

public class ChatServer {
    private static final int PORT = 3000;

    public static void main(String[] args) throws Exception {
        SocketIOServer server = new SocketIOServer(PORT);

        server.addEventListener("message", String.class, (client, data, ackSender) -> {
            if (data.equalsIgnoreCase("hi")) {
                client.sendEvent("message", "hello");
            }
        });

        server.start();
        System.out.println("Chat server started on port " + PORT);
    }
}

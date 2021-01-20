package socket_server;

import java.net.*;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(3000);
            while (true) {
                Socket socket = serverSocket.accept();
                ObjectInputStream objectInput = new ObjectInputStream(socket.getInputStream());
                UserSocket userSocket = (UserSocket) objectInput.readObject();
                System.out.println("New Socket: " + userSocket.getNickname());
                userSocket.setSocket(socket);
                SocketHandler.addSocket(userSocket);
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}

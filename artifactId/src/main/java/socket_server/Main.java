package socket_server;

import java.io.IOException;
import java.net.*;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(3000);
            while (true) {
                Socket socket = serverSocket.accept();
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String nickname = in.readLine();
                UserSocket userSocket = new UserSocket(nickname, socket);
                SocketHandler.addSocket(userSocket);
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}

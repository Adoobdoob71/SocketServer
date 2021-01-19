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
                BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String nickname = input.readLine();
                System.out.println("New Socket: " + nickname);
                UserSocket userSocket = new UserSocket(nickname, socket);
                SocketHandler.addSocket(userSocket);
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}

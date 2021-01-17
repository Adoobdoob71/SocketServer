package socket_server;

import java.io.IOException;
import java.net.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(3000);
            while (true) {
                Socket socket = serverSocket.accept();

            }

        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
}

package socket_server;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientDemo {

  public static void main(String[] args) throws Exception {
    Scanner in = new Scanner(System.in);
    Socket socket = new Socket("localhost", 3000);
    BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    String messageFromServer = null;
    ClientInputThreadDemo clientInputThreadDemo = new ClientInputThreadDemo(socket);
    clientInputThreadDemo.start();
    while ((messageFromServer = input.readLine()) != null) {
      System.out.println("Server said: " + messageFromServer);
    }

  }
}

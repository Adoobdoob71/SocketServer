package socket_server;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientInputThreadDemo extends Thread {

  public Socket socket;

  public ClientInputThreadDemo(Socket socket) {
    this.socket = socket;
  }

  @Override
  public void run() {
    try {
      Scanner in = new Scanner(System.in);
      String message = in.nextLine();
      PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
      output.println(message);
    } catch (Exception exception) {
      System.out.println(exception.getMessage());
    }
    run();
  }
}

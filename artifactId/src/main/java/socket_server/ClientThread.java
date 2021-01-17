package socket_server;

import java.io.*;
import java.net.*;
import java.util.*;

public class ClientThread extends Thread {

  private Socket socket;

  public ClientThread(Socket socket) {
    this.socket = socket;
  }

  public Socket getSocket() {
    return socket;
  }

  public void setSocket(Socket socket) {
    this.socket = socket;
  }

  public void handleSocketInput() throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    String message = input.readLine();
    if (message.equalsIgnoreCase("true")) {
      // ServerThread.sendToClient(message, );
    }
  }

  @Override
  public void run() {

  }

}

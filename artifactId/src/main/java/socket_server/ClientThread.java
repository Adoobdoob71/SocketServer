package socket_server;

import java.io.*;
import java.net.*;
import java.util.*;

public class ClientThread extends Thread {

  private UserSocket userSocket;

  public ClientThread(UserSocket socket) {
    this.userSocket = socket;
  }

  public UserSocket getSocket() {
    return userSocket;
  }

  public void setSocket(UserSocket socket) {
    this.userSocket = socket;
  }

  public void handleSocketInput() throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(userSocket.getSocket().getInputStream()));
    String key = input.readLine();
    sendToClient(key, userSocket.getNickname());
  }

  public static void sendToClient(String key, String message) throws IOException {
    UserSocket socket = SocketHandler.socket_map.get(key);
    PrintWriter output = new PrintWriter(socket.getSocket().getOutputStream());
    output.println(message);
    output.flush();
  }

  @Override
  public void run() {
    try {
      handleSocketInput();
      run();
    } catch (Exception exception) {
      System.out.println(exception.getMessage());
    }
  }

}

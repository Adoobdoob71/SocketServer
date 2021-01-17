package socket_server;

import java.net.*;
import java.util.*;
import java.io.*;

public class ServerThread extends Thread {

  private static HashMap<String, Socket> socket_map = new HashMap<String, Socket>();

  public ServerThread(HashMap<String, Socket> socket_map) {
    this.socket_map = socket_map;
  }

  public Socket getSocket(String key) throws Exception {
    Socket socket = socket_map.get(key);
    if (socket == null)
      throw new Exception("Exception: Could not find specified socket");
    return socket;
  }

  public void addSocket(String key, Socket socket) throws Exception {
    if (socket_map.get(key) != null)
      throw new Exception("Exception: The specified name is already chosen, please choose a different one");
    socket_map.put(key, socket);
  }

  public static void sendToClient(String message, String key) throws IOException {
    Socket socket = socket_map.get(key);
    PrintWriter output = new PrintWriter(socket.getOutputStream());
    output.println(message);
    output.flush();
  }

  @Override
  public void run() {

  }
}

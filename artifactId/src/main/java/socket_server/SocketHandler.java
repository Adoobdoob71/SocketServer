package socket_server;

import java.net.*;
import java.util.*;
import java.io.*;

public class SocketHandler {

  public static HashMap<String, UserSocket> socket_map = new HashMap<String, UserSocket>();

  public SocketHandler(HashMap<String, UserSocket> socket_map) {
    this.socket_map = socket_map;
  }

  public SocketHandler() {

  }

  public UserSocket getSocket(String key) throws Exception {
    UserSocket socket = socket_map.get(key);
    if (socket == null)
      throw new Exception("Exception: Could not find specified socket");
    return socket;
  }

  public static void addSocket(UserSocket socket) throws Exception {
    if (socket_map.get(socket.getNickname()) != null)
      throw new Exception("Exception: The specified name is already chosen, please choose a different one");
    socket_map.put(socket.getNickname(), socket);
    ClientThread clientThread = new ClientThread(socket);
    clientThread.start();
  }

}

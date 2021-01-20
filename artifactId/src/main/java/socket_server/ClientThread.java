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
    if (key.equalsIgnoreCase("CLOSETHREAD")) {
      input.close();
      userSocket.getSocket().close();
      this.stop();
      return;
    }
    Chat chat = new Chat();
    chat.addParticipant(this.userSocket);
    ChatClient chatClient = new ChatClient(this.userSocket, chat);
    chatClient.start();
    sendInviteToAnotherClient(key, userSocket.getNickname(), chat);
  }

  public void sendInviteToAnotherClient(String key, String inviteNickname, Chat chat) throws IOException {
    UserSocket socket = SocketHandler.socket_map.get(key);
    PrintWriter output = new PrintWriter(socket.getSocket().getOutputStream(), true);
    output.println(inviteNickname);
    chat.addParticipant(SocketHandler.socket_map.get(key));
    ChatClient chatClient = new ChatClient(SocketHandler.socket_map.get(key), chat);
    chatClient.start();
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

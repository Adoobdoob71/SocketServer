package socket_server;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ChatClient extends Thread {

  public UserSocket userSocket;
  public Chat chat;

  public ChatClient(UserSocket userSocket, Chat chat) {
    this.userSocket = userSocket;
    this.chat = chat;
  }

  public void getInput() throws Exception {
    BufferedReader input = new BufferedReader(new InputStreamReader(userSocket.getSocket().getInputStream()));
    String message = input.readLine();
    if (message.equalsIgnoreCase("CLOSETHREAD")) {
      this.stop();
      return;
    }
    chat.sendToAllParticipants(message);
  }

  @Override
  public void run() {
    try {
      getInput();
      run();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

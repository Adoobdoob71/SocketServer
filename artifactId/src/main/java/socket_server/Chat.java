package socket_server;

import java.io.PrintWriter;
import java.util.*;

public class Chat {
  private Vector<UserSocket> participants = new Vector<UserSocket>();

  public void sendToAllParticipants(String message) throws Exception {
    PrintWriter printWriter = null;
    for (UserSocket userSocket : participants) {
      printWriter = new PrintWriter(userSocket.getSocket().getOutputStream());
      printWriter.println(message);
    }
    printWriter.close();
  }

  public void addParticipant(UserSocket userSocket) {
    participants.add(userSocket);
  }
}

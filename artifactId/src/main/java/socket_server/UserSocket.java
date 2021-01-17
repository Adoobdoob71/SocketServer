package socket_server;

import java.net.*;

public class UserSocket {
  private String nickname;
  private Socket socket;

  public UserSocket(String nickname, Socket socket) {
    this.nickname = nickname;
    this.socket = socket;
  }

  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public Socket getSocket() {
    return socket;
  }

  public void setSocket(Socket socket) {
    this.socket = socket;
  }

  @Override
  public String toString() {
    return "UserSocket [nickname=" + nickname + ", socket=" + socket + "]";
  }

}

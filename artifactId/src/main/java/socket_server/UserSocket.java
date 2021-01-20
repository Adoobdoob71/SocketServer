package socket_server;

import java.net.*;

public class UserSocket implements java.io.Serializable {
  private String nickname;
  private String description;
  private transient Socket socket;

  public UserSocket(String nickname, String description, Socket socket) {
    this.nickname = nickname;
    this.description = description;
    this.socket = socket;
  }

  public UserSocket(String nickname, String description) {
    this.nickname = nickname;
    this.description = description;
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

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public String toString() {
    return "UserSocket [description=" + description + ", nickname=" + nickname + ", socket=" + socket + "]";
  }

}

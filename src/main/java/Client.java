
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
  public static void main(String[] args) {
    // 학점은행제 - 네트워크 프로그래밍 - 김석범
    try {
      // 소켓을 생성하고 localhost 및 포트 12345에서 실행 중인 서버에 연결합니다.
      Socket socket = new Socket("localhost", 12345);
      BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

      // 서버에 메시지를 보냅니다.
      String message = "안녕하세요, 서버!";
      out.println(message);

      // 서버로부터의 응답을 읽어옵니다.
      String response = in.readLine();
      System.out.println(MessageUtils.getExeTimeAsString() + "서버 응답: " + response);

      // 소켓을 닫습니다.
      socket.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
  public static void main(String[] args) {
    // 학점은행제 - 네트워크 프로그래밍 - 김석범
    try {
      // 포트 12345에서 서버 소켓을 생성
      ServerSocket serverSocket = new ServerSocket(12345);
      System.out.println(MessageUtils.getExeTimeAsString() + "서버 시작. 클라이언트 연결을 기다립니다...");

      // 클라이언트 연결을 기다리고 수락합니다.
      Socket clientSocket = serverSocket.accept();

      // 클라이언트와 통신을 위한 입력 및 출력 스트림을 생성합니다.
      BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
      PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

      // 클라이언트에서 보낸 메시지를 읽어옵니다.
      String message = in.readLine();
      System.out.println(MessageUtils.getExeTimeAsString() + "받은 메시지: " + message);

      // 클라이언트에게 응답을 보냅니다.
      out.println(MessageUtils.getExeTimeAsString() + "서버에서 받은 메시지: " + message);

      // 클라이언트 소켓과 서버 소켓을 닫습니다.
      clientSocket.close();
      serverSocket.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }


}

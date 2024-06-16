import static java.time.LocalTime.now;

public class MessageUtils {
  public static String getExeTimeAsString() {
    return "["  + now() + "]: ";
  }
}

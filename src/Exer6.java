import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Exer6 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int times = scanner.nextInt();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
    List<SignTime> signTimes = new ArrayList<>();
    for (int i=0; i<times; i++) {
      String id = scanner.next();
      String signIn = scanner.next();
      String signOut = scanner.next();
      try {
        long signInTime = simpleDateFormat.parse(signIn).getTime();
        long signOutTime = simpleDateFormat.parse(signOut).getTime();
        SignTime signTime = new SignTime(id, signInTime, signOutTime);
        signTimes.add(signTime);
      } catch (ParseException e) {
        e.printStackTrace();
      }
    }

    String minId = "";
    String maxId = "";
    long MAX_TIME = 24 * 60 * 60 * 1000;
    long MIN_TIME = 0;
    for (int i=0; i<signTimes.size(); i++) {
      if (signTimes.get(i).signInTime < MAX_TIME) {
        MAX_TIME = signTimes.get(i).signInTime;
        minId = signTimes.get(i).id;
      }
      if (signTimes.get(i).signOutTime > MIN_TIME) {
        MIN_TIME = signTimes.get(i).signOutTime;
        maxId = signTimes.get(i).id;
      }
    }
    System.out.println(minId + " " + maxId);
  }

  private static boolean isGreater(Date date1, Date date2) {
    return date1.getTime() > date2.getTime();
  }
}

class SignTime {
  String id;
  long signInTime;
  long signOutTime;

  public SignTime(String id, long signInTime, long signOutTime) {
    this.id = id;
    this.signInTime = signInTime;
    this.signOutTime = signOutTime;
  }
}

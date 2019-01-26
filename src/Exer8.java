import java.util.Scanner;

public class Exer8 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int num = scanner.nextInt();
    int currentFloor = 0;
    int times = 0;
    for (int i=0; i<num; i++) {
      int floor = scanner.nextInt();
      if (floor - currentFloor < 0) {
        times = times + 5 + (currentFloor - floor) * 4;
      } else if (floor - currentFloor > 0) {
        times = times + 5 + (floor - currentFloor) * 6;
      } else {
        times = times + 5;
      }
      currentFloor = floor;
    }
    System.out.println(times);
  }
}

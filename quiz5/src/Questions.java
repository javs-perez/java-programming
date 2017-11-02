import java.util.Scanner;

 

public class Questions {

  public static void main(String[] args) {

    int a = 1, b = 2;

    method(a, b);

    System.out.println(a + b);

  }

 

  public static void method(int a, int b) {

    a = a + b;

    b = b + a;

  }

}
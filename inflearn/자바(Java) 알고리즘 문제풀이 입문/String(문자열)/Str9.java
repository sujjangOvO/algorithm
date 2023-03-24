package inflearn.Str;

import java.util.Scanner;

public class Str9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next().replaceAll("[^0-9]",""); // [^\\d]도 같은 의미
        int num = Integer.parseInt(str);
        System.out.println(num);
    }
}

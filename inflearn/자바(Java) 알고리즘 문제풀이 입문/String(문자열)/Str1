package inflearn;

import java.util.Scanner;

public class Str1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next().toLowerCase();
        String c = scanner.next().toLowerCase();

        int result = str.length() - str.replace(c,"").length();
        // https://hianna.tistory.com/540
        // 찾는 문자의 갯수 = 원본 문자열 길이 - 찾는 문자를 모두 공백으로 변경한 문자열의 길이
        // 반복문 사용말고 해당 방법으로 해결했다

        System.out.println(result);
    }
}

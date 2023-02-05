package inflearn;

import java.awt.desktop.SystemEventListener;
import java.util.Scanner;

public class Str5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        char[] arr = str.toCharArray();
        int lt = 0;
        int rt = arr.length-1;

        while(rt>lt){
            if(!Character.isAlphabetic(arr[lt])) lt++; // Character.isAlphabetic가 false라면 특수문자이므로 그대로 넘어간다.
            else if (!Character.isAlphabetic(arr[rt])) rt--;
            else {
                // lt와 rt 둘 다 알파벳인 경우만 뒤집는다.
                char tmp = arr[lt];
                arr[lt] = arr[rt];
                arr[rt] = tmp;
                lt++;
                rt--;
            }
        }

        System.out.println(String.valueOf(arr)); // char type arr to string
    }
}

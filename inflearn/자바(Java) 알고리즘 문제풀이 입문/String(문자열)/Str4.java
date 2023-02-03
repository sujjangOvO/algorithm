package inflearn;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Str4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] arr = new String[n];

        for(int i=0; i<n; i++){
            arr[i] = scanner.next();
        }

        // 1. StringBuilder, StringBuffer의 reverse() 이용
        for(int i=0; i<n; i++){
            StringBuffer sb = new StringBuffer(arr[i]); // StringBuffer 말고 StringBuilder 써도 가능
            System.out.println(sb.reverse().toString());
        }

        // 2. 직접 뒤집기 (reverse 직접 구현) !! 중요 !!
        System.out.println(new Str4().solution(arr));

    }

    public ArrayList<String> solution(String[] str){
        ArrayList<String> answer = new ArrayList<>();

        for(String x : str){
            char[] s = x.toCharArray(); // 문자열을 char 배열로 변환

            int lt = 0, rt = x.length()-1;

            // 요 부분 중요 !
            while(lt < rt){
                char tmp = s[lt];
                s[lt] = s[rt];
                s[rt] = tmp;
                lt += 1;
                rt -= 1;
            }

            answer.add(String.valueOf(s)); // char 배열을 string 타입으로 변환 (String.valueOf(char[]))
        }

        return answer;
    }
}

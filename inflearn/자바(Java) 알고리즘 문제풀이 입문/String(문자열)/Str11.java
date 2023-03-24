package inflearn.Str;

import java.util.Scanner;

public class Str11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        char cur = s.charAt(0);
        int p = 1;

        for(int i=1; i<s.length(); i++){
            if(s.charAt(i) == cur){
                p++;
            }
            else{
                System.out.print(cur);
                if(p!=1) System.out.print(p);
                cur = s.charAt(i);
                p = 1;
            }
        }

        System.out.print(cur);
        if(p!=1) System.out.print(p);
    }

    // 인강 풀이 방법
    public String solution(String s){
        String answer = "";
        s = s + " "; // i+1을 비교할 때 boundary error가 나지 않도록 공백을 넣어줌
        int cnt = 1;

        for(int i=0; i<s.length()-1; i++){
            if(s.charAt(i) == s.charAt(i+1)) cnt++;
            else{
                answer += s.charAt(i);
                if(cnt>1) answer += String.valueOf(cnt);
                cnt = 1;
            }
        }

        return answer;
    }
}

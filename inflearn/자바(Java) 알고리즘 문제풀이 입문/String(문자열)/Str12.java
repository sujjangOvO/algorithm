package inflearn.Str;

import java.util.Scanner;

public class Str12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();

        System.out.println(new Str12().solution(n, s));

        // 그지같은 내 풀이방법 ,,,
        char[] msg = new char[n];
        int msg_cnt = 0;
        int digit = 0;

        for(int i=0; i<s.length(); i++){
            if((i%7 == 0 && i != 0) || i == s.length()-1){

                if(i == s.length()-1){
                    if(s.charAt(i) == '#') digit = digit*10 + 1;
                    else digit *= 10;
                }

                int tmp = Integer.parseInt(String.valueOf(digit),2);
                msg[msg_cnt++] = (char)tmp;

                if(s.charAt(i) == '#') digit = 1;
                else digit = 0;
            }
            else{
                if(s.charAt(i) == '#') digit =  digit*10 + 1;
                else digit *= 10;
            }
        }

        for(int i=0; i<msg.length; i++){
            System.out.print(msg[i]);
        }

    }

    // 강사님 풀이방법
    public String solution(int n, String s){
        String answer = "";

        for(int i=0; i<n; i++){
            String tmp = s.substring(0,7).replace('#','1').replace('*','0');
            int digit = Integer.parseInt(tmp,2);
            answer += (char)digit;
            s = s.substring(7);
        }

        return answer;
    }
}

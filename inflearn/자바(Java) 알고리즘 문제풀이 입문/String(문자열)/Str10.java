package inflearn.Str;

import java.util.Scanner;

public class Str10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char t = sc.next().charAt(0);
        Str10 str10 = new Str10();
        int[] answer = str10.solution(s, t);

        for(int i=0; i<s.length(); i++){
            System.out.print(answer[i]+" ");
        }
    }

    public int[] solution(String s, char t){
        int[] answer = new int[s.length()];

        // 왼쪽 t 기준 거리
        int p = 1000;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == t){
                p = 0;
                answer[i] = p;
            }
            else{
                p++;
                answer[i] = p;
            }
        }

        // 오른쪽 t 기준 거리
        p = 1000;
        for(int i=s.length()-1; i>=0; i--){
            if(s.charAt(i) == t) p = 0; // 어차피 왼쪽 t 기준에서 0 들어갔으므로 p는 0으로 초기화만
            else{
                p++;
                answer[i] = Math.min(answer[i], p); // 왼쪽 t 기준과 오른쪽 t 기준중 최소값을 answer에 대입
            }
        }

        return answer;
    }

}

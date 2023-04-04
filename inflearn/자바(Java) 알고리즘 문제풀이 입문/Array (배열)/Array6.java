package inflearn.Array;

import java.lang.reflect.Array;
import java.util.Scanner;

public class Array6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Array6 array6 = new Array6();
        for(int i=0; i<n; i++){
            int num = array6.reverseInt(sc.nextInt());
            int answer = array6.solution(num);
            if(answer != -1){
                System.out.print(answer+" ");
            }
        }
    }

    public int reverseInt(int num){ // 역수 구하는 메소드
        int answer = 0;

        while(num>0){
            answer = answer * 10 + num % 10;
            num /= 10;
        }

        return answer;
    }

    public int solution(int num){ // 강사님의 isPrime과 같은 메소드

        if(num == 0 || num == 1) return -1;

        int sqrt = (int)Math.sqrt(num);
        for(int i=2; i<=sqrt; i++){
            if(num%i == 0) return -1;
        }
        return num;
    }
}

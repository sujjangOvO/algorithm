package inflearn.Array;

import java.util.Scanner;

public class Array3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];

        for(int i=0; i<n; i++){
            a[i] = sc.nextInt();
        }
        for(int i=0; i<n; i++){
            b[i] = sc.nextInt();
        }

        new Array3().solution(n, a, b);
    }

    // 한 사람에게 기준을 맞추고 한 사람이 이기는 경우를 조건으로 두고 작성하면 효율적으로 가위바위보 판별을 가르는 알고리즘을 작성할 수 있다.
    // 이 경우는 A가 이기는 경우를 기준으로 했다. 한 사람에게 기준을 맞추는 것이 중요하다 !!
    public void solution(int n, int[] a, int[] b){
        for(int i=0; i<n; i++){
            if(a[i] == b[i]) System.out.println("D");
            else if( (a[i] == 1 && b[i] == 3) || (a[i] == 2 && b[i] == 1) || (a[i] == 3 && b[i] == 2)){
                System.out.println("A");
            }
            else{
                System.out.println("B");
            }
        }
    }
}

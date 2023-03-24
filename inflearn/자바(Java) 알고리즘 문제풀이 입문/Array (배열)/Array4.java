package inflearn.Array;

import java.util.Scanner;

public class Array4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Array4 array4 = new Array4();
        array4.solution(n);

        // 두번째 손코딩 방법
        int a=1, b=1, c;
        System.out.println(a+" "+b+" ");
        for(int i=2; i<n; i++){
            c = a+b;
            System.out.println(c+" ");
            a=b;
            b=c;
        }
    }

    // 첫번째 방법
    public void solution(int n){
        int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = 1;
        for(int i=0; i<n; i++){
            if(i==0 || i==1) System.out.print(arr[i]+" ");
            else{
                arr[i] = arr[i-1] + arr[i-2];
                System.out.print(arr[i]+" ");
            }
        }
    }
}

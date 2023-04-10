package inflearn.TwopointersANDSlidingwindow;

import java.util.ArrayList;
import java.util.Scanner;

public class Twopointers1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] a = new int[n];
        for(int i=0; i<n; i++){
            a[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();
        int[] b = new int[m];
        for(int i=0; i<m; i++){
            b[i] = scanner.nextInt();
        }

        Twopointers1 twopointers1 = new Twopointers1();

        System.out.println("solution1");
        for(int x:twopointers1.solution(n, m, a, b)){
            System.out.print(x+" ");
        }
        System.out.println();

        System.out.println("solution2");
        for(int x:twopointers1.solution2(n, m, a, b)){
            System.out.print(x+" ");
        }

    }

    public ArrayList<Integer> solution2(int n, int m, int[] a, int[] b){
        ArrayList<Integer> answer = new ArrayList<>();
        int p1 = 0, p2 = 0;

        while(p1 < n && p2 < m){
            if(a[p1] < b[p2]) answer.add(a[p1++]);
            else answer.add(b[p2++]);
        }

        while(p1<n) answer.add(a[p1++]);
        while(p2<m) answer.add(b[p2++]);

        return answer;
    }

    public ArrayList<Integer> solution(int n, int m, int[] a, int[] b){
        ArrayList<Integer> arrayList = new ArrayList<>();
        int ai = 0;
        int bi = 0;

        while(arrayList.size() != (n+m)){
            if(ai >= n){
                arrayList.add(b[bi++]);
                continue;
            }
            else if(bi >= m){
                arrayList.add(a[ai++]);
                continue;
            }

            if(a[ai] <= b[bi]){
                arrayList.add(a[ai++]);
            }
            else{
                arrayList.add(b[bi++]);
            }
        }

        return arrayList;
    }
}

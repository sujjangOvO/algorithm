package inflearn.TwopointersANDSlidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Twopointers2 {
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

        Twopointers2 twopointers2 = new Twopointers2();

        for(int x: twopointers2.solution(n, m, a, b)){
            System.out.print(x+" ");
        }
    }

    public ArrayList<Integer> solution2(int n, int m, int[] a, int[] b){
        ArrayList<Integer> arrayList = new ArrayList<>();
        int p1 = 0, p2 = 0;

        // two pointer는 항상 오름차순 정렬을 해둬야 한다 !!!!
        Arrays.sort(a);
        Arrays.sort(b);

        while(p1 < n && p2 <m){
            if(a[p1] == b[p2]) {
                arrayList.add(a[p1++]);
                p2++;
            }
            else if(a[p1] < b[p2]){ // 작은쪽이 증가 why? 오름차순 정렬이 되어있는 상태이므로 더이상 작은 값은 존재하지 않으므로
                p1++;
            }
            else{
                p2++;
            }
        }

        return arrayList;

    }

    // 잘못된 풀이
    public ArrayList<Integer> solution(int n, int m, int[] a, int[] b){
        ArrayList<Integer> arrayList = new ArrayList<>();
        int p1 = 0, p2 = 0;

        while(p2<m){
            if(p1 >= n){ // 동일한 원소가 없는 경우
                p1 = 0;
                p2++;
                continue;
            }

           if(a[p1] != b[p2]){
               p1++;
           }
           else{
               arrayList.add(b[p2]);
               p1 = 0;
               p2++;
           }
        }

        Collections.sort(arrayList);
        return arrayList;
    }
}

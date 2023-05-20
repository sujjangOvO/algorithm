package inflearn.SortingANDSearching;

import java.util.Arrays;
import java.util.Scanner;

// 6-6. 장난꾸러기
public class Sorting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scanner.nextInt();
        }
        System.out.println(new Sorting().solution(n, arr));
    }

    public String solution(int n, int[] arr){
        String answer = "";

        int[] tmp = arr.clone();
        Arrays.sort(arr);

        for(int i=0; i<n; i++){
            if(tmp[i] != arr[i]){
                answer += i+1 + " ";
            }
        }

        return answer;
    }
}

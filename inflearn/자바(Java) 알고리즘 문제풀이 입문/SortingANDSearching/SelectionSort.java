package inflearn.SortingANDSearching;

import java.util.Scanner;

// 6-1. 선택정렬
public class SelectionSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scanner.nextInt();
        }
        new SelectionSort().solution(n, arr);
    }

    public void solution(int n, int[] arr){
        for(int i=0; i<n-1; i++){
            int min = i;
            for(int j=i+1; j<n; j++){
                if(arr[min] > arr[j]) min = j;
            }

            if(i != min){
                int tmp = arr[i];
                arr[i] = arr[min];
                arr[min] = tmp;
            }
        }

        for(int i=0; i<n; i++){
            System.out.print(arr[i]+" ");
        }
    }
}

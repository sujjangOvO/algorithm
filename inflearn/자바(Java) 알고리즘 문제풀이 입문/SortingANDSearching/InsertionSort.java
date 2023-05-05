package inflearn.SortingANDSearching;

import java.util.Scanner;

// 6-3. 삽입정렬
public class InsertionSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scanner.nextInt();
        }
        new InsertionSort().solution(n, arr);
        System.out.println();
        new InsertionSort().solution2(n, arr);
    }

    public void solution2(int n, int[] arr){

        System.out.println("solution2");

        for(int i=1; i<n; i++){
            int tmp = arr[i];
            int j;

            for(j=i-1; j>=0; j--){
                if(arr[j] > tmp){
                    arr[j+1] = arr[j];
                }
                else{
                    break;
                }
            }

            arr[j+1] = tmp;
        }

        for(int i=0; i<n; i++){
            System.out.print(arr[i]+" ");
        }
    }


    public void solution(int n, int[] arr){

        System.out.println("solution1");

        for(int i=1; i<n; i++){  // 0번째 인덱스 앞에는 원소가 없으므로 1번째 인덱스부터 탐색시작
            int tmp = arr[i];
            int prev = i-1;

            while( (prev >= 0) && (arr[prev] > tmp)){
                arr[prev+1] = arr[prev];
                prev--;
            }

            arr[prev+1] = tmp;
        }

        for(int i=0; i<n; i++){
            System.out.print(arr[i]+" ");
        }
    }
}

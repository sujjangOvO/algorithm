package inflearn.SortingANDSearching;

import java.util.Scanner;

// 6-2. 버블정렬
public class BubbleSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scanner.nextInt();
        }
        new BubbleSort().solution(n, arr);
    }

    public void solution(int n, int[] arr){
        for(int i=0; i<n-1; i++){  // n-1까지 도는 이유는 처음 반복에 맨 뒤 숫자는 정렬된 상태로 고정되므로 마지막 인덱스까지 돌 필요가 없기 때문
            for(int j=0; j<n-1-i; j++){ // 버블정렬은 반복문을 반복할 떄 마다 마지막 인덱스들이 값이 고정되기 때문에 n-1-i로 고정된 값을 제외하고 비교한다
                if(arr[j] > arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
        for(int i=0; i<n; i++){
            System.out.print(arr[i]+" ");
        }
    }
}

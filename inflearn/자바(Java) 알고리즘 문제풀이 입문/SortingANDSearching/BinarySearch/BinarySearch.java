package inflearn.SortingANDSearching;

import java.util.Arrays;
import java.util.Scanner;

// 6-8. 이분검색
public class BinarySearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println(new BinarySearch().solution(n, m, arr));
    }

    public int solution(int n, int m, int[] arr) {
        int answer = -1;
        Arrays.sort(arr);
        int low = 0;
        int high = n - 1;

        // binary search
        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == m) {
                answer = mid + 1;
                break;
            } else if (arr[mid] > m) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }

        return answer;
    }
}

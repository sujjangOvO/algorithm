package inflearn.SortingANDSearching;

import java.util.Arrays;
import java.util.Scanner;

// 6-5. 중복 확인
// 해쉬맵 key값 count로 찾는게 제일 빠른 방법 => O(n)
// 그렇지만, 정렬로도 풀 수 있는 문제임을 보여주기 위함 => O(nlogn)
public class DoubleCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for(int i=0; i<n; i++){
            nums[i] = scanner.nextInt();
        }
        System.out.println(new DoubleCheck().solution(n, nums));
    }

    // 정렬 이후에 인접한 숫자가 같으면 중복 check
    public char solution(int n, int[] nums){
        char answer = 'U';

        Arrays.sort(nums);
        int prev = nums[0];

        for(int i=1; i<n; i++){
            if(prev == nums[i]){
                answer = 'D';
                break;
            }
            prev = nums[i];
        }

        /*
        for(int i=0; i<n-1; i++){
            if(nums[i] == nums[i+1]) return 'D';
        }
         */

        return answer;
    }
}

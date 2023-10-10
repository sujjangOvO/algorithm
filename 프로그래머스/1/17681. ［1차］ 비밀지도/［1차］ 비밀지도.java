class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for(int i=0; i<n; i++) {
            answer[i] = Integer.toBinaryString(arr1[i] | arr2[i]);
            answer[i] = String.format("%" + n + "s", answer[i]); // n자리로 포맷맞춤 (연산결과 맨 앞이 0일 수 있으므로)
            answer[i] = answer[i].replaceAll("0", " "); // 0은 전부 공백으로
            answer[i] = answer[i].replaceAll("1", "#"); // 1은 전부 #으로
        }
        
        return answer;
    }
}
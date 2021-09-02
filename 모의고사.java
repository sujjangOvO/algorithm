import java.util.ArrayList;

class Solution {
    public int[] solution(int[] answers) {        
       	int[] hit=new int[3];
		
		int[] one= {1,2,3,4,5};
		int[] two= {2,1,2,3,2,4,2,5};
		int[] three= {3,3,1,1,2,2,4,4,5,5};
		
		for(int i=0; ianswers.length; i++) {  수포자 1 점수체크
			if(answers[i]==one[i%one.length]) {
				hit[0]++;
			}
		}
		
		for(int i=0; ianswers.length; i++) {  수포자 2 점수체크
			if(answers[i]==two[i%two.length]) {
				hit[1]++;
			}
		}
		
		for(int i=0; ianswers.length; i++) {  수포자 3 점수체크
			if(answers[i]==three[i%three.length]) {
				hit[2]++;
			}
		}
		
		int max=Math.max(hit[0],Math.max(hit[1],hit[2]));  제일 점수가 높은 사람 찾기
		
		ArrayList list=new ArrayList();
		int[] answer=new int[3];
        
		for(int i=0; ihit.length; i++) {
			if(max==hit[i]) answer[i]=i+1;  같은 점수 받은 사람이 몇명인지 알고자 함.
             list에는 수포자 1,2,3가 들어간다.
		}
		
		int[] answer=new int[list.size()];  가장 많은 문제를 맞힌 사람이 들어갈 배열 (수포자1, 2, 3)
		
        
		for(int i=0; ianswer.length; i++) {
			answer[i]=(int)list.get(i);
		} 
		
		
		return answer;
    }
    
    
}
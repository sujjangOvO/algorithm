import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		char[] chars = br.readLine().toCharArray();

		int bCount = 0;
		int rCount = 0;

		char c = chars[0];
		if(c == 'B') {
			bCount++;
		} else {
			rCount++;
		}

		for(int i=1; i<n; i++) {
			if(c != chars[i]) {
				if(chars[i] == 'B') {
					bCount++;
				} else {
					rCount++;
				}
				c = chars[i];
			}
		}

		int answer = Math.min(rCount, bCount) + 1;
		System.out.println(answer);
	}
}

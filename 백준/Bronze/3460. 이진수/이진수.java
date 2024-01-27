import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 성능 향상을 위해 bufferedReader 사용
        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++) {
            int n = Integer.parseInt(br.readLine());
            int index = 0;

            while(n>0) {
                if(n%2 == 1) {
                    System.out.print(index + " ");
                }
                n/=2;
                index++;
            }
        }

        br.close();
    }
}

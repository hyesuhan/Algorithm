import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        
        int start = 1;
        int end = 1;
        
        // 자기 자신은 이미 포함된 값
        int curSum = 1;
        int count = 1;
        
        while (end < N) {
            if (curSum == N) {
                count++;
                end++;
                curSum += end;
            } else if (curSum < N) {
                end++;
                curSum += end;
            } else {
                curSum -= start;
                start++;
            }
        }
        
        System.out.print(count);
        
    }
}
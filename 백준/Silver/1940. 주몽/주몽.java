import java.util.*;
import java.io.*;

public class Main{
    
    public static void main(String[] args) throws IOException {
        
        List<Integer> numbers = new ArrayList<>();
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers.add(Integer.parseInt(st.nextToken()));
        }
        
        int start = 0;
        int end = numbers.size()-1;
        int result = 0;
        Collections.sort(numbers);
        
        while(start < end) {
            int curSum = numbers.get(start)+numbers.get(end);
            
            if (curSum == M) {
                result++;
                start++;
                end--;
            } else if (curSum < M) {
                start++;
            } else {
                end--;
            }
            
        }
        
        System.out.print(result);
        
    }
}
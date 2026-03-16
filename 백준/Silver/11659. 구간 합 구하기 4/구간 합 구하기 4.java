import java.util.*;
import java.io.*;

public class Main {
    
    static List<Integer> numbers = new ArrayList<>();
    
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        // 여기서 미리 누적합을 만들어 놓는다.
		int sum = 0; 
        numbers.add(sum);
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sum += Integer.parseInt(st.nextToken());
            numbers.add(sum);
        }
        
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            
            // start부터 end까지 합 = numbers의 end에서 start-1을 빼면 됨
            
            
            System.out.println(numbers.get(end) - numbers.get(start-1));
        } 
    }
    
   
    
}
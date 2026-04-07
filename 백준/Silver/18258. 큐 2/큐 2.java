import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(st.nextToken());
        
        Deque<Integer> queue = new LinkedList<>();
        
        for (int i = 0; i < N; i++) {
            
            st = new StringTokenizer(br.readLine());
            
            String command = st.nextToken();
            
            switch(command) {
                case "push":
                    int input = Integer.parseInt(st.nextToken());
                    queue.offer(input);
                    break;
                case "pop":
                    if (queue.isEmpty()) sb.append("-1\n");
                    else sb.append(queue.poll()).append("\n");
                    break;
                case "size":
                    sb.append(queue.size()).append("\n");
                    break;
                case "empty":
                    sb.append(queue.isEmpty() ? "1\n" : "0\n");
                    break;
                case "front":
                    if (queue.isEmpty()) sb.append("-1\n");
                    else sb.append(queue.peekFirst()).append("\n");
                    break;
                case "back":
                    if (queue.isEmpty()) sb.append("-1\n");
                    else sb.append(queue.peekLast()).append("\n");
                    break;
                    
                    
            }
            
            
        }
        System.out.println(sb);
        
    }
    
}
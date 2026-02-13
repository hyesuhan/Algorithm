import java.util.*;

public class Main {
    public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    
    int N = scan.nextInt();
    
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    
    for (int i = 0; i < N * N; i++) {
        int input = scan.nextInt();
        
        pq.offer(input);
        
        if(pq.size() > N) {
            pq.poll();
        }
        
    }
    
    System.out.println(pq.poll());
    
}
    
}
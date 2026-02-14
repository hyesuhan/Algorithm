import java.util.*;

public class Main {
    
    static int N;
    static Scanner scan = new Scanner(System.in);
    
    public static void inputN() {
        if (scan.hasNextInt()) {
            N = scan.nextInt();
        }
    }
    
    public static void main(String[] args) {
        inputN();
        
        // Java의 PriorityQueue는 기본적으로 최소 힙(Min-Heap)입니다.
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int i = 0; i < N; i++) {
            if (!scan.hasNextInt()) break;
            int input = scan.nextInt();
            
            if (input != 0) {
                pq.offer(input);
            } else {
                // 0을 입력받았을 때
                if (pq.isEmpty()) {
                    System.out.println(0);
                } else {
                    // poll()은 가장 작은 원소를 제거하며 반환합니다.
                    System.out.println(pq.poll());
                }
            }
        }
    }
}
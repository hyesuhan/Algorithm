import java.util.Scanner;

public class Main {
    static int N, M;
    static int[] selected, used;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        M = sc.nextInt();
        
        selected = new int[M + 1];
        
        // Used num cannot be selected
        used = new int[N + 1];
        
        rec_func(1);
        System.out.println(sb.toString());
    }
    
    static void rec_func(int k) {
        if(k == M+1) {
            // selected All
            for(int i = 1; i <= M; i++) {
                sb.append(selected[i]).append(' ');
            }
        } else {
            for (int cand = 1; cand <= N; cand++){
                if(used[cand] == 1) continue;
                
                selected[k] = cand;
                used[cand] = 1;
                
                rec_func(k+1);
                selected[k] = 0; // Back Tracking
                used[cand] = 0; // Back Tracking
                
            }
        }
        
    }
    
}
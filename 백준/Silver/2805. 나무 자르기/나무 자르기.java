import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static long M;
    static long[] trees;
    static long MaxHeight = 0;
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Long.parseLong(st.nextToken());
        trees = new long[N];
        long curMaxHeight = 0;
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            trees[i] = Long.parseLong(st.nextToken());
            if (trees[i] > curMaxHeight) curMaxHeight = trees[i];
        }
        long start = 0;
        long end = curMaxHeight;
        
        while(start<=end) {
            long mid = (start+end)/2;
            long sum = 0L;
            
            for (long tree: trees) {
            if (tree > mid) {
                sum+= tree-mid;
                if (sum >= M) break;
            }
            }
        
        
            if (sum >= M) {
                start = mid+1; 
                MaxHeight = Math.max(mid, MaxHeight);
            } else {
                end = mid-1;
            }
            
        }
        
        System.out.println(MaxHeight);
    }
    
   
    
}
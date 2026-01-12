import java.util.Scanner;
import java.lang.Math;

public class Main{
    static int N;
    static int max = Integer.MIN_VALUE; // Init
    static int min = Integer.MAX_VALUE;
    static int[] nums;
    static int[] operators = new int[4]; //+, -, *, / 순서
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        
        // input number Array,A1 ... An
        nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        
        // input operators
        for (int i = 0; i < 4; i++) {
            operators[i] =  sc.nextInt();
        }
        
        // recursive fuction
        rec_func(1, nums[0]);
        
        System.out.println(max + " " + min);
        
        sc.close();
        
    }
    
    static void rec_func(int k, int value) {
        // 1. Use All Numbers (Used N-1 Operators)
        if(k == N) {
            max = Math.max(max, value);
            min = Math.min(min, value);
            //retrun;
        }
        
        // recursive Step
        for (int i = 0; i < 4; i++) {
            if (operators[i] > 0)  {
                operators[i]--;
                
                if(i == 0) rec_func(k+1, value + nums[k]);
                else if (i == 1) rec_func(k+1, value - nums[k]);
                else if (i == 2) rec_func(k+1, value * nums[k]);
                else if (i == 3) rec_func(k+1, value / nums[k]);
                
                operators[i]++; //Back-Tracking
            }
        }
        
    }
    
}
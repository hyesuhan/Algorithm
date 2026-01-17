import java.util.Scanner;

public class Main {
    
    static int N, S;
    static int ans = 0;
    static int sum = 0; // return 값과 수열 총 합
    static int[] inputArr;
    
    static void input() {
        Scanner scan = new Scanner(System.in);
    
        N = scan.nextInt();
        S = scan.nextInt();
        
        inputArr = new int[N];
        for (int i = 0; i < N; i++) {
            inputArr[i] = scan.nextInt();
        }
        
        scan.close();
    
    }
    
    public static void main(String args[]) {
        input();
        
        dfs(0);
        System.out.println(ans);
    }
    
    static void dfs(int k) {
        for (int i = k ; i < N; i++) {
            sum += inputArr[i];
            
            //더하자마자 합이 s인가
            if(sum == S) ans++;
            
            dfs(i+1);
            sum -= inputArr[i];
            
        }
    }
    

}
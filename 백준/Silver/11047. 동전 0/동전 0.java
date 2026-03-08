import java.util.*;


public class Main {
    static int N, K;
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        
        
        
            N = scan.nextInt();
            K = scan.nextInt();
        
        
        int[] coinTypes = new int[N];
        
        for (int i = 0; i < N; i++){
            coinTypes[N-1-i] = scan.nextInt(); 
        }
        
        
        System.out.println(findResult(K, coinTypes));
        
    }
    
    static int findResult (int money, int[] coinTypes) {
        
        int count = 0;
        // 가지고 있는 동전 종류를 큰 순서대로 배열
        
        
           for (int coin: coinTypes) {
               if (money >= coin) {
                   count += money/coin;
                    money%=coin;
               }
               
                
            } 
        
               
        return count;
        
    }    
    
}
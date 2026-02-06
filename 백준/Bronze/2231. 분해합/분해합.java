import java.util.Scanner;
import java.io.*;
import java.util.*;

public class Main {
    static Scanner scan = new Scanner(System.in);
    static int N;
    
    
    static void input() {
        N = scan.nextInt();
    }
    
    static int sumOfNum(int k) {
        
        int sum = k;
        while(k > 0) {
            sum += (k % 10);
            k = k /10;
        }
        return sum;
        
    }
    
    public static void main(String[] args) {
        
        input();
        int result = 0;
        
        for (int i = 1; i < N; i++) {
            if(N == sumOfNum(i)) {
                result = i;
                break;
            }
        }
        System.out.println(result);
        
    }
    
    
}
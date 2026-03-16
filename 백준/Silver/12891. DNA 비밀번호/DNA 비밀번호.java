import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        String inputStr = br.readLine();
        
        int[] dnas = new int[N];
        for (int i = 0;i < N; i++){
            char c = inputStr.charAt(i);
            if (c=='A') dnas[i]=0;
            else if (c=='C') dnas[i]=1;
            else if (c=='G') dnas[i]= 2;
            else dnas[i] = 3;
        }
        
        
        int[] myArr = new int[4];
        int[] checkArr = new int[4];
        
        st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < 4; i++) {
            checkArr[i] = Integer.parseInt(st.nextToken());
        }
        
        int start = 0; int end = M;
        int count = 0;
        
        for (int i = start; i < end; i++) {
            myArr[dnas[i]]++;
        }
        if (checkPossible(myArr, checkArr)) count++;
        
        while(end < N) {
            
            myArr[dnas[start]]--;
            myArr[dnas[end]]++;
            
            if (checkPossible(myArr, checkArr)) count++;
            
            start++; end++;

        }
        
        System.out.println(count);
        
        
    }
    
    static boolean checkPossible(int[] arr, int[] checkArr) {
        
        for (int i = 0 ; i < 4; i++) {
            if (arr[i] < checkArr[i]) return false;
        }
        return true;
    }
    
}
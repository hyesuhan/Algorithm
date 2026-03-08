import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String input = br.readLine();
        
        String[] groups = input.split("-");
        int minSum = Integer.MAX_VALUE;
        
        for (String group: groups) {
            
            int tempSum = 0;
            
            String[] additions = group.split("\\+");
            
            for (String num: additions){
                tempSum += Integer.parseInt(num);
            }
            
            if (minSum == Integer.MAX_VALUE){
                minSum = tempSum;
            } else {
                minSum -= tempSum;
            }
            
        }
        System.out.println(minSum);
    }
    
}
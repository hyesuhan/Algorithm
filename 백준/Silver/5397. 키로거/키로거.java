import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        
        // first - test num
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());        
        
        // "-" is Back-space
        // "<" or ">" is move actions
        
        for (int i = 0; i < N; i++) {
            String input =br.readLine();
            if (input != null) findPassword(input); 
        }        
    }
    
    public static void findPassword(String str) throws IOException {
        
        
        List<String> password = new LinkedList<>();
        ListIterator<String> iter = password.listIterator();
        
        for (int i = 0; i < str.length(); i++) {
            char curChar = str.charAt(i);
            
            if (curChar == '-') {
                if (iter.hasPrevious()) {
                    iter.previous();
                    iter.remove();
                }
            } else if (curChar == '<') {
                if (iter.hasPrevious()) iter.previous();
            } else if (curChar == '>') {
                if (iter.hasNext()) iter.next();
            } else {
                iter.add(String.valueOf(curChar));
            }
            
        }
        
        System.out.println(String.join("", password));
        
        
    }
}

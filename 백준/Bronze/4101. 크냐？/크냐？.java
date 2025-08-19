import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);
        
        for(int i;;) {
            int A = s.nextInt();
            int B = s.nextInt();
            
            if(A > B)
                System.out.println("Yes");
            else if (A == 0&& B == 0)
                break;
            else
                System.out.println("No");
        }
        s.close();
        
    }
}
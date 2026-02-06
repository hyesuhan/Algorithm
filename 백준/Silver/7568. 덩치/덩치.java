import java.util.Scanner;
import java.io.*;
import java.util.*;

public class Main {
    
    static Scanner scan = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();
    static int N;
    
    static void inputN() {
        N = scan.nextInt();
    }
        
    static int[] compare(List<Student> students) {
        int[] ranks = new int[N];
        
        for (int i = 0; i < N; i++) {
            int rank = 1;
            Student cur = students.get(i);
        
            for (int j = 0; j < N; j++) {
                // Do not Compare with Myself
                if (i == j) continue;
            
                Student compare = students.get(j);
                // anyone else bigger than me
                if(compare.kg > cur.kg && compare.cm > cur.cm) {
                    rank ++;
                }
            }
            ranks[cur.index] = rank;
        }
        return ranks;
    }    
    
    public static void main(String[] args) {
        
        // inputs & array
        inputN();
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            students.add(new Student(i, scan.nextInt(), scan.nextInt()));
        }
        
        // compare
        int[] ranks = compare(students);
        
        // output - toString
        for(int i = 0; i < N ; i++) {
            sb.append(ranks[i]).append(' ');
        }
        System.out.println(sb.toString());
    }
    
    static class Student {
        int index, kg, cm;
        Student (int i, int k, int c) {
            this.index = i;
            this.kg = k;
            this.cm = c;
        }
        
    }
}


import java.util.*;
import java.io.*; // BufferedReader 등을 위해 추가

public class Main {
    public static void main(String[] args) throws IOException {
        // 1. Scanner 대신 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] seq = new int[N];
        int[] ans = new int[N];

        // 2. StringTokenizer로 한 줄에 들어온 숫자들을 빠르게 분리
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && seq[stack.peek()] < seq[i]) {
                ans[stack.pop()] = seq[i];
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            ans[stack.pop()] = -1;
        }

        // 3. StringBuilder를 사용하여 출력 문자열을 하나로 합침
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(ans[i]).append(" ");
        }
        
        // 최종적으로 한 번만 출력
        System.out.println(sb.toString());
    }
}
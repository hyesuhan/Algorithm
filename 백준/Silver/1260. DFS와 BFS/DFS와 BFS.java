
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    static FastReader scan = new FastReader();

    static int N; // 정점
    static int M; // 간선
    static int start; // 시작점
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

    static boolean[] dfsVisited;
    static boolean[] bfsVisited;

    static void input() {
        
        N = scan.nextInt();
        M = scan.nextInt();
        start = scan.nextInt();

        // 정점 번호를 인덱스와 맞춰야 한다.
        for (int i = 0; i<= N; i++) {
            adj.add(new ArrayList<Integer>());
        }

        // 간선 정보를 입력한다.
        for (int i = 0; i< M; i++) {
            int u = scan.nextInt(); // 시작 정점
            int v = scan.nextInt(); // 연결할 정점

            adj.get(u).add(v); // u번 리스트에 v를 추가한다.
            adj.get(v).add(u); // 양방향 처리
        }
         
        // 정점은 작은 순서대로 진입해야 하기에 미리 정렬해둔다.
        for (int i = 1; i<= N; i++) {
            Collections.sort(adj.get(i));
        }

        // 시작 전 visited를 init
        dfsVisited = new boolean[N+1];
        bfsVisited = new boolean[N+1];
    
    }

    static void dfs(int x) {
        System.out.print(x + " ");
        dfsVisited[x] = true; // 시작점은 방문 처리

        for (int y: adj.get(x)) {
            // 이미 방문한 적이 있다면 건너뛴다.
            if(dfsVisited[y]) continue;

            dfs(y);
        }
    }

    static void bfs(int x) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        bfsVisited[start] = true; // 시작점은 방문 처리

        while (!queue.isEmpty())  {
            int y = queue.poll();
            System.out.print(y + " ");
            
            for (int i: adj.get(y)) {
                // 이미 방문한 적이 있다면 건너뛴다.
                if(bfsVisited[i]) continue;

                // i를 방문 가능하므로 queue에 추가하고 visit 처리
                queue.add(i);
                bfsVisited[i] = true;
            }
        }

    }


    public static void main(String args[]) {

        input();
        // dfs 결과
        dfs(start);
        System.out.println("");
        //bfs 결과
        bfs(start);

    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader () {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());

                } catch (IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
 
    }


}

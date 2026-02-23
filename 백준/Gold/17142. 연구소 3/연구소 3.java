import java.util.*;
import java.io.*;

public class Main {

    static FastReader scan = new FastReader();
    static int N, M;
    static int[][] graph;
    static List<Point> virusCand = new ArrayList<>();
    static Point[] active;
    static int totalEmptyRoom = 0;
    static int minTime = Integer.MAX_VALUE;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        graph = new int[N][N];
        active = new Point[M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                graph[i][j] = scan.nextInt();
                if (graph[i][j] == 0) {
                    totalEmptyRoom++;
                } else if (graph[i][j] == 2) {
                    virusCand.add(new Point(i, j));
                }
            }
        }
    }

    public static void main(String args[]) {
        input();

        // 처음부터 빈 칸이 없으면 0 출력 후 종료
        if (totalEmptyRoom == 0) {
            System.out.println(0);
            return;
        }

        rec_func(0, 0);

        System.out.println(minTime == Integer.MAX_VALUE ? -1 : minTime);
    }

    static void rec_func(int k, int start) {
        if (k == M) {
            bfs();
            return;
        }

        for (int i = start; i < virusCand.size(); i++) {
            active[k] = virusCand.get(i);
            rec_func(k + 1, i + 1);
        }
    }

    static void bfs() { 
        Queue<Point> queue = new LinkedList<>(); 
        boolean[][] visited = new boolean[N][N];
        int currentEmptyCount = totalEmptyRoom; 

        for (Point p : active) {
            visited[p.x][p.y] = true;
            queue.offer(p);
        }

        int time = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Point cur = queue.poll();

                for (int d = 0; d < 4; d++) {
                    int nx = cur.x + dx[d];
                    int ny = cur.y + dy[d];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                    if (visited[nx][ny] || graph[nx][ny] == 1) continue;

                    if (graph[nx][ny] == 0) currentEmptyCount--;

                    if (currentEmptyCount == 0) {
                        minTime = Math.min(minTime, time + 1);
                        return;
                    }

                    visited[nx][ny] = true;
                    queue.add(new Point(nx, ny));
                }
            }
            time++;
            if (time >= minTime) return;
        }
    }

    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
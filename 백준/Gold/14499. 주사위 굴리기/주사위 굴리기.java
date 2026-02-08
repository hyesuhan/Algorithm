import java.util.*;

class Main {
    
    // 지도 세로 크기 N
    // 지도 가로 크기 M
    // 주사위 처음 위치 x, y
    // 명령의 개수 k
    static int N, M;
    static int x, y;
    static int k;
    static int[][] map; // 지도 배열 추가
    
    static Scanner scan = new Scanner(System.in);
    
    // 지도의 x, y 좌표를 나타내는 객체
    static class Where {
        int x, y;
        Where(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    // input - 지도 모양과 현재 위치
    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        x = scan.nextInt();
        y = scan.nextInt();
        k = scan.nextInt();
        
        map = new int[N][M]; // 지도 크기 초기화
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = scan.nextInt();
            }
        }
    }

    static int[] inputCommand() {
        int[] command = new int[k];
        for (int i = 0; i < k; i++) {
            command[i] = scan.nextInt();
        }
        return command;
    }

    //  주사위 굴리는 메서드
    /*
     * 인덱스 정의
     * 0(위) 1(뒤) 2(오) 3(왼) 4(앞) 5(아래)
    */
    static int[] rollDice(int[] dice, int dir) {
        // 값 복사를 위해 새로운 배열 생성 (참조 오류 방지)
        int[] next = dice.clone();
        
        switch(dir) {
            case 1: // 동쪽 (Right)
                next[0] = dice[3];
                next[2] = dice[0];
                next[5] = dice[2];
                next[3] = dice[5];
                break;
            case 2: // 서쪽 (Left)
                next[0] = dice[2];
                next[3] = dice[0];
                next[5] = dice[3];
                next[2] = dice[5];
                break;
            case 3: // 북쪽 (Up)
                next[0] = dice[4];
                next[1] = dice[0];
                next[5] = dice[1];
                next[4] = dice[5];
                break;
            case 4: // 남쪽 (Down)
                next[0] = dice[1];
                next[4] = dice[0];
                next[5] = dice[4];
                next[1] = dice[5];
                break;
        }
        return next;
    }
    
    // 현재 주사위와 지도를 비교하는 메서드
    static void compareToMap (Where where, int[][] map, int[] dice) {
        int r = where.x;
        int c = where.y;
        
        // 이동 칸에 쓰여 있는 수가 0
        // 주사위 바닥면 수가 칸에 복사
        if (map[r][c] == 0) {
            map[r][c] = dice[5];
        } else {
            // 0이 아닌 경우 지도의 수가 주사위 바닥면으로 복사
            // 칸은 0
            dice[5] = map[r][c];
            map[r][c] = 0;
        }
    }
    
    public static void main(String[] args) {
        input();
        int[] commands = inputCommand();
        Where mapCur = new Where(x, y);
        
        // 초기 주사위 면은 모두 0으로 시작 (문제 조건)
        int[] dice = new int[6]; 
        
        // 방향 벡터 (동, 서, 북, 남 순서: 1, 2, 3, 4)
        int[] dx = {0, 0, 0, -1, 1};
        int[] dy = {0, 1, -1, 0, 0};
        
        for (int i = 0; i < k; i++) {
            int dir = commands[i];
            
            // 1. 이동할 위치 계산
            int nx = mapCur.x + dx[dir];
            int ny = mapCur.y + dy[dir];
            
            // 2. 지도 경계 체크 (범위를 벗어나면 해당 명령 무시)
            if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
            
            // 3. 위치 업데이트 및 주사위 굴리기
            mapCur.x = nx;
            mapCur.y = ny;
            dice = rollDice(dice, dir);
            
            // 4. 지도와 주사위 값 비교/복사
            compareToMap(mapCur, map, dice);
            
            // 5. 주사위 윗면 출력
            System.out.println(dice[0]);
        }
    }
}
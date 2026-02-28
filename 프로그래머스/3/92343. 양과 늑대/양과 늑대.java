import java.util.*;

class Solution {
    
    // 인접 행렬을 인접 리스트로 변경
    int maxSheep = 0;
    int[] nodeInfo;
    List<Integer>[] tree;
    
    public int solution(int[] info, int[][] edges) {
        nodeInfo = info;
        int n = info.length;
        tree = new ArrayList[n];
        
        for (int i = 0; i < n; i++) {
            // 인접 리스트로 만들기 위한 기본 세팅
            tree[i] = new ArrayList<>();
        }
        
        // 인접리스트로 재구성 부모 => 자식
        for (int[] edge: edges) {
            tree[edge[0]].add(edge[1]);
        }
        
        // 후보군을 만듭니다.
        List<Integer> cand = new ArrayList<>();
        for (int child: tree[0]) {
            cand.add(child);
        }
        
        // 루트= 양(1)
        dfs(0,1,0,cand);
        
        
        return maxSheep;
    }
    
    
    private void dfs(int index, int sheep, int wolf, List<Integer> cand) {
        
        // 현재까지 양 개수 max
        maxSheep = Math.max(sheep, maxSheep);
        
        // 현재 cand(후보군)에서 하나씩 가봅니다.
        for (int i = 0; i < cand.size(); i++){
            // 다음 인덱스 = 인접 리스트에 연결되어 있는 자식 노드들
            int nextIndex = cand.get(i);
            int nextSheep = sheep;
            int nextWolf= wolf;
            
            // 자식에 따라 갯수를 셈
            if (nodeInfo[nextIndex] == 0) {
                 nextSheep++;
            } else {
                nextWolf++;
            }
            
            // 만약 늑대가 더 많으면 해당 경로로 지금 갈 수 없습니다.
            if (nextWolf >= nextSheep) continue;
            
            // 새로운 후보군을 넣습니다.
            List<Integer> newCand = new ArrayList<>(cand);
            newCand.remove(i);
            for (int child: tree[nextIndex]) {
                newCand.add(child);
            }
            
            dfs(nextIndex, nextSheep, nextWolf, newCand);
        
        }
    }
    
    
}
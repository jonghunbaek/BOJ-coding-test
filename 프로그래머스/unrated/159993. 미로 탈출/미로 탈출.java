import java.util.*;

class Solution {
    static int[][] miro;
    static int[][] tempMiro;
    static Node ent;
    static Node exit;
    static Node lever;
    static int[] ax = {1,-1,0,0};
    static int[] ay = {0,0,1,-1};
    
    static class Node {
        int x,y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public int solution(String[] maps) {
        int answer = 0;
        miro = new int[maps.length][maps[0].length()];
        tempMiro = new int[maps.length][maps[0].length()];
        for (int i=0; i<miro.length; i++) {
            String temp = maps[i];
            for (int j=0; j<miro[i].length; j++) {
                if (temp.charAt(j) == 'X') {
                    miro[i][j] = -1;
                    tempMiro[i][j] = -1;
                    continue;
                }
                if (temp.charAt(j) == 'S') {
                    ent = new Node(i, j); 
                }
                if (temp.charAt(j) == 'E') {
                    exit = new Node(i, j);
                }
                if (temp.charAt(j) == 'L') {
                    lever = new Node(i,j);
                }
            }
        }
        bfs(ent, lever);
        if (miro[lever.x][lever.y] == -1) {
            answer = -1;
            return answer;
        }
        answer = miro[lever.x][lever.y];
        miro = tempMiro;
        bfs(lever, exit);
        if (miro[exit.x][exit.y] == -1) {
            answer = -1;
            return answer;
        }
        answer += miro[exit.x][exit.y];
        return answer;
    }
    
    public void bfs(Node start, Node end) {
        Queue<Node> q = new LinkedList<Node>();
        q.add(start);
        
        while (!q.isEmpty()) {
            Node now = q.poll();
            for (int i=0; i<4; i++) {
                int nx = ax[i] + now.x;
                int ny = ay[i] + now.y;
                if (nx == end.x && ny == end.y) {
                    miro[nx][ny] = miro[now.x][now.y] + 1;
                    return;
                }
                if (nx >= 0 && ny >= 0 && nx <miro.length && ny<miro[0].length && miro[nx][ny] == 0) {
                    q.add(new Node(nx, ny));
                    miro[nx][ny] = miro[now.x][now.y] + 1;
                }
            }
        }
        miro[end.x][end.y] = -1;
    }
}
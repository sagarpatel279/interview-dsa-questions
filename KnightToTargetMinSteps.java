import java.util.*;

public class KnightToTargetMinSteps {
    private static int sum;
    public static void main(String[] args) {
        int[][] board=new int[8][8];
        int[] k={5,2};
        int[] t={7,1};
        System.out.println(getMinSteps(board,k,t));
    }
    
    private static int getMinSteps(int[][] board,int[] k,int[] t){
        int n=board.length, m=board[0].length;
        int minSteps=Integer.MAX_VALUE;
        Queue<int[]> queue=new LinkedList<>();
        int[][] dir={{2,1},{-2,1},{2,-1},{-2,-1},
                    {1,2},{-1,2},{1,-2},{-1,-2}};
        boolean[][] visit=new boolean[n][m];
        int[][] dist=new int[n][m];
        queue.add(k);
        while(!queue.isEmpty()){
            int[] currK=queue.poll();
            int k_i=currK[0], k_j=currK[1];
            visit[k_i][k_j]=true;
            for(int d=0;d<dir.length;d++){
                int i= k_i+ dir[d][0];
                int j= k_j+ dir[d][1];
                if(isValidMove(i,j,n,m) && !visit[i][j]){
                    queue.add(new int[]{i,j});
                    dist[i][j]=dist[k_i][k_j]+1;
                    if(t[0]==i && t[1]==j){
                        minSteps=Math.min(minSteps,dist[i][j]);
                    }
                }
            }
        }
        return minSteps;
    }
    
    private static boolean isValidMove(int i,int j,int n,int m){
        return i>=0 && j>=0 && i<n && j<m;
    }
}


//   0 1 2 3 4 5 6 7
// 0 0 0 0 0 0 0 0 0
// 1 0 0 0 0 0 0 0 0    
// 2 0 0 0 0 0 0 0 0
// 3 0 0 0 0 0 0 0 0
// 4 0 0 0 0 0 0 0 0
// 5 0 0 K 0 0 0 0 0
// 6 0 0 0 0 0 0 0 0
// 7 0 T 0 0 0 0 0 0
    
    
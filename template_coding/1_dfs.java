class Solution {
    void dfs(int[][] grid, boolean vis[][], AtomicInteger r, int i, int j, int m, int n){
        if(i>=0&&i<m&&j>=0&&j<n&&grid[i][j]==1&&!vis[i][j]){
            vis[i][j]=true;
            r.set(r.get()+1);
            dfs(grid, vis, r, i-1, j, m, n);
            dfs(grid, vis, r, i+1, j, m, n);
            dfs(grid, vis, r, i, j-1, m, n);
            dfs(grid, vis, r, i, j+1, m, n);
        }
    }
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int c = 0;
        boolean vis[][] = new boolean[m][n];
        AtomicInteger r = new AtomicInteger();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    c++;
                    if(i==0 || j==0 || i==m-1 || j == n-1){
                        if(!vis[i][j]){
                            dfs(grid, vis, r, i, j, m, n);
                        }
                    }
                }
            }
        } 
        return c - r.get();
    }
}
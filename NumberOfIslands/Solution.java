class Solution {
    void flood(char[][] grid, int i, int j, int m, int n){
        if (i<0 || i >= m || j < 0 || j >= n || grid[i][j] == '2' || grid[i][j] == '0')
            return;
        grid[i][j] = '2';
        flood(grid,i+1,j,m,n);
        flood(grid,i-1,j,m,n);
        flood(grid,i,j+1,m,n);
        flood(grid,i,j-1,m,n);
    }
    public int numIslands(char[][] grid) {
        int m = grid.length;
        if (0==m)
            return 0;
        int n = grid[0].length;
        if (0==n)
            return 0;
        int num = 0;
        for(int i = 0; i < m; ++i)
            for(int j = 0; j < n; ++j){
                if(grid[i][j] == '1'){
                    num +=1;
                    flood(grid,i,j,m,n);
                }
            }
        return num;
    }
}
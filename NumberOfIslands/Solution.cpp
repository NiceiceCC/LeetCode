class Solution {
public:
    void flood(vector<vector<char>>& grid, int i,int j, int m, int n){
        if (i<0 or j<0 or i>=m or j>=n or grid[i][j] == '2' or grid[i][j] == '0')
            return;
        grid[i][j] = '2';
        flood(grid,i-1,j,m,n); 
        flood(grid,i+1,j,m,n);
        flood(grid,i,j-1,m,n);
        flood(grid,i,j+1,m,n);
            
    }
    int numIslands(vector<vector<char>>& grid) {
        int num = 0;
        int m = grid.size();
        if(m==0)
            return num;
        int n = grid[0].size();
        if(n==0)
            return num;
        
        for(int i = 0; i < m;++i)
            for(int j = 0; j < n; ++j){
                if (grid[i][j]=='1'){
                    flood(grid,i,j,m,n);
                    ++num;
                }
                
            }
        return num;
    }
};
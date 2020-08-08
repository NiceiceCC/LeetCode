class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        M = len(grid)
        if M==0:
            return 0
        N = len(grid[0])
        if N == 0:
            return 0
        
        num = 0
        def flood(i,j):
            nonlocal grid,M,N
            if grid[i][j] in ['0','2']:
                return
            grid[i][j] = '2' #mark visited position
            for ni,nj in [[i+1,j],[i-1,j],[i,j+1],[i,j-1]]:
                #search four directions
                if 0<=ni<M and 0<=nj<N and grid[ni][nj] == '1':
                    flood(ni,nj)
        
        for i in range(M):
            for j in range(N):
                if grid[i][j] == '1':
                    num+=1
                    flood(i,j)
        return num
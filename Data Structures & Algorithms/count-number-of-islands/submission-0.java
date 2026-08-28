class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                if(grid[i][j]=='1'){
                    count++;
                    helper(grid,i,j);
                }
            }
        }

        return count;
    }

    private void helper(char[][] grid, int r, int c){
        grid[r][c] = 0;

        if(r-1 >=0 && grid[r-1][c]=='1'){
            helper(grid,r-1,c);
        }
           if(r+1 <grid.length && grid[r+1][c]=='1'){
            helper(grid,r+1,c);
        }
        if(c-1 >=0 && grid[r][c-1]=='1'){
            helper(grid,r,c-1);
        }
        if(c+1 <grid[0].length && grid[r][c+1]=='1'){
            helper(grid,r,c+1);
        }

        return;

    }
}

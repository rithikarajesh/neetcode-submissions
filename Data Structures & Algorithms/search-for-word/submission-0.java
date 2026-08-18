class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
 
        for(int i = 0; i < rows; i++){
            for(int j = 0; j< cols; j++){
                if(helper(board, word, i, j, 0, visited)){
                    return true;
                }
            }
        }
        return false;
    }

    private Boolean helper(char[][] board,String word, int row, int col, int i, boolean[][]    visited){
        if(i==word.length()){
            return true;
        }

        if(row<0 || col <0 || row >= board.length || col >= board[0].length
        || visited[row][col] 
        || word.charAt(i)!= board[row][col]
        ){
            return false;
        }

        visited[row][col] = true;
        Boolean res = helper(board,word, row-1,col, i+1, visited)
        || helper(board,word, row+1,col, i+1, visited)
        || helper(board,word, row,col+1, i+1, visited)
        || helper(board,word, row,col-1, i+1, visited);

        visited[row][col] = false;
        return res;
    }
}

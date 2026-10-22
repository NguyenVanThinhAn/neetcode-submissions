class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> map = new HashSet<>();
        for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board[r].length; c++){
                if(board[r][c] != '.'){
                    String row = "r" + String.valueOf(r) + "_" + board[r][c];
                    if(!map.add(row)){
                        return false;
                    }
                }
                if(board[c][r] != '.'){
                    String col = "c" + String.valueOf(r) + "_" + board[c][r];
                    if(!map.add(col)){
                        return false;
                    }
                }
                if(board[r][c] != '.'){
                    String box = "b" + (r / 3) + "_" + (c / 3) + "_" + board[r][c];
                    if(!map.add(box)){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}

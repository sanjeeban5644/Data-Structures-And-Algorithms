public class validSudoku {

    public static void main(String[] args) {
        char[][] board ={{'5','3','.','.','7','.','.','.','.'}
                            ,{'6','.','.','1','9','5','.','.','.'}
                            ,{'.','9','8','.','.','.','.','6','.'}
                            ,{'8','.','.','.','6','.','.','.','3'}
                            ,{'4','.','.','8','.','3','.','.','1'}
                            ,{'7','.','.','.','2','.','.','.','6'}
                            ,{'.','6','.','.','.','.','2','8','.'}
                            ,{'.','.','.','4','1','9','.','.','5'}
                            ,{'.','.','.','.','8','.','.','7','9'}};
        System.out.print(isValidSudoku(board));
    }

    public static boolean isValidSudoku(char[][] board) {
        int n = board.length;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(board[i][j]!='.'){
                    if(!isSafe(board,i,j,board[i][j])){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    static boolean isSafe(char[][] board,int row,int col,char number){
        // left right
        for(int i = 0;i<board.length;i++){
            if(i!=col && board[row][i]==number){
                return false;
            }
        }
        // up down
        for(int i = 0;i<board.length;i++){
            if(i!=row && board[i][col]==number){
                return false;
            }
        }

        int sqrt = (int)(Math.sqrt(board.length));
        int rowstart = row - (row%sqrt);
        int colstart = col - (col%sqrt);
        for(int i = rowstart;i<rowstart+sqrt;i++){
            for(int j = colstart;j<colstart+sqrt;j++){
                if(i!=row && j!=col && board[i][j]==number){
                    return false;
                }
            }
        }
        return true;
    }



}

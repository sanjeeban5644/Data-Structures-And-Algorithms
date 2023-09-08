public class NQueen
{
    static boolean isSafe(boolean[][] board,int row,int col){
        for(int i = row;i>=0;i--){
            if(board[i][col]==true){
                return false;
            }
        }
        int r = row;
        for(int c=col;c>=0 && r>=0; r--,c--){
            if(board[r][c]==true){
                return false;
            }
        }
        r = row;
        for(int c = col;c<board[0].length && r>=0;c++,r--){
            if(board[r][c]==true){
                return false;
            }
        }
        return true;
    }

    static void display(boolean[][] board){
        int n = board.length;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(board[i][j]){
                    System.out.print("Q ");
                }else{
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    static int nQueen(boolean[][] board,int row){
        if(row==board.length){
            display(board);
            return 1;
        }
        int count = 0;
        for(int i = 0;i<board[0].length;i++){
            if(isSafe(board,row,i)){
                board[row][i]=true;
                count+=nQueen(board,row+1);
                board[row][i]=false;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int n = 4;
        boolean[][] board = new boolean[n][n];
        int solutions = nQueen(board,0);
        System.out.println("Total no.of solutions is : "+solutions);
    }
}

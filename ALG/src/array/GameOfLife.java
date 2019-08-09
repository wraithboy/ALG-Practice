package array;

public class GameOfLife {

    public void gameOfLife(int[][] board) {

        if(board==null || board.length==0)
            return;

        int row=board.length;
        int col=board[0].length;

        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                int lives=0;

                for(int x=Math.max(0,i-1);x<=Math.min(i+1,row-1);x++)
                {
                    for(int y=Math.max(0,j-1);y<=Math.min(j+1,col-1);y++)
                    {
                        lives += board[x][y]&1;
                    }
                }

                if(board[i][j]==1 && (lives==3 || lives==4))
                    board[i][j]=3;

                if(board[i][j]==0 && lives==3)
                    board[i][j]=2;

            }
        }

        for(int i=0;i<row;i++) {
            for (int j = 0; j < col; j++) {

                board[i][j]=board[i][j]>>1;

            }

        }

    }
}

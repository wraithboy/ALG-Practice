package dfs;

public class WordSearch {

    public boolean exist (char[][] board,String word)
    {
        if(board==null || word ==null || word.length()==0)
            return false;

        int row = board.length;
        int col = board[0].length;

        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                if(DFS(0,board,i,j,word))
                    return true;
            }
        }
        return false;
    }

    public boolean DFS(int curr, char[][] board,int i, int j, String word)
    {
        if(curr==word.length())
        {
            return true;
        }

        if( i>=0 && i<board.length && j>=0 && j<board[0].length && board[i][j]==word.charAt(curr))
        {
            char tmp=board[i][j];
            board[i][j]='#';
            boolean rlt= DFS(curr+1,board,i+1,j,word) || DFS(curr+1,board,i-1,j,word) || DFS(curr+1,board,i,j+1,word) || DFS(curr+1,board,i,j-1,word);
            board[i][j]=tmp;
            return rlt;
        }
        else
        {
            return false;
        }
    }
}

package dfs;

import java.util.Arrays;

public class NQueensII {
    public int totalNQueens(int n) {

        int[] result =new int[1];

        int[] queenCol = new int[n];

        Arrays.fill(queenCol,-1);

        int row = 0;

        DFS(row,result,queenCol);

        return result[0];
    }

    public void DFS(int row,int[] result,int[] queenCol)
    {
        if(row==queenCol.length)
        {
            result[0]++;
            return;
        }

        for(int i=0;i<queenCol.length;i++)
        {
            if(isValid(queenCol,row,i))
            {
                queenCol[row]=i;
                DFS(row+1,result,queenCol);
                queenCol[row]=-1;
            }
        }
    }

    public boolean isValid(int[] queenCol,int row,int col)
    {
        for(int i=0;i<row;i++)
        {
            if(queenCol[i]==col || row-i == Math.abs(col-queenCol[i]))
                return false;
        }
        return true;
    }
}

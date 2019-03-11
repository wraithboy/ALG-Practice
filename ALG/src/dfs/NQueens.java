package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class NQueens {



    public List<List<String>> solveNQueens(int n) {

        if(n==0 || n==1 || n==2 )
            return null;

        int[] queenCols = new int[n];

        for(int i=0;i<n;i++)
        {
            queenCols[i]=-1;
        }

        ArrayList<List<String>> result =new ArrayList<>();

        DFS(new LinkedList<String>(),0,queenCols,result);

        return result;

    }


    public void DFS(LinkedList<String> curr,int row,int[] queenCols,List<List<String>> result)
    {
        if(row==queenCols.length-1)
        {
            ArrayList<String> grid = new ArrayList<String>();
            for(int i=0;i<queenCols.length;i++)
            {
                char[] line = new char[queenCols.length];
                Arrays.fill(line,'.');
                line[queenCols[i]]='Q';
                grid.add(String.valueOf(line));
            }
            result.add(grid);
            return;
        }

        for(int i=0;i<queenCols.length;i++)
        {
            if(isValid(queenCols,row,i))
            {
                queenCols[row]=i;
                DFS(curr,row+1,queenCols,result);
                queenCols[row]=-1;
            }
        }

    }


    boolean isValid(int[] queenCols,int row,int col)
    {
        for(int i=0;i<row;i++)
        {
            if(queenCols[row]==col || Math.abs(row-i)==Math.abs(col-queenCols[i]))
            {
                return false;
            }
        }

        return true;
    }

}

package dfs;

public class NumOfIslands {
    public int numIslands(char[][] grid)
    {
        if(grid==null || grid.length==0)
            return 0;
        int row = grid.length;
        int col = grid[0].length;

        if(row==0 || col==0)
            return 0;

        int count=0;

        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                if(grid[i][j]=='1')
                {
                    count++;
                    DFS(grid,i,j);
                }
            }
        }

        return count;
    }

    public void DFS(char[][] grid,int i,int j)
    {
        if(i>=grid.length || j>=grid[0].length || i<0 || j<0 )
            return;

        if(grid[i][j]=='1')
        {
            grid[i][j]='0';

            DFS(grid,i-1,j);
            DFS(grid,i+1,j);
            DFS(grid,i,j-1);
            DFS(grid,i,j+1);
        }
    }
}

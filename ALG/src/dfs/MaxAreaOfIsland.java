package dfs;

public class MaxAreaOfIsland {

    public int maxAreaOfIsland(int[][] grid) {

        if(grid ==null || grid.length==0 || grid[0].length==0 )
        {
            return 0;
        }

        int max=0;

        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==0)
                    continue;
                max=Math.max(max,DFS(grid,i,j));
            }
        }

        return max;
    }

    private int DFS(int[][] grid,int i, int j)
    {
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length)
            return 0;

        int sum=1;

        grid[i][j]=0;

        int left=DFS(grid,i-1,j);
        int right=DFS(grid,i+1,j);
        int up=DFS(grid,i,j-1);
        int down=DFS(grid,i,j+1);

        return sum+left+right+up+down;
    }
}

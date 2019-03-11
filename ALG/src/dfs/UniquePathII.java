package dfs;

public class UniquePathII {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        if(obstacleGrid==null || obstacleGrid[0][0]==1 || obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1]==1)
            return 0;

        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;

        int[][] matrix =new int[m][n];

        matrix[0][0]=obstacleGrid[0][0]==1?0:1;

        for(int i=1;i<n;i++)
        {
            if(obstacleGrid[0][i]!=1)
                matrix[0][i]=matrix[0][i-1];
        }

        for(int j=1;j<m;j++)
        {
            if(obstacleGrid[j][0]!=1)
                matrix[j][0]=matrix[j-1][0];
        }

        for(int i=1;i<m;i++)
        {
            for(int j=1;j<n;j++)
            {
                if(obstacleGrid[i][j]==1)
                    matrix[i][j]=0;
                else
                    matrix[i][j]=matrix[i-1][j]+matrix[i][j-1];
            }
        }
        return matrix[m-1][n-1];
    }
}

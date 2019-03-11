package dfs;

public class UniquePath {

    public int uniquePaths(int m, int n) {

        return path(1,1,m,n,0);
    }

    public int path(int x,int y,int m,int n,int count)
    {
        if(x==m&&y==n)
            return count+1;

        return path(x+1,y,m,n,count)+path(x,y+1,m,n,count);
    }
}

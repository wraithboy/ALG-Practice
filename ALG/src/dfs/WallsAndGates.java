package dfs;

public class WallsAndGates {

    public void wallsAndGates(int[][] rooms) {

        if(rooms==null || rooms.length==0 || rooms[0].length==0 )
        {
            return;
        }

        for(int i=0;i<rooms.length;i++)
        {
            for(int j=0;j<rooms[i].length;j++)
            {
                if(rooms[i][j]==0)
                {
                    DFS(i,j,rooms,0);
                }
            }
        }
    }

    private void DFS(int i,int j,int[][] rooms,int distance)
    {
        if(rooms[i][j]==-1 || rooms[i][j]<distance)
            return;

        rooms[i][j]=distance;

        if(i-1>=0)
        {
            DFS(i-1,j,rooms,distance+1);
        }

        if(i+1<rooms.length)
        {
            DFS(i+1,j,rooms,distance+1);
        }

        if(j-1>=0)
        {
            DFS(i,j-1,rooms,distance+1);
        }

        if(j+1<rooms[i].length)
        {
            DFS(i,j+1,rooms,distance+1);
        }
    }
}

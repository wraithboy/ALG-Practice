package amazonOA;

import java.util.LinkedList;
import java.util.Queue;

public class ZombieInMatrix {

    private static final int ZOMBIE = 1;
    private static final int[][] DIR = {{0,1},{1,0},{0,-1},{-1,0}};

    public static void main(String[] args) {

        ZombieInMatrix zombieInMatrix = new ZombieInMatrix();

        int[][] grid = {{0, 1, 1, 0, 1},
                {0, 1, 0, 1, 0},
                {0, 0, 0, 0, 1},
                {0, 1, 0, 0, 0}};

        int days = zombieInMatrix.zombieInMatrix(grid);

        System.out.println(days);
    }

    public int zombieInMatrix(int[][] grid) {

        if(grid==null || grid.length==0 || grid[0].length==0)
            return 0;

        int people = 0;

        Queue<Point> zQ= new LinkedList<>();

        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==ZOMBIE)
                {
                    zQ.add(new Point(i,j));
                }
                else
                {
                    people++;
                }
            }
        }

        if(people==0)
            return 0;

        for(int hours = 1;!zQ.isEmpty();hours++)
        {
            for(int sz=zQ.size();sz>0;sz--)
            {
                Point p = zQ.remove();

                for(int[] d : DIR)
                {
                    int x = p.x+d[0];
                    int y = p.y+d[1];

                    if(isHuman(grid,x,y))
                    {
                        people--;
                        if(people==0)
                            return hours;
                        grid[x][y]=ZOMBIE;
                        zQ.add(new Point(x,y));
                    }
                }
            }

        }

        return -1;
    }


    private boolean isHuman(int[][] grid, int r, int c) {
        return r >= 0 && r < grid.length &&c >= 0 && c < grid[0].length && grid[r][c] != ZOMBIE;
    }
}

class Point{
    int x;
    int y;
    public Point(int x, int y)
    {
        this.x=x;
        this.y=y;
    }
}
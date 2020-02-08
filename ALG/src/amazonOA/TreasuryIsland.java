package amazonOA;

import java.util.LinkedList;
import java.util.Queue;

public class TreasuryIsland {

    private static final int[][] DIRS = {{0,1},{0,-1},{1,0},{-1,0}};

    public static int treasureIsland(char[][] island) {
        if (island == null || island.length == 0) return 0;

        Queue<Point> queue = new LinkedList<>();

        int steps=1;

        island[0][0]='D';

        queue.add(new Point(0,0));


        while(!queue.isEmpty())
        {
            int size = queue.size();

            for(int i=0;i<size;i++)
            {
                Point p = queue.remove();

                for(int[] dir : DIRS)
                {
                    int x=p.x+dir[0];
                    int y=p.y+dir[1];

                    if(isSafe(island,x,y))
                    {
                        if(island[x][y]=='X') return steps;
                        island[x][y]='D';
                        queue.add(new Point(x,y));
                    }
                }

            }

            steps++;
        }

        return -1;
    }

    private static boolean isSafe(char[][] grid, int r, int c) {
        return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] != 'D';
    }

    public static void main(String[] args) {
        char[][] island = new char[][]{
                {'O', 'O', 'O', 'O'},
                {'D', 'O', 'D', 'O'},
                {'O', 'O', 'O', 'O'},
                {'X', 'D', 'D', 'O'}
        };
        int result = TreasuryIsland.treasureIsland(island);
        System.out.println(String.format("%s (expect 5)", result));
    }

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}

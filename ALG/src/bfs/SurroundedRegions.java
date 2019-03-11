package bfs;

import java.util.LinkedList;
import java.util.Queue;

class Point {

    public int x;
    public int y;

    public Point(int x, int y)
    {
        this.x=x;
        this.y=y;
    }
}


public class SurroundedRegions {




    public void solve(char[][] board) {

        if(board==null || board.length==0 || board[0].length==0) return;

        Queue<Point> queue = new LinkedList<>();

        int m = board.length;
        int n = board[0].length;

        for(int i=0;i<n;i++)
        {
            if(board[0][i]=='O')
                queue.add(new Point(0,i));
            if(board[m-1][i]=='O')
                queue.add(new Point(m-1,i));
        }

        for(int j=0;j<m;j++)
        {
            if(board[j][0]=='O')
                queue.add(new Point(j,0));

            if(board[j][n-1]=='O')
                queue.add(new Point(j,n-1));
        }

        int[][] direction = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

        while(!queue.isEmpty())
        {
            Point p = queue.poll();
            board[p.x][p.y]='1';
            for(int i=0;i<4;i++)
            {
                int nx=p.x+direction[i][0];
                int ny=p.y+direction[i][1];
                if(nx>0 && nx<m && ny>0 && ny<n && board[nx][ny]=='O')
                {
                    queue.add(new Point(nx,ny));
                }

            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == '1')
                    board[i][j] = 'O';
                else if (board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }
    }
}

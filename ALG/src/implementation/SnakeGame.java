package implementation;

import java.util.*;

public class SnakeGame {

    class Point{
        public int x;
        public int y;

        Point (int x, int y)
        {
            this.x=x;
            this.y=y;
        }

        public boolean equals(Object o)
        {
            if(o instanceof Point)
            {
                Point p = (Point)o;
                return this.x==p.x && this.y==p.y;
            }
            return false;
        }

        public int hashCode(){
            return Objects.hash(x,y);
        }
    }

    int row;
    int col;
    int score=0;
    int[][] board;
    Deque<Point> snake;
    Set<Point> body;

    public SnakeGame(int width, int height, int[][] food) {
        row=height;
        col=width;
        board=new int[row][col];
        for(int[] f: food)
        {
            board[f[0]][f[1]]=1;
        }
        snake = new LinkedList<Point>();
        body=new HashSet<>();
        Point p=new Point(0,0);
        snake.add(p);
        body.add(p);
    }

    public int move(String direction) {

        Point head = snake.getFirst();

        Point next;

        if ("U".equals(direction)) {
            next = new Point(head.x-1, head.y);
        } else if ("D".equals(direction)) {
            next = new Point(head.x+1, head.y);
        } else if ("L".equals(direction)) {
            next = new Point(head.x, head.y-1);
        } else {
            next = new Point(head.x, head.y+1);
        }

        if(next.x<0 || next.x==row || next.y<0 || next.y==col)
        {
            return -1;
        }

        if(!next.equals(snake.getLast()) && body.contains(next))
        {
            return -1;
        }

        snake.add(next);
        body.add(next);

        if(board[next.x][next.y]==1)
        {
            score++;
        }
        else
        {
            Point last = snake.removeLast();
            body.remove(last);
        }

        return score;
    }
}

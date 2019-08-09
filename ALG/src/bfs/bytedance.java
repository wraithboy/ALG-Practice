package bfs;

/*
4*4

        * 0 0 *



        X X 0 X



        G 0 0 G



        0 * 0 0


        * - item



        0 - empty



        X - wall



        G - guard



        for each item, find its



        distance from the closest



        guard



        5 0 0 4



        X X 0 X



        G 0 0 G



        0 2 0 0


        n*n, k items, m guards
*/

class Position{
    int x;
    int y;
    int distance;

    public Position(int x, int y,int distance)
    {
        this.x=x;
        this.y=y;
        this.distance=distance;
    }
}

public class bytedance {



    public class Main {
        public static void main(String[] args) {
            System.out.println("Hello World!");





        }



        public void shortDistance(char[][] matrix,int k)
        {

            Queue<Position> queue = new LinkedList<Position>();

            boolean[][] visited;

            int[][] result = new int[matrix.length][matrix[0].length];

            for(int i=0;i<matrix.length;i++)
            {
                for(int j=0;j<matrix[0].length;j++)
                {
                    if(matrix[i][j]=='G')
                    {
                        visited = new boolean[matrix.length][matrix[0].length];

                        visited[i][j]=true;

                        queue.add(new Position(x,y,0));

                        while(!queue.isEmpty())
                        {
                            Position p = queue.remove();

                            if(matrix[p.x][p.y]=='*')
                            {
                                result[p.x][p.y]=Math.min(result[p.x][p.y],p.distance);
                            }

                            if(matrix[p.x][p.y]=='X')
                                continue;

                            // move up

                            if(p.x+1<matrix.length && matrix[p.x+1][p.y]=='0' &&visited[p.x+1][p.y]!=true)
                            {
                                visited[p.x+1][p.y]=true;
                                queue.add(new Position(p.x+1,p.y,p.distance+1));
                            }

                            // move down
                            if(p.x-1>=0 && matrix[p.x-1][p.y]=='0' && visited[p.x-1][p.y]!=true)
                            {
                                visited[p.x-1][p.y]=true;
                                queue.add(new Position(p.x-1,p.y,p.distance+1));
                            }

                            //move left

                            if(p.y-1>=0 && && matrix[p.x][p.y-1]=='0' && visited[p.x][p.y-1]!=true)
                            {
                                visited[p.x][p.y-1]=true;
                                queue.add(new Position(p.x,p.y-1,p.distance+1));
                            }

                            //move right
                            if(p.y+1<matrix[0].length && && matrix[p.x][p.y+1]=='0' && visited[p.x][p.y+1]!=true)
                            {
                                visited[p.x][p.y+1]=true;
                                queue.add(new Position(p.x,p.y+1,p.distance+1));
                            }

                        }

                    }
                }
            }




        }
    }

}

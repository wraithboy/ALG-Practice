package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class IsBipartite {

    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];

        //-1 blue, 1 red


        for(int i=0;i<graph.length;i++)
        {
            if(color[i]==0)
            {
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                color[i]=1;
                while(!queue.isEmpty())
                {
                    int size=queue.size();

                    for(int k=0;k<size;k++)
                    {
                        int node = queue.poll();
                        for(int n:graph[node]) {
                            if (color[n] == 0) {
                                color[n] = -color[node];
                                queue.add(n);
                            } else if (color[n] == color[node])
                                return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}

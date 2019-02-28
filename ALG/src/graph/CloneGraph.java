package graph;


import java.util.*;

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};

public class CloneGraph {

    public Node cloneGraph(Node node) {

        HashMap<Node,Node> map = new HashMap<>();

        Queue<Node> queue = new LinkedList<>();

        queue.add(node);

        while(!queue.isEmpty())
        {
            int size = queue.size();

            for(int i=0;i<size;i++)
            {
                Node cur = queue.poll();

                map.put(cur,null);

                for(Node n : cur.neighbors)
                {
                    if(map.containsKey(n))
                    {
                        continue;
                    }
                    else
                    {
                        map.put(n,null);
                        queue.add(n);
                    }
                }

                Node copy =new Node(cur.val,new ArrayList<Node>());
                map.put(cur,copy);
            }
        }

        for(Node n:map.keySet())
        {
            Node c = map.get(n);

            for(Node m: n.neighbors)
            {
                c.neighbors.add(map.get(m));
            }
        }

        return map.get(node);

    }

    public Node cloneGraphDFS(Node node) {

        HashMap<Node,Node> map = new HashMap<>();

        return DFS(node,map);
    }

    public Node DFS(Node node,HashMap<Node,Node> map)
    {
        if(node==null)
            return null;

        if(map.containsKey(node))
        {
            return map.get(node);
        }

        map.put(node, new Node(node.val, new ArrayList<Node>()));

        for(Node n: node.neighbors)
        {
            map.get(node).neighbors.add(DFS(n,map));
        }

        return map.get(node);
    }

}

package Tree;

public class UniqueBinarySearchTree {

    public int numTrees(int n) {

        int[] G = new int[n+1];
        G[0]=1;
        G[1]=1;

        int sum=0;

        for(int i=2;i<=n;i++)
        {
            for(int j=1;j<=i;j++)
            {
                G[i]=G[i]+G[j-1]*G[i-j];
            }
        }

        return G[n];
    }
}

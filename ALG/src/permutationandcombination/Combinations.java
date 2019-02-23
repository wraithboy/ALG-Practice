package permutationandcombination;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

    public List<List<Integer>> combine(int n, int k) {
        if(k>n || n<1)
        {
            return null;
        }

        if(k==0)
        {
            return new ArrayList<List<Integer>>(null);
        }

        ArrayList<List<Integer>> result = new ArrayList<>();

        DFS(new ArrayList<Integer>(),k,n,1,result);
        return result;
    }

    public void DFS(List<Integer> curr,int k,int n,int start,List<List<Integer>> result)
    {
        if(curr.size()==k)
        {
            result.add(curr);
            return;
        }

        for(int i=start;i<=n;i++)
        {
            curr.add(i);
            DFS(curr,k,n,i+1,result);
            curr.remove(curr.size()-1);
        }

    }

}

package DFS;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<>();

        if(n==0)
            return result;

        DFS("",0,0,n,result);

        return result;

    }

    public void DFS(String cur,int l,int r,int n,List<String> result)
    {
        if(l==n && r==n)
        {
            result.add(cur);
        }

        if(l<n)
        {
            DFS(cur+'(',l+1,r,n,result);
        }

        if(r<l)
        {
            DFS(cur+')',l,r+1,n,result);
        }
    }

}

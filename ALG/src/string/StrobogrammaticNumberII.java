package string;

import java.util.ArrayList;
import java.util.List;

public class StrobogrammaticNumberII {

    public List<String> findStrobogrammatic(int n) {

        List<String> result = new ArrayList<>();

        DFS(0,n-1,new char[n],result);

        return result;
    }

    private void DFS(int l,int r,char[] cur,List<String> result)
    {
        if(l>r)
        {
            result.add(String.valueOf(cur));
            return;
        }

        if(l==r)
        {
            cur[l]='0';
            result.add(String.valueOf(cur));
            cur[l]='1';
            result.add(String.valueOf(cur));
            cur[l]='8';
            result.add(String.valueOf(cur));
            return;
        }

        if(l!=0)
        {
            cur[l]='0';cur[r]='0';
            DFS(l+1,r-1,cur,result);
        }

        cur[l]='6';cur[r]='9';
        DFS(l+1,r-1,cur,result);
        cur[l]='9';cur[r]='6';
        DFS(l+1,r-1,cur,result);
        cur[l]='8';cur[r]='8';
        DFS(l+1,r-1,cur,result);
        cur[l]='1';cur[r]='1';
        DFS(l+1,r-1,cur,result);

    }



}

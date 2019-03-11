package dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {

        if(s==null || s.length()==0 || s.length()<4 || s.length()>12)
            return null;

        List<String> result = new ArrayList<>();

        DFS(new LinkedList<String>(),0,s,result);

        return result;
    }

    public void DFS(LinkedList<String> cur, int start,String s,List<String> result)
    {
        if(cur.size()==4 && start==s.length())
        {
            result.add(cur.get(0)+"."+cur.get(1)+"."+cur.get(2)+"."+cur.get(3));
        }

        if(cur.size()>4 || start>s.length())
            return;

        for(int i=1;i<=3 && start+i<=s.length();i++)
        {

            if(Integer.valueOf(s.substring(start,start+i))>255 || i>=2 && s.charAt(start)=='0')
                break;

            cur.add(s.substring(start,start+i));
            DFS(cur, start +i, s, result);
            cur.removeLast();
        }

    }
}

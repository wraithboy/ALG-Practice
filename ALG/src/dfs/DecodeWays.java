package dfs;

public class DecodeWays {

    public int numDecodings(String s) {

        if(s==null || s.length()==0)
            return 0;
        return DFS(s);
    }

    private int DFS(String s)
    {

        if(s.charAt(0)=='0')
            return 0;

        if(s.length()==1)
        {
            return 1;
        }

        int ways=DFS(s.substring(1));

        if(Integer.valueOf(s.substring(0,2))<=26)
        {
            ways=ways+DFS(s.substring(2));
        }

        return ways;
    }

}

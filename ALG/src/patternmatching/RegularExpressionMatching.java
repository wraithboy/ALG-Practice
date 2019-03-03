package patternmatching;

public class RegularExpressionMatching {

    public boolean isMatch(String s, String p) {

        if(p.isEmpty()) return s.isEmpty();

        if(p.length()==1)
        {
            return s.length()==1 && (s.charAt(0)==p.charAt(0) || p.charAt(0)=='.');
        }

        if(p.length()>1 && p.charAt(1)!='*')
        {
            return (s.charAt(0)==p.charAt(0)||p.charAt(0)=='.')&&isMatch(s.substring(1),p.substring(1));
        }

        while(!s.isEmpty() && (s.charAt(0)==p.charAt(0) || p.charAt(0)=='.'))
        {
            if(isMatch(s,p.substring(2))) return true;

            s.substring(1);
        }

        return isMatch(s, p.substring(2));
    }

    // if p[j]!=* , then T[i][j] = if s[i]==[j]|| j[i]=='.' && T[i-1][j-1]
    // if[j] == * , then T[i][j] = T[i][j-2] || T[i-1][j] && s[i]==p[j-1] || p[j-1]==.


    public boolean isMatchDP(String s, String p)
    {

        boolean[][] T = new boolean[s.length()+1][p.length()+1];

        T[0][0] = true;


        for(int i=1;i<p.length()+1;i++)
        {
            if(p.charAt(i-1)=='*')
                T[0][i]=T[0][i-1];
        }

        for(int i=1;i<T.length;i++)
        {
            for(int j=1;j<T[0].length;j++)
            {
                if(p.charAt(j-1)=='.' || p.charAt(j-1)==s.charAt(i-1))
                {
                    T[i][j]=T[i-1][j-1];
                }
                else if(p.charAt(j-1)=='*')
                {
                    T[i][j]=T[i][j-2];
                    if(p.charAt(j-2)==s.charAt(i-1) || p.charAt(j-2)=='.')
                        T[i][j]=T[i][j] || T[i-1][j];
                }
                else
                {
                    T[i][j]=false;
                }
            }
        }

        return T[s.length()][p.length()];
    }

}

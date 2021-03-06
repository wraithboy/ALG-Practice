package dfs;

import java.util.*;

public class RemoveInvalidParenthesis {

    public List<String> removeInvalidParentheses(String s) {

        List<String> result = new LinkedList<String>();

        int leftP = 0, rightP = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                leftP++;
            }

            if (s.charAt(i) == ')') {
                if (leftP == 0) {
                    rightP++;
                } else {
                    leftP--;
                }
            }
        }

        DFS(0, s, leftP, rightP, result);
        return result;
    }


    public List<String> BFS(String s)
    {
        List<String> result = new ArrayList<>();
        Set<String> visited = new HashSet<>();

        Queue<String> queue = new LinkedList<>();

        boolean isFound = false;

        queue.offer(s);

        while(!queue.isEmpty() && !isFound)
        {
            int size = queue.size();

            for(int i=0;i<size;i++)
            {
                String str = queue.poll();

                if(isValid(str))
                {
                    result.add(str);
                }

                for(int j=0;j<str.length();j++)
                {
                    if(str.charAt(j)!='(' && str.charAt(j)!=')')
                        continue;
                    String t=str.substring(0,j).concat(str.substring(j+1));

                    if(!visited.contains(t)) {
                        queue.add(t);
                        visited.add(t);
                    }
                }
            }
        }
        return result;
    }


    public void DFS(int curr,String s,int left,int right,List<String> result)
    {
        if(left<0 || right <0)
            return;

        if(left==0 && right==0)
        {
            if(isValid(s))
                result.add(s);
        }

        for(int i=curr;i<s.length();i++)
        {

            if(i!=curr&&s.charAt(i)==s.charAt(i-1)) continue;

            if(s.charAt(i)==')')
            {
                DFS(i,s.substring(0,i)+s.substring(i+1),left,right-1,result);
            }
            else if(s.charAt(i)=='(')
            {
                DFS(i,s.substring(0,i)+s.substring(i+1),left-1,right,result);
            }
        }

    }

    public boolean isValid(String s)
    {
        int l=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='(')
            {
                l++;
            }else if(s.charAt(i)==')')
            {
                if(l==0)
                {
                    return false;
                }
                else
                {
                    l--;
                }
            }

        }

        return l==0;
    }
}

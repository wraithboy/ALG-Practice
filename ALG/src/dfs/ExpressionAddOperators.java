package dfs;

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {

    public static void main(String args[])
    {

        ExpressionAddOperators eao = new ExpressionAddOperators();

        eao.addOperators("123",6);

    }


    public List<String> addOperators(String num, int target) {

        List<String> result = new ArrayList<>();

        if(num==null || num.length()==0)
            return result;

        DFS(0,"",num,0,0,target,result);

        return result;
    }


    private void DFS(int cur,String expr,String num,long eval,long prev,int target,List<String> result)
    {
        if(cur==num.length())
        {
            if(eval==target)
            {
                result.add(expr);
            }

            return;
        }

        for(int i=cur;i<num.length();i++)
        {

            if(i!=cur && num.charAt(i)-'0'==0) break;

            long n=Long.valueOf(num.substring(cur,i+1));

            if(cur==0)
            {
                DFS(i+1,expr+n,num,n,n,target,result);
            }
            else
            {
                DFS(i+1,expr+"+"+n,num,eval+n,n,target,result);
                DFS(i+1,expr+"-"+n,num,eval-n,-n,target,result);
                DFS(i+1,expr+"*"+n,num,eval+prev*n-prev,prev*n,target,result);
            }
        }
    }
}

package stack;

import java.util.List;
import java.util.Stack;

public class ExclusiveTimeOfFunctions {

    public int[] exclusiveTime(int n, List<String> logs) {

        int[] result = new int[n];

        Stack<Integer> stack = new Stack<Integer>();

        String[] s=logs.get(0).split(":");

        stack.push(Integer.valueOf(s[0]));

        int i=1,prev=Integer.valueOf(s[2]);

        while(i<logs.size())
        {
            s=logs.get(i).split(":");

            if(s[1].equals("start"))
            {
                if(!stack.isEmpty())
                    result[stack.peek()] += Integer.valueOf(s[2])-prev;
                stack.push(Integer.valueOf(s[0]));
                prev=Integer.valueOf(s[2]);
            }
            else
            {
                result[stack.peek()] +=Integer.valueOf(s[2])-prev+1;
                stack.pop();
                prev=Integer.valueOf(s[2])+1;
            }

            i++;
        }

        return result;

    }

}

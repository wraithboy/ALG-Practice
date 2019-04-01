package stack;

import java.util.Stack;

public class BasicCalculatorII {

    public static void main(String args[])
    {
        BasicCalculatorII cal=new BasicCalculatorII();
        System.out.println(cal.calculate("3+2*2"));
    }

    public int calculate(String s) {

        if(s==null || s.length()==0)
            return 0;

        Stack<Integer> stack = new Stack<>();
        int num=0;
        char sign='+';

        for(int i=0;i<s.length();i++)
        {
            if(Character.isDigit(s.charAt(i)))
            {
                num=num*10+s.charAt(i)-'0';
            }

            if(!Character.isDigit(s.charAt(i)) && s.charAt(i)!=' ' || i==s.length()-1)
            {
                System.out.println(i);
                if(sign=='-')
                {
                    stack.push(-num);
                }

                if(sign=='+')
                {
                    stack.push(num);
                }

                if(sign=='*')
                {
                    stack.push(stack.pop()*num);
                }

                if(sign=='/')
                {
                    stack.push(stack.pop()/num);
                }

                sign=s.charAt(i);
                num=0;
            }

        }

        int res=0;
        while(!stack.isEmpty())
        {
            res=res+stack.pop();
        }

        return res;
    }
}

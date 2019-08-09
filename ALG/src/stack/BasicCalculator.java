package stack;

import java.util.Stack;

public class BasicCalculator {

    public static void main(String args[])
    {
        BasicCalculator c=new BasicCalculator();

        System.out.println(c.calculate("(1+(4+5+2)-3)+(6+8)"));
    }

    public int calculate(String s) {

        Stack<Integer> stack = new Stack<>();
        Stack<Character> operator = new Stack<>();

        int num=0;

        for(int i=0;i<s.length();i++)
        {
            char c = s.charAt(i);

            if(Character.isDigit(c))
            {
                num=num*10+c-'0';

                while(i+1<s.length() && Character.isDigit(s.charAt(i+1)))
                {
                    num=num*10+s.charAt(i+1)-'0';
                    i++;
                }
                stack.push(num);
                num=0;
            }
            else if(c=='+' || c=='-')
            {
                while(!operator.isEmpty() && operator.peek()!='(')
                {
                    int num1=stack.pop();
                    int num2=stack.pop();
                    stack.push(calc(num2,num1,operator.pop()));
                }
                operator.add(c);
            }
            else if(c=='(')
            {
                operator.push(c);
            }
            else if(c==')')
            {
                int sum=0;
                while(!operator.isEmpty() && operator.peek()!='(')
                {
                    int num1=stack.pop();
                    int num2=stack.pop();
                    sum=calc(num2,num1,operator.pop());
                    stack.push(sum);
                }
                operator.pop();
            }
        }

        int result=0;

        while(!operator.isEmpty())
        {
            result=calc(stack.pop(),stack.pop(),operator.pop());
            stack.push(result);
        }

        return result;
    }

    private int calc(int val1,int val2,char operator)
    {
        if(operator=='+')
        {
            return val1+val2;
        }
        else if(operator=='-')
        {
            return val1-val2;
        }
        return -1;
    }
}

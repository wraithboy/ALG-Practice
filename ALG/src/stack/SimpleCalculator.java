package stack;

import java.util.Stack;

public class SimpleCalculator {

    public static void main(String args[])
    {
        SimpleCalculator sc=new SimpleCalculator();
        System.out.println(sc.calculate("(3+8)"));
    }

    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        Stack<Character> operators= new Stack<>();
        int result=0;
        int num=0;
        char sign='+';
        for(int i=0;i<s.length();i++)
        {
            char c = s.charAt(i);

            if(Character.isDigit(c))
            {
                num=num*10+c-'0';
                while(i+1<s.length() && Character.isDigit(s.charAt(i+1))) {
                    i++;
                    num = num * 10 + s.charAt(i) - '0';
                }
                stack.push(num);
                num=0;
            }
            else if(c=='+')
            {
                    while(!operators.isEmpty() && operators.peek()!='(') {
                        if (operators.pop() == '+') {
                            stack.push(stack.pop() + stack.pop());
                        } else {
                            stack.push(stack.pop() * stack.pop());
                        }
                    }

                    operators.push(c);
            }
            else if(c=='*')
            {

                    while(!operators.isEmpty() && operators.peek()!='('){
                        if(operators.pop()=='+')
                        {
                            stack.push(stack.pop()+stack.pop());
                        }
                        else
                        {
                            stack.push(stack.pop()*stack.pop());
                        }
                    }
                    operators.push(c);
            }
            else if(c=='(')
            {
                operators.push(c);
            }
            else if(c==')')
            {
                while(!operators.isEmpty() && operators.peek()!='(')
                {
                    if(operators.pop()=='+')
                    {
                        stack.push(stack.pop()+stack.pop());
                    }
                    else
                    {
                        stack.push(stack.pop()*stack.pop());
                    }
                }
                operators.pop();
            }
        }

        while(!operators.isEmpty())
        {
            if(operators.pop()=='+')
            {
                stack.push(stack.pop()+stack.pop());
            }
            else
            {
                stack.push(stack.pop()*stack.pop());
            }
        }

        return stack.peek();
    }

}

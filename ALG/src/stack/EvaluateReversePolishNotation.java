package stack;

import java.util.Stack;

public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {

        if(tokens == null || tokens.length==0)
            return 0;

        Stack<Integer> stack = new Stack<>();

        for(String str : tokens)
        {
            if(str.equals("-") || str.equals("+") || str.equals("*") || str.equals("/"))
            {
                if(str.equals("+"))
                {
                    stack.push(stack.pop()+stack.pop());
                }
                else if(str.equals("-"))
                {
                    stack.push(stack.pop()-stack.pop());
                }
                else if(str.equals("*"))
                {
                    stack.push(stack.pop()*stack.pop());
                }
                else{
                    stack.push(stack.pop()/stack.pop());
                }
            }
            else
            {
                int num = Integer.valueOf(str);
                stack.push(num);
            }
        }

        return stack.pop();
    }
}

package datastructure;

import java.util.Stack;

public class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> min;

    public MinStack() {
        // do intialization if necessary
        stack=new Stack<>();
        min=new Stack<>();
    }

    /*
     * @param number: An integer
     * @return: nothing
     */
    public void push(int number) {
        // write your code here
        stack.push(number);

        if(min.isEmpty())
        {
            min.push(number);
        }
        else
        {
            if(number<min.peek())
            {
                min.push(number);
            }
        }
    }

    /*
     * @return: An integer
     */
    public int pop() {
        // write your code here
        int number=stack.pop();

        if(number==min.peek())
        {
            min.pop();
        }

        return number;
    }

    /*
     * @return: An integer
     */
    public int min() {
        // write your code here
        min.peek();
    }
}
package datastructure;

import java.util.Stack;

public class StackSorting {

	public void stackSorting(Stack<Integer> stack) {
	
		Stack<Integer> helper = new Stack<>();
		
		while(!stack.isEmpty())
		{
			
			int i=stack.pop();
			
			while(!helper.isEmpty() && i>helper.peek())
			{
				stack.push(helper.pop());
			}
			
			stack.push(i);
			
		}
		
		while(!helper.isEmpty())
		{
			stack.push(helper.pop());
		}
		
	}
}

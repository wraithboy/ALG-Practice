package CodingImplementation;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackusingQueues {
	
	public Queue<Integer> queue1=new LinkedList<Integer>();
	
	public Queue<Integer> queue2=new LinkedList<Integer>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	    // Push element x onto stack.
	    public void push(int x) {
	        
	    	queue1.add(x);
	    }

	    // Removes the element on top of the stack.
	    public void pop() {
	        while(queue1.size()>1)
	        {
	        	queue2.add(queue1.poll());
	        }
	        
	        queue1.poll();
	        Queue tmp=queue2;
	        queue2=queue1;
	        queue1=tmp;
	    }

	    // Get the top element.
	    public int top() {
	        while(queue1.size()>1)
	        {
	        	queue2.add(queue1.poll());
	        }
	        
	        int i=queue1.poll();
	        
	        queue2.add(i);
	        
	        Queue tmp=queue2;
	        queue2=queue1;
	        queue1=tmp;
	        
	        return i;
	    }

	    // Return whether the stack is empty.
	    public boolean empty() {
	        return queue1.isEmpty();
	    }
	
}



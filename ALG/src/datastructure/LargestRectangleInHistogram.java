package datastructure;

import java.util.Stack;

public class LargestRectangleInHistogram {
	
	public static void main(String args[])
	{
		int[] a={2,0,2};
		System.out.println("result is"+largestRectangleArea(a));
	}
	
	
    public static int largestRectangleArea(int[] height) {
    	
    	if(height==null || height.length==0 )
    		return 0;
    	
    	Stack<Integer> stack= new Stack<Integer>();
    	
    	int max=0;
    	
    	for(int i=0;i<=height.length;i++)
    	{
    		int current=i==height.length?-1:height[i];
    		while(!stack.isEmpty() && current<=height[stack.peek()])
    		{
    			int h=stack.pop();
    			
    			int w;
    			if(stack.isEmpty())
    			{
    				w=i;
    			}
    			else
    			{
    				w=i-stack.peek()-1;
    			}
    			
    			max=Math.max(max, height[h]*w);
    		}
    		stack.push(i);
    	}
    	
    	return max;
    }
	

    public int largestRectangleAreaBruteForce(int[] height) {
        // write your code here
    	
    	if(height==null || height.length==0 )
    		return 0;
    	
    	int maxRec=Integer.MIN_VALUE;
    	
    	for(int i=0;i<height.length;i++)
    	{
    		
    		int min=height[i];
    		for(int j=i;j>=0;j--)
    		{
    			if(height[j]<min)
    			{
    				min=height[j];
    			}
    			
    			int area=min*(i-j+1);
    			
    			if(maxRec<area)
    			{
    				maxRec=area;
    			}
    				
    		}
    		
    	}
    	
    	return maxRec;
    	
    }
	
}

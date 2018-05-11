package datastructure;

/*

Given an integer array, heapify it into a min-heap array.

For a heap array A, A[0] is the root of heap, and for each A[i], A[i * 2 + 1] is the left child of A[i] and A[i * 2 + 2] is the right child of A[i].
Example
Given [3,2,1,4,5], return [1,2,3,4,5] or any legal heap array.

*/

public class Heapify {
		
    public void heapify(int[] A) {
        // write your code here
    	
    	for(int i=A.length;i>=0;i--)
    	{
    		
    		
    		
    	}
    	
    }
    
    
    public void siftdown(int[] A,int i)
    {
    	if(i>A.length-1)
    		return;
    	if(i*2+1 > A.length-1)
    	{
    		return;
    	}
    	
    	int left=Integer.MAX_VALUE;int right=Integer.MAX_VALUE;
    	
    	if(i*2+2>A.length-1)
    	{
    		if(A[i]>A[i*2+1])
    		{
    			int tmp=A[i];
    			A[i]=A[i*2+1];
    			A[i*2+1]=tmp;
    		}
    	}
    	else
    	{
    		if(A[i*2+1]>A[i*2+2])
    		{
        		if(A[i]>A[i*2+2])
        		{
        			int tmp=A[i];
        			A[i]=A[i*2+2];
        			A[i*2+2]=tmp;
        		}
    		}
    		else
    		{
        		if(A[i]>A[i*2+1])
        		{
        			int tmp=A[i];
        			A[i]=A[i*2+1];
        			A[i*2+1]=tmp;
        		}
    		}
    	}
    	
    }
	
}

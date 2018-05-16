package datastructure;

/*

Given an integer array, heapify it into a min-heap array.

For a heap array A, A[0] is the root of heap, and for each A[i], A[i * 2 + 1] is the left child of A[i] and A[i * 2 + 2] is the right child of A[i].
Example
Given [3,2,1,4,5], return [1,2,3,4,5] or any legal heap array.

*/

public class Heapify {
	
	public static void main (String args[])
	{
		
		int[] A={45,39,32,11};
		
		Heapify.heapify(A);
		
		for(int i=0;i<A.length;i++)
		{
			System.out.println(A[i]);
		}
		
	}
	
    public static void  heapify(int[] A) {
        // write your code here
    	
    	for(int i=A.length/2;i>=0;i--)
    	{
    		siftdown(A,i);
    	}
    	
    }
    
    public static void siftdown2(int[] A, int i)
    {
    	
    	int min=i;
    	
    	while(i<A.length)
    	{
    		
    		if(2*i+1<A.length && A[2*i+1]<A[min])
    		{
    			min=2*i+1;
    		}
    		
    		if(2*i+2<A.length && A[2*i+2]<A[min])
    		{
    			min=2*i+2;
    		}
    		
    		if(min==i)
    		{
    			break;
    		}
    		
    		int tmp=A[min];
    		A[min]=A[i];
    		A[i]=tmp;
    		i=min;
    	}
    }
    
    
    public static void  siftdown(int[] A,int i)
    {
    	while(i<A.length)
    	{
    		
    		if(i*2+1>A.length-1)
    		{
    			break;
    		}
    		
    		if(i*2+1<=A.length-1 && i*2+2>A.length-1)
    		{
    			if(A[i*2+1]<A[i])
    			{
    				int tmp=A[i];
    				A[i]=A[i*2+1];
    				A[i*2+1]=tmp;
        			i=i*2+1;
    			}
    			else
    			{
    				break;
    			}    			
    		}
    		
    		if(i*2+1<A.length && i*2+2<A.length)
    		{
    			
    			if(A[i*2+1]<A[i*2+2])
    			{
    				if(A[i]>A[i*2+1])
    				{
        				int tmp=A[i];
        				A[i]=A[i*2+1];
        				A[i*2+1]=tmp;
        				i=i*2+1;
    				}
    				else
    				{
        				break;
    				}
    			}
    			else
    			{
    				if(A[i]>A[i*2+2])
    				{
        				int tmp=A[i];
        				A[i]=A[i*2+2];
        				A[i*2+2]=tmp;
        				i=i*2+2;
    				}
    				else
    				{
        				break;
    				}
    			}
    		}
    		
    	}
    	
    }
	
}

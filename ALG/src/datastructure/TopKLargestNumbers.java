package datastructure;

public class TopKLargestNumbers {
	
	
	public static void main(String args[])
	{
		int[] A= {3,10,1000,-99,4,100};
		
		TopKLargestNumbers a =new TopKLargestNumbers();
		
		int[] rlt=a.topk(A, 6);
		
		System.out.println(rlt[0]+""+rlt[1]+rlt[2]+rlt[3]+rlt[4]+rlt[5]);
		
	}
	
    public int[] topk(int[] nums, int k) {
        // write your code here
    	int[] result = new int[k];
    	
    	heapify(nums);
    	
    	for(int i=0;i<k;i++)
    	{
    		result[i]=nums[0];
    		
    		nums[0]=nums[nums.length-i-1];
    		
    		siftdown(nums,0,nums.length-i);
    	}
    	
    	return result;
    }
    
    public void siftdown(int[] A,int k,int j)
    {
    	int max=k;
    	while(k<j)
    	{
    		
    		if(2*k+1<j && A[max]<A[2*k+1])
    		{
    			max=2*k+1;
    		}
    		
    		if(2*k+2<j && A[max]<A[2*k+2])
    		{

    			max=2*k+2;
    		}
    		
    		if(max==k)
    		{
    			break;
    		}
    		
			int tmp=A[k];
			A[k]=A[max];
			A[max]=tmp;
			k=max;
    	}
    }
    
    
    public void heapify(int[] A)
    {
    	for(int i=A.length/2;i>=0;i--)
    	{
    		siftdown(A,i,A.length);
    	}
    }
    
}

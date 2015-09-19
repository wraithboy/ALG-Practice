package LeetCodeQuestions;

//Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
//Given [3,2,1,5,6,4] and k = 2, return 5.
//You may assume k is always valid, 1 <= k <= array's length.
public class KthLargestElementinArray {
	
	
	public static void main(String args[]){
		
		
		int[] array={5,4,10,7,3,8};
		
		System.out.println(findKthLargest(array,5));
		
	}
	
    public static int findKthLargest(int[] nums, int k) {
        
    	return findKth(nums,k,0,nums.length-1);
    }
    
    public static int findKth(int nums[], int k, int low , int high)
    {
    	int i=partition(nums,low,high);
    	
    	int rlt=-1;
    	
    	if(k==i)
    	{
    		rlt=nums[k];
    	}
    	else if (k<i)
    	{
    		rlt=findKth(nums,k,low,i-1);
    	}
    	else
    	{
    		rlt=findKth(nums,k,i+1,high);
    	}
    	//System.out.println(rlt);
    	return rlt;
    }
    
    
    public static int partition(int[] nums,int low,int high)
    {
    	int i=low+1;
    	int j=high;
    	//System.out.println("i"+i+"j"+j);
    	while(true)
    	{
    		while(nums[i]>nums[low])
    		{
    			if(i==high)
    				break;
    			i++;
    		}
    		
    		while(nums[j]<nums[low])
    		{
    			if(j==low)
    				break;
    			j--;
    		}
    		
    		if(i>=j)
    			break;
    		
    		int tmp=nums[i];
    		nums[i]=nums[j];
    		nums[j]=tmp;
    	}
    	
    	int t=nums[j];
    	
    	nums[j]=nums[low];
    	
    	nums[low]=t;
    	
    	return j;
    }
    
}

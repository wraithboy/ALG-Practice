package array;
/**
 * @author h.dong
Given an array nums of integers and an int k, partition the array (i.e move the
elements in "nums") such that:
All elements < k are moved to the left
All elements >= k are moved to the right
Return the partitioning index, i.e the first index i nums[i] >= k.
Notice
You should do really partition in array nums instead of just counting the
numbers of integers smaller than k.
If all elements in nums are smaller than k, then return nums.length
 */
public class PartitionArray {
	
	public static void main(String args[])
	{
		
	}
	
	public int partitionArray(int[] nums, int k)
	{
        // write your code here
        
        if(nums==null || nums.length==0)
        return 0;
        
        int i=0;
        int j=nums.length-1;
        
        while(i<j)
        {
            
            while(i<j && nums[i]<k)
            {
                    i++;
            }

            while(j>i && nums[j]>=k)
            {
                    j--;
            }
        
            if(i<j)
            {
                int tmp=nums[i];
                nums[i]=nums[j];
                nums[j]=tmp;
            }
        }
        
        if(i==nums.length-1)
        return nums.length;
        else
        return i;
	}
}

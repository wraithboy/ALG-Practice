package array;

/*

Given an integer array, find a subarray with sum closest to zero. Return the
indexes of the first number and last number.
Example
Given [-3, 1, 1, -3, 5] , return [0, 2], [1, 3], [1, 1], [2, 2]
or [0, 4] .

*/

public class SubarraySumClosest {

    /*
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number and the index of the last number
     */
    public int[] subarraySumClosest(int[] nums) {
        // write your code here

        int[] indexes;

        int[] dp=new int[nums.length];

        int[] start=new int[nums.length];

        int sum=nums[0];

        int max=nums[0];

        for(int i=1;i<nums.length;i++)
        {
            sum=Math.min(nums[i],Math.abs(sum+nums[i]));
        }

        if(Math.abs(max)>Math.abs(sum))
        {
            max=sum;
        }
        
        
		return start;

    }
}

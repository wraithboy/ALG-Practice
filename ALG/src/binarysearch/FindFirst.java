package binarysearch;

public class FindFirst {

    public static void main(String args[])
    {
        int[] nums = {5,7,7,8,8,10};

        System.out.println(find(nums,7));
    }

    public static int find(int[] nums,int target)
    {
        int left=0,right=nums.length;

        while(left<right)
        {
            int mid = left + (right-left)/2;

            if(nums[mid]==target)
                return mid;

            if(nums[mid]>target)
            {
                right=mid;
            }
            else
            {
                left=mid+1;
            }
        }

        return left;
    }

    public static int findFirst(int[] nums,int target)
    {
        int left=0,right=nums.length;

        while(left<right)
        {
            int mid = left + (right-left)/2;

            if(nums[mid]>=target)
            {
                right=mid;
            }
            else
            {
                left=mid+1;
            }
        }

        return left;
    }

}

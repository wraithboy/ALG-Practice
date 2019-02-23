package search;

public class SearchRange {

    public int[] searchRange(int[] nums, int target) {

        if(nums==null || nums.length==0)
            return new int[]{-1,-1};

        int start=searchFirst(nums,  target);
        int end=searchLast( nums, target);

        return new int[]{start,end};
    }

    public int searchFirst(int[] nums,int target){

        int first=-1;

        int start=0; int end=nums.length-1;

        int mid;

        while(start+1<end)
        {
            mid = start+ (end - start)/2;

            if(nums[mid]==target)
            {
                end=mid;
            }
            else if (nums[mid]>target)
            {
                start=mid;
            }
            else
            {
                end=mid;
            }
        }

        if(nums[end]==target)
        {
            first=end;
        }

        if(nums[start]==target)
        {
            first=start;
        }

        return first;
    }

    public int searchLast(int[] nums,int target){
        int first=-1;

        int start=0; int end=nums.length-1;

        int mid;

        while(start+1<end)
        {
            mid = start+ (end - start)/2;

            if(nums[mid]==target)
            {
                start=mid;
            }
            else if (nums[mid]>target)
            {
                start=mid;
            }
            else
            {
                end=mid;
            }
        }

        if(nums[start]==target)
        {
            first=start;
        }

        if(nums[end]==target)
        {
            first=end;
        }

        return first;
    }
}

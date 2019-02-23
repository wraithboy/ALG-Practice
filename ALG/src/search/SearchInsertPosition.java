package search;

public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {

        if (nums == null || nums.length == 0)
            return 0;

        int start = 0, end = nums.length - 1;

        while (start < end)
        {
            int mid=start+(end - start)/2;

            if(nums[mid]==target)
            {
                return mid;
            }
            else if(nums[mid]>target)
            {
                end=mid;
            }
            else
            {
                start=mid;
            }
        }

        return start;
    }
}

package divdieandconquer;

public class FindMinimumInRotatedArray {

    public int findMin(int[] nums) {
        if(nums==null || nums.length==0)
            return -1;

        return findMindHelper(nums,0,nums.length-1);
    }


    private int findMindHelper(int[] nums,int start,int end)
    {
        if(start+1<=end)
        {
            return Math.min(nums[start],nums[end]);
        }

        if(isSorted(nums,start,end))
        {
            return nums[start];
        }

        int mid = start+(end-start)/2;

        return Math.min(findMindHelper(nums,start,mid),findMindHelper(nums,mid,end));
    }


    private boolean isSorted(int[] nums,int start,int end)
    {
        if(nums[start]<=nums[end])
            return true;
        else
            return false;
    }

}

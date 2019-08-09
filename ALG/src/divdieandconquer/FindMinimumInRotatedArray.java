package divdieandconquer;

public class FindMinimumInRotatedArray {


    public static void main(String args[])
    {

        FindMinimumInRotatedArray f = new FindMinimumInRotatedArray();

        int[] a= {3,4,5,1,2};

        System.out.println(f.findMin(a));
    }

    public int findMin(int[] nums) {
        if(nums==null || nums.length==0)
            return -1;

        return findMindHelper(nums,0,nums.length-1);
    }


    private int findMindHelper(int[] nums,int start,int end)
    {
        if(start+1>=end)
        {
            return Math.min(nums[start],nums[end]);
        }

        if(nums[start]<=nums[end])
            return nums[start];

        int mid = start+(end-start)/2;

        System.out.println("mid:"+mid);

        if(nums[start]<=nums[mid])
        {
            return Math.min(nums[start],findMindHelper(nums,mid+1,end));
        }
        else
        {
            return Math.min(nums[mid],findMindHelper(nums,start,mid));
        }
    }

}

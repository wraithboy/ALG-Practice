package array;

public class MoveZeroes {


    public void moveZeroes(int[] nums)
    {
        int numsOfNonZeroes=0;

        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]!=0)
            {
                swap(nums,i,numsOfNonZeroes);
                numsOfNonZeroes++;
            }
        }
    }

    public void moveZeroes3(int[] nums) {

        if(nums==null || nums.length==0)
            return;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]!=0)
                continue;

            int j=i+1;

            while(nums[j]==0 && j<nums.length)
            {
                j++;
            }

            if(j>nums.length)
                break;

            swap(nums,i,j);
        }


    }



    public void moveZeroes1(int[] nums) {

        if(nums==null || nums.length==0)
            return;

        int i=0,j=nums.length-1;

        for(;i<j;i++)
        {
            if(nums[i]!=0)
                continue;

            while (nums[j]==0&&j>i)
                j--;

            if(i>j)
                break;

            swap(nums,i,j);
            j--;
        }

    }

    private void swap(int[] nums,int i,int j)
    {
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
}

package sort;

public class FirstMissingPositive {


    public static void main(String args[])
    {
        int[] a={3,4,-1,1};

        System.out.println(firstMissingPositive(a));
    }

    public static int firstMissingPositive(int[] nums) {

        int n = nums.length;

        for(int i=0;i<n;i++)
        {
            while(nums[i]>0 && nums[i]<=n && nums[nums[i]-1]!=nums[i])
            {
                int tmp=nums[nums[i]-1];
                nums[nums[i]-1]=nums[i];
                nums[i]=tmp;
            }
        }

        for(int i=0;i<n;i++)
        {
            if(nums[i]!=i+1)
            {
                return i+1;
            }
        }

        return n+1;
    }
}

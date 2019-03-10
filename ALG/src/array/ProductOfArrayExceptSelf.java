package array;

public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {

        int[] result = new int[nums.length];

        int tmp=1;

        for(int i=0;i<nums.length;i++)
        {
            result[i]=tmp;
            tmp=tmp*nums[i];
        }

        tmp=1;
        for(int i=nums.length-1;i>=0;i--)
        {
            result[i]=result[i]*tmp;
            tmp=tmp*nums[i];
        }

        return result;
    }
}

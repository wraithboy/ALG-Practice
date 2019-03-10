package array;

import java.util.Arrays;

public class NextPermutation {

    public void nextPermutation(int[] nums) {

        if(nums==null || nums.length==0 || nums.length==1)
            return;

        int replace;

        for(replace=nums.length-2;replace>=0;replace--)
        {
            if(nums[replace]<nums[replace+1])
                break;
        }

        if(replace<0)
        {
            reverse(nums,0);
            return;
        }

        int swap=nums.length-1;

        while(swap>replace)
        {
            if(nums[swap]<=nums[replace])
                swap--;
            else
                break;
        }

        swap(nums,replace,swap);

        reverse(nums,replace+1);

    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

package array;

import java.util.Arrays;

public class NextPermutation {

    public void nextPermutation1(int[] nums) {

        /*
        下一个字典序数的找法：
        找到第一个nums[i]<nums[i+1]的位置，i是需要改动的地方;
        然后把i+1到尾部的数reverse.(这些数必然是逆序的)
        从i+1开始找到第一个大于nums[i]的数，交换两数的位置.
        */

        int i=nums.length-2;

        while(i>=0&&nums[i]>=nums[i+1])
        {
            i--;
        }

        int j=i+1;
        int k=nums.length-1;

        while(j<k)
        {
            swap(nums,j,k);
            j++;
            k--;
        }

        if(i==-1)
        {
            return;
        }

        for(j=i+1;j<nums.length;j++)
        {
            if(nums[i]<nums[j])
            {
                swap(nums,i,j);
                break;
            }
        }

    }





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

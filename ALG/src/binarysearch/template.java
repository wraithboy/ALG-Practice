package binarysearch;

public class template {


    public static void main(String args[])
    {



    }

    public static lower_bound(int[] nums,int val,int left,int right)
    {

        while(left<right)
        {
            int mid=left+(right-left)/2;

            if(nums[mid]>=val)
            {
                right=mid;
            }
            else
            {
                left=mid+1;
            }
        }

    }

}

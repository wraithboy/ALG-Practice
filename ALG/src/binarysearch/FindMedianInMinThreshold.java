package binarysearch;

public class FindMedianInMinThreshold {

    public static void main(String args[])
    {
        int[] a= {2,4, 6, 9, 12, 15};

        System.out.println(findMedian(a,4));
    }



    public static double findMedian(int[] arr,int min)
    {

        int l=0,r=arr.length;

        while(l<r)
        {
            int mid=l+(r-l)/2;

            if(arr[mid]>=min)
            {
                r=mid;
            }
            else
            {
                l=mid+1;
            }
        }


        if((arr.length-l)%2==0)
        {
            return arr[l+(arr.length-l)/2]/2.0+arr[l+(arr.length-l)/2-1]/2.0;
        }
        else
        {
            return arr[l+(arr.length-l)/2];
        }

    }

}

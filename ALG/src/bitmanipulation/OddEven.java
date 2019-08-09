package bitmanipulation;

public class OddEven {

    public static void main(String args[]) {

        int[] a = {1,3,5,9,11,6,4,4,2};

        System.out.println(findEven(a));
        
    }

    public static int findEven(int[] arr)
    {

        int left=0,right=arr.length;

        while(left<right)
        {
            int mid = left + (right-left)/2;

            if(arr[mid]%2==0)
            {
                right=mid;
            }
            else {
                left=mid+1;
            }
        }

        return arr[left];

    }
}

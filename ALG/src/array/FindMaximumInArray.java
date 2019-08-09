package array;

public class FindMaximumInArray {

    //

    public static void main(String args[])
    {
        int arr[] = {8, 10, 20, 80, 100, 200, 400, 500, 3, 2, 1};
        //int arr[] = {9, 6};
        FindMaximumInArray fm = new FindMaximumInArray();

        System.out.println(fm.findMaximum(arr,0,arr.length-1));

    }

    public int findMaximum(int arr[], int low, int high) {

        while(low<high-1)
        {
            int mid = low + (high-low)/2;
            if(arr[mid]>arr[mid+1])
            {
                high=mid;
            }
            else {
                low = mid+1;
            }
        }

        return Math.max(arr[low],arr[high]);
    }
}
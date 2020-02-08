package TMCQuestions;

import java.util.HashMap;

public class CountPairWithGIvenSum {

    public static void main(String args[])
    {
        int[] arr={1,1,1,1};

        int sum=2;

        System.out.println(countPairWithSum(arr,sum));
    }

    public static int countPairWithSum(int[] arr,int sum)
    {
        if(arr==null || arr.length<2)
            return 0;

        HashMap<Integer,Integer> map = new HashMap<>();

        int count=0;

        for(int i=0;i<arr.length;i++)
        {

            if(map.containsKey(sum-arr[i]))
            {
                count=count+map.get(sum-arr[i]);
            }

            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }

        return count;
    }

}

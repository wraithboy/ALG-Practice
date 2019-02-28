package prefixsum;

import java.util.Hashtable;

public class SubArraySumEqualsK {


    public static void main(String args[])
    {
        int[] a = {1,1,1};

        System.out.println(subarraySum(a,2));
    }

    public  static int subarraySum(int[] nums, int k) {

        int prefixSum=0;

        int ans=0;

        Hashtable<Integer,Integer> map = new Hashtable<>();

        map.put(0,1);

        for(int i=0;i<nums.length;i++)
        {

            prefixSum=prefixSum+nums[i];

            if(map.containsKey(prefixSum-k))
            {
                ans=ans+map.get(prefixSum-k);
            }

            map.put(prefixSum,map.getOrDefault(prefixSum,0)+1);
        }

        return ans;
    }
}

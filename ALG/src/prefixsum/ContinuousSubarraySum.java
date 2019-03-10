package prefixsum;

import java.util.HashMap;

public class ContinuousSubarraySum {

    public boolean checkSubarraySum(int[] nums, int k) {

        int[] prefixsum=new int[nums.length+1];

        prefixsum[0]=0;

        for(int i=0;i<nums.length;i++)
        {
            prefixsum[i+1]=prefixsum[i]+nums[i];
        }

        HashMap<Integer,Integer> map = new HashMap<>();

        map.put(0,1);

        for(int i=1;i<prefixsum.length;i++)
        {

            if(k!=0)
                prefixsum[i]=prefixsum[i]%k;
            if(map.containsKey(prefixsum[i]))
            {
                if(map.get(prefixsum[i])-i>1)
                return true;
            }

            map.put(prefixsum[i]%k,i);
        }

        return false;
    }
}

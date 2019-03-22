package sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {

        List<Integer> result = new ArrayList<>();

        if(nums==null || nums.length==0)
            return result;

        HashMap<Integer,Integer> frequencyMap=new HashMap<>();

        int maxFrenquency=0;

        for(int n:nums)
        {
            frequencyMap.put(n, frequencyMap.getOrDefault(n,0)+1);
            maxFrenquency=Math.max(maxFrenquency,frequencyMap.get(n));
        }

        List<Integer>[] buckets=new List[maxFrenquency+1];

        for(int n:frequencyMap.keySet())
        {
            int freq=frequencyMap.get(n);
            if(buckets[freq]==null)
            {
                buckets[freq]=new ArrayList<Integer>();
            }
            buckets[freq].add(n);
        }

        for(int i=maxFrenquency;i>=0&&result.size()<k;i--)
        {
            if(buckets[i]!=null)
                result.addAll(buckets[i]);
        }

        return result;
    }
}

package permutationandcombination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermuationsII {

    public List<List<Integer>> permuteUnique(int[] nums) {

        if(nums==null)
        {
            return null;
        }

        if(nums.length==0)
        {
            return new ArrayList<List<Integer>>(null);
        }

        ArrayList<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        DFS(new ArrayList<Integer>(),nums.length,used,nums,result);
        return result;

    }


    public void DFS(List<Integer> curr,int length,boolean[] used,int[] nums,List<List<Integer>> result)
    {
        if(curr.size()==length)
        {
            result.add(new ArrayList<Integer>(curr));
            return;
        }

        for(int i=0;i<nums.length;i++)
        {
            if(used[i] || i!=0 && nums[i]==nums[i-1] &&used[i-1])
                continue;
            curr.add(nums[i]);
            used[i]=true;
            DFS(curr,length,used,nums,result);
            curr.remove(curr.size()-1);
            used[i]=false;
        }
    }
}

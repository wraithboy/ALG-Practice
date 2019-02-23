package permutationandcombination;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {

        if(nums==null)
        {
            return null;
        }

        ArrayList<List<Integer>> result = new ArrayList<>();

        if(nums.length==0)
        {
            result.add(null);
            return result;
        }

        DFS(new ArrayList<Integer>(),0,nums,result);

        return result;
    }


    public void DFS(List<Integer> curr, int start, int[] nums,List<List<Integer>> result)
    {
        result.add(new ArrayList<Integer>(curr));

        for(int i=start;i<nums.length;i++)
        {
            curr.add(nums[i]);
            DFS(curr,i+1,nums,result);
            curr.remove(curr.size()-1);
        }

    }





}

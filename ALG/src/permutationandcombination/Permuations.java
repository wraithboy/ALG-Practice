package permutationandcombination;

import java.util.ArrayList;
import java.util.List;

public class Permuations {

    public List<List<Integer>> permute(int[] nums) {

        if(nums==null)
            return null;

        if(nums.length==0)
        {
            return new ArrayList<List<Integer>>(null);
        }

        ArrayList<List<Integer>> result = new ArrayList<>();
        boolean[] used=new boolean[nums.length];

        DFS(new ArrayList<Integer>(),nums.length,nums,result,used);

        return result;
    }

    public void DFS(List<Integer> curr,int length, int[] nums, List<List<Integer>> result,boolean[] used)
    {
        if(curr.size()==length)
        result.add(new ArrayList<>(curr));

        for(int i=0;i<nums.length;i++)
        {
            if(used[i])
                continue;
            used[i]=true;
            curr.add(nums[i]);
            DFS(curr,length,nums,result,used);
            curr.remove(curr.size()-1);
            used[i]=false;
        }
    }

}

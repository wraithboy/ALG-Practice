package BitManipulation;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {

        if(nums==null)
            return null;

        if(nums.length==0)
            return new ArrayList<List<Integer>>(null);

        ArrayList<List<Integer>> result = new ArrayList<>();

        for(int i=0;i<1<<nums.length;i++)
        {
            ArrayList<Integer> curr= new ArrayList<>();

            for(int j=0;j<nums.length;j++)
            {
                if((i&(1<<j))!=0)
                    curr.add(nums[j]);
            }

            result.add(new ArrayList<>(curr));
        }

        return result;
    }


    public static void main(String args[])
    {
        System.out.println(8>>2);
    }
}

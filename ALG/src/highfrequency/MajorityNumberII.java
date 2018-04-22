package highfrequency;

import java.util.List;

public class MajorityNumberII {

    public int majorityNumber(List<Integer> nums) {
        // write your code here

        int top1=0; int top2=0;
        int count1=0; int count2=0;

        for(int i=0;i<nums.size();i++)
        {

            if(top1==nums.get(0))
            {
                count1++;
            }
            else if(top2==nums.get(0))
            {
                count2++;
            }
            else if(count1==0){
                top1=nums.get(0);
                count1=1;
            }
            else if(count2==0){
                top2=nums.get(0);
                count2=1;
            }
            else
            {
                count1--;
                count2--;
            }

        }

        count1=0;count2=0;

        for(int j : nums)
        {
            if(top1==j)
                count1++;
            else if ( top2==j)
                count2++;
        }

        return count1>count2?top1:top2;
    }
}

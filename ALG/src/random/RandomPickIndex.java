package random;

import java.util.Random;

public class RandomPickIndex {
    int[] nums;
    Random random;

        public void Solution(int[] nums) {
            this.nums=nums;
            random=new Random();
        }

        public int pick(int target) {
            int pick=0;
            int count=0;
            for(int i=0;i<nums.length;i++)
            {
                if(nums[i]!=target)
                    continue;

                if(random.nextInt(++count)==0)
                {
                    pick=i;
                }
            }

            return pick;
        }
}

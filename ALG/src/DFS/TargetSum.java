package DFS;

import java.util.Arrays;

public class TargetSum {

    public int findTargetSumWays(int[] nums, int S) {

        if(nums==null || nums.length==0)
            return 0;

        int sum=0;

        for(int i:nums)
        {
            sum+=i;
        }

        if(S>sum)
            return 0;

        int[] result = new int[1];
        result[0]=0;

        int[][] map =new int[nums.length][2001];

        for(int i=0;i<map.length;i++)
        {
            Arrays.fill(map[i],-1);
        }

        return DFS(0,nums,S,map);
    }

    public int DFS(int curr,int[] nums,int S,int[][] map)
    {
        if(curr==nums.length)
        {
            if(S==0)
                return 1;
            else return 0;
        }

        if(map[curr][S+1000]<0) {
            int left=DFS(curr + 1, nums, S - nums[curr],map);
            int right=DFS(curr + 1, nums, S + nums[curr],map);
            map[curr][S+1000]=left+right;
        }

        return map[curr][S+1000];
    }
}

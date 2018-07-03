package twopointer;

public class TrappingRainWater {

    public int trapRainWater(int[] heights) {
        // write your code here
        if(heights==null && heights.length<3)
        {
            return 0;
        }

        int leftmax=0;
        int rightmax=0;
        int water=0;
        int left=0;
        int right=heights.length-1;

        while(left<right)
        {
            leftmax=Math.max(heights[left],leftmax);
            rightmax=Math.max(heights[right],rightmax);

            if(leftmax<rightmax)
            {
                water=water + leftmax-heights[left];
                left++;
            }
            else
            {
                water=water + rightmax-heights[right];
                right--;
            }
        }

        return water;

    }
}

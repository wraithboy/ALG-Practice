package twopointer;

public class ContainerWithMostWater {
    
	public int maxArea(int[] heights) {
		// write your code here
		if(heights==null || heights.length==0)
		{
			return 0;
		}
		
		int l=0;
		int r=heights.length-1;
		int max=0;
		
		while(l<r)
		{
			int area=Math.min(heights[r], heights[l])*(r-l);
			
			max=Math.max(max, area);
			
			if(heights[l]<heights[r])
			{
				l++;
			}
			else
			{
				r--;
			}
			
		}

		return 0;
		
    }
}

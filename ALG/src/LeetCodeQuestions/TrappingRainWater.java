package LeetCodeQuestions;

public class TrappingRainWater {
	
	public static void main(String args[])
	{
		
		
	}
	
	public int trap(int[] height) {
	        
	        if(height==null || height.length==0)
	        {
	            return 0;
	        }
	        
	        int[] left=new int[height.length];
	        
	        int[] right=new int[height.length];
	        
	        int max=height[0];
	        
	        for(int i=0;i<height.length;i++)
	        {
	        	if(height[i]>max)
	        	{
	        		max=height[i];
	        	}
	        	
	        	left[i]=max;	        	
	        }
	        
	        max=height[height.length-1];
	        for(int i=height.length-1;i>=0;i--)
	        {
	        	if(height[i]>max)
	        	{
	        		max=height[i];
	        	}
	      
	        	right[i]=max;
	        }
	        
	        int sum=0,h=0;
	        for(int i=0;i<height.length;i++)
	        {
	        	if(left[i]>right[i])
	        	{
	        		h=right[i]-height[i];
	        		if(h>0)
	        		sum=sum+h;
	        	}
	        	else
	        	{
	        		h=left[i]=height[i];
	        		if(h>0)
	        		sum=sum+h;
	        	}
	        }
	        
	        return sum;
	        
	}
	
}

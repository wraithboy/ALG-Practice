package highfrequency;

import java.util.Arrays;

public class ThreeSumCloset {
	
	public static void main(String args[])
	{
		int[] a = {-2,-3,-4,-5,-100,99,1,4,4,4,5,1,0,-1,2,3,4,5};
		System.out.println(threeSumClosest(a,77));
	}

    public static int threeSumClosest(int[] numbers, int target) {
        // write your code here
    	if(numbers==null || numbers.length<3)
    		return -1;
    	
    	Arrays.sort(numbers);
    	
    	int i;
    	int left;
    	int right;
    	
    	int result=numbers[0]+numbers[1]+numbers[2];
    	int max = 0;
    	
    	for(i=0;i<numbers.length-2;i++)
    	{
    		left=i+1;
    		right=numbers.length-1;
    		while(left<right)
    		{
        		max=numbers[i]+numbers[left]+numbers[right];

        		if(max==target)
        		{
        			return max;
        		}
        		else if(max>target)
        		{
        			right--;
        		}
        		else
        		{
        		    left++;
        		}
        		
        		if(Math.abs(target-result)> Math.abs(target-max))
    			result=max;
    		}

    	}
    	return result;
    	
    }
}

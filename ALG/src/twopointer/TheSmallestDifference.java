package twopointer;

import java.util.Arrays;
import java.util.Collections;

public class TheSmallestDifference {
	
    public int smallestDifference(int[] A, int[] B) {
        // write your code here
    	
    	Arrays.sort(A);
    	Arrays.sort(B);
    	
    	
    	int i=0;
    	int j=0;
    	int min=Integer.MAX_VALUE;
    	
    	
    	while(i<A.length && j<B.length)
    	{
			int diff;
    		if(A[i]<B[j])
    		{
    			diff=B[j]-A[i];
    			i++;
    		}
    		else
    		{
    			diff=A[i]-B[j];
    			j++;
    		}
			min=Math.min(min, diff);
    	}
    	
    	return min;
    	
    }
}

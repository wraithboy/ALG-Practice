package twopointer;

import java.util.Arrays;

public class TriangleCount {
	
    public int triangleCount(int[] S) {
    	
    	if(S==null || S.length==0)
    		return 0;
    	
    	int count=0;
    	
    	Arrays.sort(S);
    	
    	for(int i=0;i<S.length;i++)
    	{
    		int j=i+1;
    		int k=S.length-1;
    		
    		while(j<k)
    		{
    			if(S[j]+S[i]>S[k])
    			{
    				count=count+k-j;
    				k--;
    			}
    			else
    			{
    				j++;
    			}
    		}
    		
    	}
		return count;
        // write your code here
    }
}

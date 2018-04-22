package highfrequency;

import java.util.List;

public class MajorityNumber {

    public int majorityNumber(List<Integer> nums) {
        // write your code here
    	
    	if(nums==null || nums.size()==0 )
    		return 0;
    	
    	int m=nums.get(0);
    	
    	int count=0;
    	
    	for(int i=0;i<nums.size();i++)
    	{
    		
    		if(count==0)
    		{
    			m=nums.get(i);
    			count=1;
    		}
    		else if(m==nums.get(i))
    		{
    			count=count+1;
    		}
    		else
    		{
    			count=count-1;
    		}
    		
    	}
    	
    	return m;
    }
}

package implementation;

import java.util.HashMap;

public class TwoSum {
	
	    public static int[] twoSumBrute(int[] numbers, int target) {	       
	            int[] result=new int[2];
	            
	            for(int i=0;i<numbers.length;i++)
	            {
	                for(int j=i+1;j<numbers.length;j++)
	                {
	                    if(numbers[i]+numbers[j]==target)
	                    {
	                        result[0]=i;
	                        result[1]=j;
	                        return result;
	                    }
	                }
	            }
	            
	            return result;
	        }
	
	    
	    public static int[] twoSum(int[] numbers, int target) {
	        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
	        int[] result= new int[2];
	        
	        map.put(target-numbers[0],0);
	        
	        for (int i=1;i<numbers.length;i++)
	        {
	            if(map.containsKey(numbers[i]))
	            {
	                result[0]=map.get(numbers[i])+1;
	                result[1]=i+1;
	                return result;
	            }
	            else
	            {
	                map.put(target-numbers[i],i);
	            }
	            
	        }
	        
	        return null;
	     }
	    
	    public static void main(String[] args)
	    {
	    	int[] numbers={2,7,11,15};
	    	
	    	int[] A=twoSum(numbers,9);
	    	
	    	System.out.println(A[0]+" "+A[1]);
	    	
	    }
}

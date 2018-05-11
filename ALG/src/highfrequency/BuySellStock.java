package highfrequency;

public class BuySellStock {
	
    public int maxProfit(int[] prices) {
        // write your code here
    	
        if(prices==null || prices.length==0)
        return 0;
        
            	int max=Integer.MIN_VALUE;
    	int min=prices[0];
    	for(int i=1;i<prices.length;i++)
    	{
    	    
    	    if(prices[i]<min)
    			min=prices[i];
    	    
    		int profit=prices[i]-min;
    		
    		if(profit>max)
    			max=profit;
    		

    	}
    	
    	return max;
    }
	
}

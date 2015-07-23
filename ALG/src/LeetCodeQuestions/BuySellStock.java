package LeetCodeQuestions;

//
//Say you have an array for which the ith element is the price of a given stock on day i.
//
//If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

public class BuySellStock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	
	   public int maxProfit1(int[] prices) {
	       
		   int max=0;
		   
		   int min=Integer.MAX_VALUE;
		   
		   for(int i=0;i<prices.length;i++)
		   {
			   if(prices[i]<min)
				   min=prices[i];
			   
			   if(max<prices[i]-min)
				   max=prices[i]-min;
			   
		   }
		   
		   return max;
		  
	    }
	
    public int maxProfit2(int[] prices) {
        
    	int max=prices[1]-prices[0];
    	
    	int min=prices[0];
    	
    	for(int i=1;i<prices.length;i++)
    	{
    		if(prices[i]<min)
    		{
    			min=prices[i];
    		}
    		else
    		{

    		}
    	}
    	
    	return max;
    }
	
}

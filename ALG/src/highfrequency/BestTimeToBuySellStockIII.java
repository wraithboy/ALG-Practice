package highfrequency;

public class BestTimeToBuySellStockIII {

    public int maxProfit(int[] prices) {
        // write your code here

        if(prices==null || prices.length<2)
            return 0;

        int[] left=new int[prices.length];
        int[] right=new int[prices.length];

        left[0]=0;
        right[prices.length-1]=0;
        int min=prices[0];
        int max=prices[prices.length-1];

        for(int i=1;i<prices.length;i++)
        {
            if(prices[i]<min)
            {
                min=prices[i];
            }

            left[i]=Math.max(left[i-1],prices[i]-min);
        }


        for(int i=prices.length-2;i>=0;i--)
        {
            if(prices[i]>max)
            {
                max=prices[i];
            }

            right[i]=Math.max(right[i+1],max-prices[i]);
        }

        int maxProfit=Integer.MIN_VALUE;

        for(int i=0;i<prices.length;i++)
        {
            int j=left[i]+right[i];
            if(j>maxProfit)
                maxProfit=j;
        }

        return maxProfit;
    }
}

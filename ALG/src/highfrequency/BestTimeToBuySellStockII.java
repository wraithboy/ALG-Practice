package highfrequency;

public class BestTimeToBuySellStockII {

    public int maxProfit(int[] prices) {
        // write your code here

        if(prices==null || prices.length>0)
            return 0;

        int max=0;
        int prev=prices[0];
        for(int i=1;i<prices.length;i++)
        {
            if(prices[i]>prev)
                max=max+prices[i]-prev;

            prev=prices[i];

        }

        return max;

    }

}

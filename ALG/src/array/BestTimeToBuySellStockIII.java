package array;

public class BestTimeToBuySellStockIII {

    public int maxProfit(int[] prices) {

        if(prices==null || prices.length==0)
            return 0;

        int result=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;

        for(int i=0;i<prices.length;i++)
        {
            if(prices[i]<min)
                min=prices[i];

            int profit=prices[i]-min + max(prices,i+1);

            if(profit>result)
                result=profit;
        }

        return result;

    }

    public int max(int[] prices,int start)
    {
        int min=Integer.MAX_VALUE;
        int result=Integer.MIN_VALUE;

        for(int i=start;i<prices.length;i++){

            if(prices[i]<min)
                min=prices[i];

            int profit=prices[i]-min;

            if(profit>result)
                result=profit;

        }

        return result;
    }

    public int maxProfit1(int[] prices) {

        if(prices==null || prices.length<2)
            return 0;

        int maxprofit=0;

        int[] f=new int[prices.length];

        f[0]=0;

        int min=prices[0];

        for(int i=1;i<prices.length;i++)
        {
            f[i]=Math.max(f[i-1],prices[i]-min);
            if(prices[i]<min)
                min=prices[i];
        }


        int[] g=new int[prices.length];

        g[prices.length-1]=0;

        int max=prices[prices.length-1];

        for(int i=prices.length-2;i>=0;i--)
        {
            g[i]=Math.max(g[i+1],max-prices[i]);
            maxprofit=Math.max(maxprofit,g[i]+f[i]);
            if(max<prices[i])
                max=prices[i];
        }

        return maxprofit;

    }


}

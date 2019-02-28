package greedy;

public class BuySellStockII {

    public int maxProfit(int[] prices) {

        if(prices==null || prices.length<=1)
        {
            return 0;
        }

        int[] aux=new int[prices.length+1];

        aux[0]=0;

        for(int i=0;i<prices.length;i++)
        {
            aux[i+1]=prices[i+1]-prices[i];
        }

        int profit=0;

        for(int i=0;i<aux.length;i++)
        {
            if(aux[i]>0)
            profit=profit+aux[i];
        }

        return profit;

    }
}

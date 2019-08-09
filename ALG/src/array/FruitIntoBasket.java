package array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class FruitIntoBasket {

    public int totalFruit(int[] tree) {

        int total=0;

        if(tree==null || tree.length==0)
            return total;

        HashMap<Integer,Integer> map = new HashMap<>();

        int left=0;

        for(int i=0;i<tree.length;i++)
        {
            map.put(tree[i],map.getOrDefault(tree[i],0)+1);

            if(map.size()>2)
            {
                while(map.size()>2 && left<i)
                {
                    if(map.get(tree[left])>1)
                    {
                        map.put(tree[left],map.get(tree[left])-1);
                    }
                    else
                    {
                        map.remove(tree[left]);
                    }

                    left++;
                }
            }

            total=Math.max(total,i-left+1);
        }

        return total;
    }
}

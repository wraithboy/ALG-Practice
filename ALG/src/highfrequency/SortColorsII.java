package highfrequency;

import java.util.ArrayList;
import java.util.HashMap;

public class SortColorsII {	
	
	
	public static void main(String args[])
	{
		
		int[] a = {2,1,1,2,2};
		
		sortColors2(a,2);
		
		for(int i: a)
		{
			System.out.println(i);
		}
		
	}
	
    public static void sortColors2(int[] colors, int k) {
        // write your code here
    	//Given colors=[3, 2, 2, 1, 4], k=4, your code should sort colors in-place to [1, 2, 2, 3, 4].

    	HashMap<Integer,Integer> map = new HashMap<>();
    	
    	for(int i=0;i<colors.length;i++)
    	{
    		if(!map.containsKey(colors[i]))
    		{
    			map.put(colors[i],1);
    		}
    		else
    		{
    			int count=map.get(colors[i]);
    			count++;
    			map.put(colors[i], count);
    		}
    	}
    	
    	for(int i: map.keySet())
    	{

    			System.out.println(map.get(i));

    	}
    	
    	int j=0;
    	
    	for(int i=1;i<=k;i++)
    	{
    		int count=0;
    		if(map.containsKey(i))
    		count=map.get(i);
    		while(count>0)
    		{
    			colors[j]=i;
    			count--;
    			j++;
    		}
    	}
    	
    }

}

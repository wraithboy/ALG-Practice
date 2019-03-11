package implementation;

import java.util.Arrays;

public class TheCakeThief {
	
	public static void main(String args[])
	{
		  CakeType[] cakeTypes = new CakeType[]{
				    new CakeType(7, 160),
				    new CakeType(3, 90),
				    new CakeType(2, 15),
				};
		  
		  
		  System.out.println(maxDuffelBagValue(cakeTypes,20));  
	}
	
	public static int maxDuffelBagValue(CakeType[] cakeTypes,int capacity)
	{
		
		
		if(capacity==0)
			return 0;
		
		int[] solution=new int[cakeTypes.length];
		int[] mySolution=new int[cakeTypes.length];
		
		for(int i=0;i<cakeTypes.length;i++)
		{
			if(capacity>=cakeTypes[i].weight)
			solution[i]=maxDuffelBagValue(cakeTypes,capacity-cakeTypes[i].weight);
			else
			solution[i]=0;
			
		}
		
		for(int i=0;i<cakeTypes.length;i++)
		{
			mySolution[i]=solution[i]+cakeTypes[i].value;
		}
		
		
		Arrays.sort(mySolution);
		
		return mySolution[mySolution.length-1];
		
	}
	
	
	static class CakeType {

	    int weight;
	    int value;

	    public CakeType(int weight, int value) {
	        this.weight = weight;
	        this.value  = value;
	    }

	}
	
}
package TMCQuestions;

public class CakeThief {

	private class CakeType {

	    int weight;
	    int value;

	    public CakeType(int weight, int value) {
	        this.weight = weight;
	        this.value  = value;
	    }
	}
	 CakeType[] cakeTypes = new CakeType[]{
			    new CakeType(7, 160),
			    new CakeType(3, 90),
			    new CakeType(2, 15),
			};
	public int maxDuffelBagValue (CakeType[] cakeTypes, int capacity )	
	{
		int max=0;
		
		int[] map=new int[capacity+1];
		
		for(int i=1;i<=capacity;i++)
		{
			int m=0;
			for (CakeType t: cakeTypes)
			{
				if(t.weight<=i)
				{
					m=Math.max(m, t.value+map[i-t.weight]);
				}
			}	
			
			map[i]=m;
			
		}
		
		return map[capacity];
	}
	
	public static void main(String args[])
	{

		  
		CakeThief ck = new CakeThief();
		
		System.out.println(ck.maxDuffelBagValue(ck.cakeTypes, 20));
	}
}
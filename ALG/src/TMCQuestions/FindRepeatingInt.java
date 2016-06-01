package TMCQuestions;

public class FindRepeatingInt {
	
	public static void main(String args[])
	{
		

	}
	
	public static int findRepeat(int[] array)
	{
		
		long sum1=0L;
		
		long sum2=0L;
		
		for (int i=1;i<1000000;i++)
		{
			sum1=sum1+i;
		}
		
		for (int i=0;i<array.length;i++)
		{
			sum2=sum2+array[i];
		}
		
		int repeat=(int) (sum2-sum1);
		
		return repeat;
		
		
	}
	
}

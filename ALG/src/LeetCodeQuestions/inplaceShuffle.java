package LeetCodeQuestions;

import java.util.Random;

public class inplaceShuffle {
	
	public static void main(String args[])
	{
		int[] aa={3,25,5,6,7,23,5,2,4,7};
		
		inplaceShuffle.Shuffle(aa);
		
		for(int a: aa)
		{
			System.out.print(a+",");
		}

	}
	
	
	public static void Shuffle(int [] list)
    {
		
		Random rand = new Random();

		for(int i=list.length-1;i>=0;i--)
		{
			
			int y=rand.nextInt(i+1);
			
			int tmp=list[i];
			list[i]=list[y];
			list[y]=tmp;
			
		}	
    }
}

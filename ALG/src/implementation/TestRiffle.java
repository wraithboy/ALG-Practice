package implementation;

public class TestRiffle {
	
	
	public static void main(String args[])
	{
		String a = new String("dafad");
	}
	
	
	public static boolean testRiffle(int[] shuffledDeck, int shuffledDeckIndex,int[] half1, int half1Index, int[] half2, int half2Index)
	{
		
		if(shuffledDeckIndex==shuffledDeck.length)
		{
			return true;
		}
		
		
		if(half1Index<half1.length&& shuffledDeck[shuffledDeckIndex]==half1[half1Index])
		{
			return testRiffle(shuffledDeck, shuffledDeckIndex++,half1, half1Index++, half2,  half2Index);
		}
		else if (half2Index<half2.length&& shuffledDeck[shuffledDeckIndex]==half2[half2Index])
		{
			return testRiffle(shuffledDeck, shuffledDeckIndex++,half1, half1Index++, half2,  half2Index);
		}else
		{
			return false;
		}
		
	}



	
	
}

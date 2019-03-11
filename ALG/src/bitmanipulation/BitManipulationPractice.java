package bitmanipulation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BitManipulationPractice {
	
	public static void main(String args[])
	{
		
		int a = 254;
		
		byte b = (byte)a;
		
		System.out.println(b);
		
	}
	
	
	
	
	public int loadSequenceNumber()
	{
		int seqNumber=0;
		Scanner scanner=null;
		try {
				scanner = new Scanner(new File("sequence.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.print("Error reading sequence number from file! Set sequence number to 0.");
			return seqNumber;
		}
		
		seqNumber=scanner.nextInt();
		
		
		return seqNumber;
	}
	
}

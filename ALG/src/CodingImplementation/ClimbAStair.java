package CodingImplementation;

public class ClimbAStair {
	
	public static int count;
	
	public static void main(String args[])
	{
		
		String s="/...";
		
		String[] list = s.split("/");
		
		System.out.println(list.length);
		
		
		System.out.println(climb(4));
		
	}
	
	public static int climb(int i) 
	{
		if(i==0)
			return 1;
		if(i==1)
			return 1;
		else return climb(i-1)+climb(i-2);
		
	}
	
}

package TMCQuestions;

public class TwoString {
	
	public static void main(String args[])
	{
		String a="ababba";
		String b="aba";
		
		
		System.out.println(removeString(a,0,b,0));
	}
	
	
	public static int removeString(String a, int index1, String b,int index2)
	{
		if(a==null || b==null)
		{
			return -1;
		}
		
		if(a.length()<=b.length())
		{
			return -1;
		}
		
		if(index2==b.length())
			return 1;
		
		int totalCount=0;
		
		char tmp=b.charAt(index2);
		
		
		for(int i=index1;i<a.length();i++)
		{
			if(tmp==a.charAt(i))
				totalCount=totalCount+removeString(a,i,b,index2+1);
		}
		
		return totalCount;
	}
	
	
}

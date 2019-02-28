package CodingImplementation;


//Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
//
//For example,
//"A man, a plan, a canal: Panama" is a palindrome.
//"race a car" is not a palindrome.
//
//Note:
//Have you consider that the string might be empty? This is a good question to ask during an interview.
//
//For the purpose of this problem, we define empty string as valid palindrome.


public class ValidPalindrome {
	
	public static void main(String args[])
	{	
		System.out.println(ValidatePalindrome("ab2a"));
	}
	
	public static boolean ValidatePalindrome(String s)
	{
        boolean result = true;
		
		int start=0;
		int end=s.length()-1;
		
		while(start<=end)
		{
			if(!((s.charAt(start)>=65 && s.charAt(start)<=90) || (s.charAt(start)>=97 && s.charAt(start)<=122) || (s.charAt(start)>=48 && s.charAt(start)<=57)))
			{
				start=start+1;
				continue;
			}
			
			if(!((s.charAt(end)>=65 && s.charAt(end)<=90) || (s.charAt(end)>=97 && s.charAt(end)<=122) || (s.charAt(end)>=48 && s.charAt(end)<=57)))
			{
				end=end-1;
				continue;
			}
			
			if(Character.isDigit(s.charAt(start)) || Character.isDigit(s.charAt(end)))
			{
				if(s.charAt(start)!=s.charAt(end))
				{
				    result=false;
				    break;
				}
			}
			else if(Character.toLowerCase(s.charAt(start))!=Character.toLowerCase(s.charAt(end)))
			{
				result=false;
				break;
			}
			
			start++;
		    end--;
			
		}
		
		return result;
	}
	
}

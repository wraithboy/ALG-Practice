package TMCQuestions;

import java.util.Stack;

public class ValidateParentheses {
	
	public static void main(String args[])
	{
		System.out.println(ValidateParentheses.validateParentheses("var a=4;{[()()]()}"));
		
	}
	
	
	public static boolean validateParentheses(String input)
	{
		
		if(input == null || input.length()<=1)
		{
			return false;
		}
		
		Stack<Character> stack=new Stack<Character>();
		
		for(int i=0;i<input.toCharArray().length;i++)
		{
			
			if(input.charAt(i)=='[' || input.charAt(i)=='{' || input.charAt(i)=='(')
			{
				stack.push(input.charAt(i));
			}
			else
			{
				
				char c;
				
				if(stack.isEmpty())
					return false;
				else
				c = stack.peek();
				
				if (input.charAt(i)==']' && c=='[')
					stack.pop();
				else if (input.charAt(i)==')' && c=='(')
					stack.pop();
				else if (input.charAt(i)=='}' && c=='{')
					stack.pop();
				else 
					return false;
			}
		}
		
		if(stack.isEmpty())
		return true;
		else
		return false;
		
	}
	
}

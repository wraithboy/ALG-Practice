package stack;

import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        Stack<String> stringStack = new Stack<>();
        Stack<Integer> intStack = new Stack<>();

        int num=0;
        String str="";

        for(int i=0;i<s.length();i++)
        {
            if(Character.isDigit(s.charAt(i)))
            {
                num=num*10+s.charAt(i)-'0';
            }
            else if(s.charAt(i)=='[')
            {
                stringStack.push(str);
                intStack.push(num);
                num=0;
                str="";
            }
            else if(s.charAt(i)==']')
            {
                String prevStr = stringStack.pop();
                int prevInt=intStack.pop();

                for(int j=0;i<prevInt;j++)
                {
                    prevStr=prevStr+str;
                }

                str=prevStr;
                num=0;
            }
            else
            {
                str=str+s.charAt(i);
            }
        }

        return str;
    }
}

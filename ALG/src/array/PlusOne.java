package array;

import java.util.ArrayList;

public class PlusOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a={0};
		System.out.println(plusOne(a).length);
	}
	
    public static int[] plusOne(int[] digits) {
    	
    	if(digits==null || digits.length==0)
    	{
    		return null;
    	}
    	
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	
    	int carry=0;
    	
    	for(int i=digits.length-1;i>=0;i--)
    	{
    		if(i==digits.length-1){
        		int digit=(digits[i]+1+carry)%10;
        		carry=(digits[i]+1+carry)/10;
        		list.add(digit);
    		}
    		else
    		{
    			int digit=(digits[i]+carry)%10;
    			carry=(digits[i]+carry)/10;
    			list.add(digit);
    		}
    	}
    	
    	if(carry!=0)
    	{
    		list.add(carry);
    	}
    	
    	int[] result=new int[list.size()];
    	for(int i=0;i<list.size();i++)
    	{
    		result[i]=list.get(i);
    	}
    	
		return result;
    }
	
}

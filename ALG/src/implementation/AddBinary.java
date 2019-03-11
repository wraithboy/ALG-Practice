package implementation;

//Given two binary strings, return their sum (also a binary string).
//
//For example,
//a = "11"
//b = "1"
//Return "100".

public class AddBinary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
    public String addBinary(String a, String b) {

		StringBuilder result=new StringBuilder();

		int i=a.length()-1;
		int j=b.length()-1;
		int carry=0;

		while(i>=0 || j>=0)
		{
			int sum=carry;
			if(i>=0) sum=sum+a.charAt(i)-'0';
			if(j>=0) sum=sum+a.charAt(j)-'0';
			carry=sum/2;
			result.append(sum%2);
		}

		if(carry!=0)
		{
			result.append(carry);
		}

		return result.reverse().toString();

    }

}

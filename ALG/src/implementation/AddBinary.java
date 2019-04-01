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
		StringBuilder sb =new StringBuilder();

		int i=a.length()-1,j=b.length()-1;

		int carry=0;

		while(i>=0 || j>=0)
		{
			int sum=carry;

			if(i>=0)
			{
				sum=sum+a.charAt(i)-'0';
				i--;
			}

			if(j>=0)
			{
				sum=sum+b.charAt(j)-'0';
				j--;
			}

			carry=sum/2;
			sum=sum%2;
			sb.append(sum);
		}

		if(carry>0)
		{
			sb.append(carry);
		}

		return sb.reverse().toString();

    }

}

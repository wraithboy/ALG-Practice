package CodingImplementation;

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
        
        int carry=0;
        
        char[] aa=a.toCharArray();
        char[] bb=b.toCharArray();
        
        String sb="";
        
        int m=0;
        
        if(aa.length>bb.length)
        {
        	
        	int i=aa.length-1;
        	int j=bb.length-1;
        	
	        	while(i>=0)
	        	{
	        		if(j>=0)
	        		{
	        			m=(carry+aa[i]-48+bb[j]-48)%2;
	        			carry=(carry+aa[i]-48+bb[j]-48)/2;
	        		}
	        		else
	        		{
	        			m=(carry+aa[i]-48)%2;
	        			carry=(carry+aa[i]-48)/2;
	        		}
	        		
	        		i--;
	        		j--;
	        		
	        		sb=String.valueOf(m)+sb;
	        	 }
        	
        	
        }
        else
        {
        	int i=aa.length-1;
        	int j=bb.length-1;
        	
	        	while(j>=0)
	        	{
	        		if(i>=0)
	        		{
	        			m=(carry+aa[i]-48+bb[j]-48)%2;
	        			carry=(carry+aa[i]-48+bb[j]-48)/2;
	        		}
	        		else
	        		{
	        			m=(carry+bb[j]-48)%2;
	        			carry=(carry+bb[j]-48)/2;
	        		}
	        		
	        		i--;
	        		j--;
	        		
	        	   sb=String.valueOf(m)+sb;
	        	 }
	        	

        }
        
        if(carry!=0)
        {
        	sb=String.valueOf(carry)+sb;
        }
        
        return sb;
    }

}

package implementation;

public class ValidateIPAddress {

    public static void main(String args[])
    {
        ValidateIPAddress validator = new ValidateIPAddress();

        String s="2001:0db8:85a3:0:0:8A2E:0370:7334:";
    }

    public String validIPAddress(String IP) {

        if (isIPv4(IP)) {
            return "IPv4";
        }

        if (isIPv6(IP.toUpperCase())) {
            return "IPv6";
        }

        return "Neither";
    }

    private boolean isIPv4(String IP)
    {
        if(IP==null || IP.length()==0)
            return false;

        if(IP.charAt(IP.length()-1)=='.')
            return false;

        String[] fields = IP.split("\\.");

        if(fields.length!=4)
            return false;

        for(int i=0;i<4;i++)
        {

            try {
                int val = Integer.valueOf(fields[i]);
                if(val<0 || val>(1<<8)-1) return false;
            }
            catch(Exception e)
            {
                return false;
            }

            for(char ch: fields[i].toCharArray())
            {
                if(Character.isDigit(ch)==false)
                    return false;
            }

            if(fields[i].charAt(0)=='0'&& fields[i].length()>1)
                return false;
        }

        return true;
    }

    private boolean isIPv6(String IP)
    {
        if(IP==null || IP.length()==0)
            return false;

        if(IP.charAt(IP.length()-1)==':')
            return false;

        String[] fields = IP.split(":");

        if(fields.length!=8)
            return false;

        for(int i=0;i<8;i++)
        {
            if(fields[i].length()>4)
                return false;

            for(char c:fields[i].toCharArray()) {
                boolean isDigit = c>='0' && c<='9';
                boolean isUppercaseAF = c>='A' && c<='F';
                boolean isLowerCaseAF = c>='a' && c<='f';
                if(!(isDigit || isUppercaseAF || isLowerCaseAF))
                    return false;
            }

            try {
                int val = Integer.valueOf(fields[i],16);
                if (val < 0 || val > (1 << 16) - 1) return false;
            }
            catch(Exception e)
            {
                return false;
            }
        }

        return true;
    }

}

package TMCQuestions;

public class PowerOfTen {

    public static void main(String args[])
    {
        System.out.println(isPowTen(1000));
    }

    public static boolean isPowTen(int num)
    {
        while(num!=0)
        {
            if(num==1)
                return true;

            if(num%10!=0)
                return false;

            num=num/10;

        }

        return false;
    }
}

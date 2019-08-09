package bitmanipulation;

public class AddOperation {

    public static void main(String args[])
    {

        System.out.println(1^1^2^2^3^4^3);

        //System.out.println(add(5,6));
    }

    public static int add(int a, int b)
    {
        if(b==0)
            return a;

        int sum=a^b;
        int carry=a&b;

        return add(sum,carry<<1);
    }
}

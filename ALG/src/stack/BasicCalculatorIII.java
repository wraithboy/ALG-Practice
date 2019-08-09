package stack;

import java.util.Stack;

public class BasicCalculatorIII {

    public static void main(String args[])
    {
        BasicCalculatorIII calculator = new BasicCalculatorIII();
        System.out.println(calculator.calculate("(  5 * (  (  (  (   (   8   +((  (  ( 9 +  2) +   (   19+  1   ) ) -  (  ( 13  -15 )   + (11   / 2 ) ) )   /  ((   (15 *5   )* (5 *16 )  )  +   ((12   -   5  )   +   (6  *12))   ) )) *  ((   (20/  (( 19 -  8 )-   ( 11   -   6   )  )   )  +   ( ( (   4  *3) +   (   2-  13   ))  -(( 7*   13 )  /   (15  +   5   )  )   )  ) * ( 16 / (   18 *(  (  11 *  1)   +(   19   -   11   )   )))  )   )+   ((   (  (   15 -   (( 11 / 7   )  /   (15   /   3 ) ))-(   ((  19 *   4   )   /  (  15 *15  ))  * (   (  8   - 13   ) +  (  6-   4))   )  )  +  ( (   ( 13+  (   8-10 )) + (   (15  - 12)-   (  18   +   7   ) )  )   +  ((( 19 + 3) -(   12  *  16 ) )   +  (20   *  (  7 -  19 ) )   )  ))+   (   ( ((   (  17   -  11  ) *   ( 14  +14   ) )  * (  (  6 *  13  )+   (4/ 13  )))- (  ( (15   +17   )   -  (   18 -19   ))  *( (  20   +   7   )*   (  7 + 6   ) )   ) ) *   ( (  (  19  +(  9  +  8 ) ) +((  5+   2  )   +  (   3+  18) ))   * 7)  )   ))  /  10)   * (   (   5 *   (  (((  (   (   6*  13  )*   ( 19+  1  )  )*  ((   8*  16)   - (  8* 10  )   )  )   *   9  ) - (   (   17+   ( (6 *  8 )  -  (   5  *  4 ) ) ) +((  (  20 *  17  ) /( 19 +   5  ))/ (19+ (   11+   14   )  )   )  ))   /   ((   ((   (17 *   19)  * (18   -   9)  )+   (   (  18  +   12   )  -  ( 11  + 14)   ))+(  (  19   +  ( 8 +1  ) )   + 14 )   )   +   ( 19   +   13  )) )) /((  ( (  (  (( 8 + 14  ) +8   )  /( (   11   +   13 ) - ( 4   +   8  )))+   12  )*   (  ( (   (  9  /  18   ) *   (  17 *   20  ))-  (   (1 *  18 )  -   (  15  +  9) )  )  +   ( (20   /(   18*   15  )   )  -   ((   19 + 4  )   / (17  /   6) )   )   ))+( ( (   (   (  20 +17  )*15  )  +8   ) +((  (   9*   16) *11  )   *   (( 18  +   2 ) *17) ))+  1)) /  (  ((  7  * ((   (  4 /13 )-(  11  +  7   ))  *  3 ))   +   (   (  (   (  19  * 10   )   +  (   1   +   13  ))+(14+(   7 +  12  )  )   )   *   ( (  ( 18 + 6 )  +  (16  +  14   )  )+   ((  10*16  )   - ( 10  +   1 ) )   )))  / (   ( (  (  (  13  *  7 )- ( 9  /13 )   ) + (8-   (   4  +   14) ) )   *  8)  /   ( (   11*  (   ( 18  +4)   *  (  9   *   9 )  )   )  /  ( ( (   19   +  15)   -   (   7- 11 ))*  (  (  13  + 11 )  -  (   2   +  16  )) ) ) )   ) )   )) )"));
    }

    public int calculate(String s) {

        Stack<Integer> values= new Stack<Integer>();

        Stack<Character> operators = new Stack<Character>();

        int value=0;

        for(int i=0;i<s.length();i++)
        {
            char c = s.charAt(i);

            if(Character.isDigit(c))
            {
                while(i<s.length() && Character.isDigit(s.charAt(i)))
                {
                    value=value*10+c-'0';
                    i++;
                }
                i--;
                values.push(value);
                value=0;
            }
            else if(c=='(')
            {
                operators.push('(');
            }
            else if(c==')')
            {

                while(operators.peek()!='(')
                {
                    values.push(applyOperator(values.pop(),values.pop(),operators.pop()));
                }
                operators.pop();
            }
            else if(c=='+' || c=='-' || c=='*' || c=='/')
            {
                while(!operators.isEmpty() && precedence(c,operators.peek()))
                {
                    values.push(applyOperator(values.pop(),values.pop(),operators.pop()));
                }
                operators.push(c);
            }

        }

        while (!operators.isEmpty()) {
            values.push(applyOperator(values.pop(), values.pop(), operators.pop()));
        }

        return values.pop();
    }

    private boolean precedence(char op1, char op2) {
        if (op2 == '(' || op2 == ')') return false;
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) return false;
        return true;
    }

    private int applyOperator(int v1,int v2,char oper)
    {
        if(oper=='-')
        {
            return v1-v2;
        }
        else if(oper=='+')
        {
            return v1+v2;
        }
        else if(oper=='*')
        {
            return v1*v2;
        }
        else if(oper=='/')
        {
            return v1/v2;
        }
        else
        {
            return -1;
        }
    }
}

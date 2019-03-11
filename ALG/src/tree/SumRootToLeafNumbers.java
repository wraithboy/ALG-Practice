package tree;

public class SumRootToLeafNumbers {

    public int sumNumbers(TreeNode root) {

        int[] sum=new int[]{0};

//        sumNumbersHelper(root,sum);
//
        return sum[0];
    }


    public void sumNumbersHelper(TreeNode root,int carry,int[] sum)
    {
        if(root==null)
            return;

        if(root!=null)
        {
            carry=carry*10+root.val;
        }

        if(root.left==null && root.right==null)
        {
            sum[0]+=carry;
        }

        sumNumbersHelper(root.left,carry,sum);
        sumNumbersHelper(root.right,carry,sum);

    }
}

package LeetCodeQuestions;

import TMCQuestions.BinaryTreeNode;

/**
 * Created by donghuangwei on 3/12/17.
 */
public class ValidateBST {

    BinaryTreeNode prev;

    public static void main(String args[])
    {

    }

    public boolean isValidBSTUtil(BinaryTreeNode root, long max, long min)
    {
        if(root==null)
            return true;
        else if(root.value < max && root.value > min)
        {
            return isValidBSTUtil(root.left,root.value,min)&&isValidBSTUtil(root.right,max,root.value);
        }
        else
            return false;
    }

    public boolean isValidBST(BinaryTreeNode root) {

        if(root==null)
            return true;
        else
        {
            if(!isValidBST(root.left))
            {
                return false;
            }

            if(prev!=null && prev.value>=root.value)
            {
                return false;
            }
            prev=root;
            if(!isValidBST(root.right))
            {
                return false;
            }
        }

        return true;
    }

}

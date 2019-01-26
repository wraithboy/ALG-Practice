package Tree;

public class ConstrucBSTFromPreorderAndInOrder {

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        return buildTreeHelper(preorder,0,inorder,0,inorder.length-1);
    }

    public TreeNode buildTreeHelper(int[] preorder, int pre, int[] inorder,int inStart,int inEnd)
    {

        if(pre>preorder.length-1 || inStart>inEnd)
            return null;

        TreeNode root=new TreeNode(preorder[pre]);

        int index=0;

        for(int i=inStart;i<=inEnd;i++)
        {
            if(inorder[i]==preorder[pre])
            {
                index=i;
                break;
            }
        }

        root.left=buildTreeHelper(preorder,pre+1,inorder,inStart,index-1);
        root.right=buildTreeHelper(preorder,pre+index-inStart+1,inorder,index+1,inEnd);

        return root;
    }

}

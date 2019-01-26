package Tree;

public class FlattenBinaryTreetoLinkedList {

    public void flatten(TreeNode root) {

        if(root==null)
            return;

        if(root.left!=null)
        {
            TreeNode cur=root.left;

            while(cur.right!=null)
            {
                cur=cur.right;
            }

            TreeNode tmp=root.right;
            root.right=root.left;
            cur.right=tmp;
            root.left=null;
        }

        flatten(root.right);
    }
}

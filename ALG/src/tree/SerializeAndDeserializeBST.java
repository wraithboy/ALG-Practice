package tree;

public class SerializeAndDeserializeBST {

    public String serialize(TreeNode root) {

        StringBuilder sb = new StringBuilder();

        DFS(root,sb);

        return sb.toString();

    }

    private void DFS(TreeNode root,StringBuilder sb)
    {
        if(root==null)
        {
            sb.append("#");
            return;
        }

        sb.append(root.val).append("#");

        DFS(root.left,sb);
        DFS(root.right,sb);
    }

    
}

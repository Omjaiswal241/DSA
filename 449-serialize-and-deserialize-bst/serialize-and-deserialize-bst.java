/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null)
        {
            return "";
        }
        StringBuilder sb=new StringBuilder();
        Queue<TreeNode> qu=new LinkedList<>();
        qu.add(root);
        while(qu.size()>0)
        {
            TreeNode front=qu.remove();
            if(front==null)
            {
                sb.append("n ");
                continue;
            }
            sb.append(front.val+" ");
            qu.add(front.left);
            qu.add(front.right);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals(""))
        {
            return null;
        }
        String[] values=data.split(" ");
        TreeNode root=new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> qu=new ArrayDeque<>();
        qu.add(root);
        for(int i=1;i<values.length;i++)
        {
            TreeNode parent=qu.remove();
            if(!values[i].equals("n"))
            {
                TreeNode left=new TreeNode(Integer.parseInt(values[i]));
                parent.left=left;
                qu.add(left);
            }
            if(!values[++i].equals("n"))
            {
                TreeNode right=new TreeNode(Integer.parseInt(values[i]));
                parent.right=right;
                qu.add(right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;
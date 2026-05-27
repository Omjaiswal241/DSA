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
        String s="";
        Queue<TreeNode> qu=new LinkedList<>();
        qu.add(root);
        while(qu.size()>0)
        {
            TreeNode temp=qu.remove();
            if(temp==null)
            {
                s+='n'+" ";
            }
            else
            {
                s+=temp.val+" ";
                qu.add(temp.left);
                qu.add(temp.right);
            }
        }
        return s;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data=="")
        {
            return null;
        }
        String ar[]=data.split(" ");
        TreeNode root=new TreeNode(Integer.parseInt(ar[0]+""));
        Queue<TreeNode> qu=new ArrayDeque<>();
        qu.add(root);
        for(int i=1;i<ar.length;i++)
        {
            TreeNode parent=qu.remove();
            if(!ar[i].equals("n"))
            {
                TreeNode left=new TreeNode(Integer.parseInt(ar[i]+""));
                parent.left=left;
                qu.add(left);
            }
            if(!ar[++i].equals("n"))
            {
                TreeNode right=new TreeNode(Integer.parseInt(ar[i]+""));
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
// TreeNode ans = deser.deserialize(ser.serialize(root));
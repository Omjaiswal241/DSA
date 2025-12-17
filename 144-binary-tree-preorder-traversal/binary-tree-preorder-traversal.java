/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> li=new ArrayList<>();
        if(root==null)
        {
            return li;
        }
        Stack<TreeNode> st=new Stack<TreeNode>();
        st.add(root);
        while(st.size()!=0)
        {
            TreeNode temp=st.pop();
            if(temp.right!=null)
            {
                st.add(temp.right);
            }
            if(temp.left!=null)
            {
                st.add(temp.left);
            }
            li.add(temp.val);
        }
        return li;
    }
}
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
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> st1=new Stack<>();
        Stack<Integer> st2=new Stack<>();
        List<Integer> li=new ArrayList<>();
        if(root==null)
        {
            return li;
        }
        st1.push(root);
        while(st1.size()!=0)
        {
            TreeNode top=st1.pop();
            if(top.left!=null)
            {
                st1.push(top.left);
            }
            if(top.right!=null)
            {
                st1.push(top.right);
            }
            st2.push(top.val);
        }
        while(st2.size()!=0)
        {
            li.add(st2.pop());
        }
        return li;
    }
}
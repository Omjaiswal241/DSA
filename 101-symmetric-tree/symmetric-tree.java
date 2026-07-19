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
    public boolean isSymmetric(TreeNode root) {
        if(root==null)
        {
            return true;
        }
        return helper(root.left,root.right);
    }
    public boolean helper(TreeNode leftside,TreeNode rightside)
    {
        if(leftside==null && rightside==null)
        {
            return true;
        }
        if(leftside==null || rightside==null)
        {
            return false;
        }
        return leftside.val==rightside.val && helper(leftside.left,rightside.right) && helper(leftside.right,rightside.left);
    }
}
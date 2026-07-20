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
    public int rob(TreeNode root) {
        int options[]=solve(root);
        return Math.max(options[0],options[1]);
    }
    public int[] solve(TreeNode root)
    {
        if(root==null)
        {
            return new int[2];
        }
        int left[]=solve(root.left);
        int right[]=solve(root.right);
        int options[]=new int[2];  //0-not rob  1-rob
        options[0]=Math.max(left[0],left[1])+Math.max(right[0],right[1]);
        options[1]=root.val+left[0]+right[0];
        return options;
    }
}
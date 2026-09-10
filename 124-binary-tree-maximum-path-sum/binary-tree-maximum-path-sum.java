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
    int ans=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return ans;
    }
    public int helper(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }
        int leftsum=helper(root.left);
        int rightsum=helper(root.right);
        int yahi_mil_gaya=leftsum+rightsum+root.val;
        int ekside=Math.max(leftsum,rightsum)+root.val;
        int curr_se=root.val;
        ans=Math.max(ans,Math.max(yahi_mil_gaya,Math.max(ekside,curr_se)));
        return Math.max(ekside,curr_se);
    }
}
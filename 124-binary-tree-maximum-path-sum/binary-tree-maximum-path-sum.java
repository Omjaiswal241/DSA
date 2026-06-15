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
    int max_sum=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return max_sum;
    }
    public int helper(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }
        int left=helper(root.left);
        int right=helper(root.right);
        int neeche_hi_milgaya=left+right+root.val;
        int upar_hai=Math.max(left,right)+root.val;
        int wahi_hai=root.val;
        max_sum=Math.max(max_sum,(Math.max(wahi_hai,Math.max(neeche_hi_milgaya,upar_hai))));
        return Math.max(upar_hai,wahi_hai);
    }
}
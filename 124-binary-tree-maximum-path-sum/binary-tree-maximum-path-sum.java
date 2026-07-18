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
        int left=helper(root.left);
        int right=helper(root.right);
        int neeche_hi_ans=left+root.val+right;
        int idhr_se_start=root.val;
        int ek_side_liya=Math.max(left,right)+root.val;
        ans=Math.max(ans,Math.max(neeche_hi_ans,Math.max(idhr_se_start,ek_side_liya)));
        return Math.max(idhr_se_start,ek_side_liya);
    }
}
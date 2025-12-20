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
    int maxsum;
    public int maxPathSum(TreeNode root) {
        maxsum=Integer.MIN_VALUE;
        solve(root);
        return maxsum;
    }
    public int solve(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }
        int left=solve(root.left);
        int right=solve(root.right);

        int neeche_hi_milgaya_ans=left+right+root.val;

        int koi_ek_acha=Math.max(left,right)+root.val;

        int only_root_acha=root.val;

        maxsum=Math.max(Math.max(Math.max(neeche_hi_milgaya_ans,maxsum),koi_ek_acha),only_root_acha);
        return Math.max(koi_ek_acha,only_root_acha);
    }
}
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
    int maxsum=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return maxsum;
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
        int ek_path_sahi_hai=Math.max(left,right)+root.val;
        int only_root=root.val;
        maxsum=Math.max(Math.max(Math.max(neeche_hi_milgaya,ek_path_sahi_hai),only_root),maxsum);
        return Math.max(ek_path_sahi_hai,only_root);
    }
}
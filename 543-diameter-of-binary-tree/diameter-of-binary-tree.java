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
    class Diapair
    {
        int dianode,ht;
        Diapair(int dianode,int ht)
        {
            this.dianode=dianode;
            this.ht=ht;
        }
    }
    public int diameterOfBinaryTree(TreeNode root) {
        Diapair res=helper(root);
        return res.dianode;
    }
    public Diapair helper(TreeNode root)
    {
        if(root==null)
        {
            return new Diapair(0,-1);
        }
        Diapair left=helper(root.left);
        Diapair right=helper(root.right);
        int diaofnode=left.ht+right.ht+2;
        int diaoftree=Math.max(Math.max(left.dianode,right.dianode),diaofnode);
        return new Diapair(diaoftree,Math.max(left.ht,right.ht)+1);
    }
}
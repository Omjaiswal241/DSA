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
    class DiaPair
    {
        int dia,ht;
        DiaPair(int dia,int ht)
        {
            this.dia=dia;
            this.ht=ht;
        }
    }
    public int diameterOfBinaryTree(TreeNode root) {
        DiaPair res=helper(root);
        return res.dia;
    }
    public DiaPair helper(TreeNode root)
    {
        if(root==null)
        {
            return new DiaPair(0,-1);
        }
        DiaPair left=helper(root.left);
        DiaPair right=helper(root.right);
        int dianode=(left.ht+right.ht)+2;
        int diaoftree=Math.max(Math.max(left.dia,right.dia),dianode);
        return new DiaPair(diaoftree,Math.max(left.ht,right.ht)+1);
    }
}
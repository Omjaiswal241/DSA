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
    static class DiaPair
    {
        int dia;
        int ht;
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
        DiaPair leftPair=helper(root.left);
        DiaPair rightPair=helper(root.right);
        int dianode=leftPair.ht+rightPair.ht+2;
        int diatree=Math.max(Math.max(leftPair.dia,rightPair.dia),dianode);
        return new DiaPair(diatree,Math.max(leftPair.ht,rightPair.ht)+1);
    }
}
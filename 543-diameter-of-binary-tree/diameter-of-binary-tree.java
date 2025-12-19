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
    static class Diapair
    {
        int ht,dia;
        Diapair(int ht,int dia)
        {
            this.ht=ht;
            this.dia=dia;
        }
    }
    public int diameterOfBinaryTree(TreeNode root) {
        Diapair res=diameter(root);
        return res.dia;
    }
    public static Diapair diameter(TreeNode root)
    {
        if(root==null)
        {
            return new Diapair(-1,0);
        }
        Diapair left=diameter(root.left);
        Diapair right=diameter(root.right);
        int diaofnode=left.ht+right.ht+2;
        int diaoftree=Math.max(Math.max(left.dia,right.dia),diaofnode);
        return new Diapair(Math.max(left.ht,right.ht)+1,diaoftree);
    }
}
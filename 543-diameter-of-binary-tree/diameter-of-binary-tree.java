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
    static class Pair
    {
        int ht;
        int diaoftree;
        Pair(int ht,int diaoftree)
        {
           this.ht=ht;
           this. diaoftree=diaoftree;
        }
    }
    public int diameterOfBinaryTree(TreeNode root) {
        Pair node=helper(root);
        return node.diaoftree;
    }
    public static Pair helper(TreeNode root)
    {
        if(root==null)
        {
            return new Pair(-1,0);
        }
        Pair lpair=helper(root.left);
        Pair rpair=helper(root.right);
        int lht=lpair.ht;
        int rht=rpair.ht;
        int diaofnode=lht+rht+2;
        int diaoftree=Math.max(Math.max(lpair.diaoftree,rpair.diaoftree),diaofnode);
        return new Pair(Math.max(lht,rht)+1,diaoftree);
    }
}
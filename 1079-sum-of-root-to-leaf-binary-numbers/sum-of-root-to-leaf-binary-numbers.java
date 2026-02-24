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
    ArrayList<String> li=new ArrayList<>();
    public int sumRootToLeaf(TreeNode root) {
        int sum=0;
       helper(root,"");
       for(int i=0;i<li.size();i++)
       {
        int a=Integer.parseInt(li.get(i),2);
        sum+=a;
       } 
       return sum;
    }
    public void helper(TreeNode root,String s)
    {
        if(root==null)
        {
            return;
        }
        if(root.left==null && root.right==null)
        {
            li.add(s+root.val);
            return;
        }
        s+=root.val;
        helper(root.left,s);
        helper(root.right,s);
    }
}
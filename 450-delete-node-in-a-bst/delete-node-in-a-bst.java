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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null)
        {
            return null;
        }
        if(root.val==key)
        {
            return helper(root,key);
        }
        TreeNode dummy=root;
        while(root!=null)
        {
            if(root.val>key)
            {
                if(root.left!=null && root.left.val==key)
                {
                    root.left=helper(root.left,key);
                    break;
                }
                else
                {
                root=root.left;
                }
            }
            else
            {
                if(root.right!=null && root.right.val==key)
                {
                    root.right=helper(root.right,key);
                    break;
                }
                else
                {
                    root=root.right;
                }
            }
        }
        return dummy;
    }
    public static TreeNode helper(TreeNode root,int key)
    {
        if(root.left==null)
        {
            return root.right;
        }
        if(root.right==null)
        {
            return root.left;
        }
        TreeNode right=root.right;
        TreeNode rightmost=find(root.left);
        rightmost.right=right;
        return root.left;
    }
    public static TreeNode find(TreeNode root)
    {
        while(root.right!=null)
        {
            root=root.right;
        }
        return root;
    }
}
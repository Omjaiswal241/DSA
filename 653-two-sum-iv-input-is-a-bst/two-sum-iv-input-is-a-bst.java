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
    ArrayList<Integer> li=new ArrayList<>();
    public boolean findTarget(TreeNode root, int k) {
        inorder(root);
        int i=0,j=li.size()-1;
        while(i<j)
        {
            if(li.get(i)+li.get(j)==k)
            {
                return true;
            }
            else if(li.get(i)+li.get(j)>k)
            {
                j--;
            }
            else
            {
                i++;
            }
        }
        return false;
    }
    public void inorder(TreeNode root)
    {
        if(root==null)
        {
            return;
        }
        inorder(root.left);
        li.add(root.val);
        inorder(root.right);
    }
}
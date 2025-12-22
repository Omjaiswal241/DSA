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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        solve(root,0,res);
        return res;
    }
    void solve(TreeNode root,int currlvl,List<Integer> res)
    {
        if(root==null)
        {
            return;
        }
        if(currlvl==res.size())
        {
            res.add(root.val);
        }
        solve(root.right,currlvl+1,res);
        solve(root.left,currlvl+1,res);
    }
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)
        {
            return null;
        }
        List<TreeNode> l1=nodetoroot(root,p);
        List<TreeNode> l2=nodetoroot(root,q);
        int idx1=l1.size()-1;
        int idx2=l2.size()-1;
        while(idx1>=0 && idx2>=0 && l1.get(idx1).val==l2.get(idx2).val)
        {
            idx1--;
            idx2--;
        }
        return l1.get(idx1+1);
    }
    public List<TreeNode> nodetoroot(TreeNode root,TreeNode tar)
    {
        if(root==null)
        {
            return new ArrayList<>();
        }
        if(root==tar)
        {
            List<TreeNode> base=new ArrayList<>();
            base.add(root);
            return base;
        }
        List<TreeNode> left=nodetoroot(root.left,tar);
        if(left.size()!=0)
        {
            left.add(root);
            return left;
        }
        List<TreeNode> right=nodetoroot(root.right,tar);
        if(right.size()!=0)
        {
            right.add(root);
            return right;
        }
        return new ArrayList<>();
    } 
}
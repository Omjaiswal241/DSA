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
        List<TreeNode> l1=nodetoroot(root,p);
        List<TreeNode> l2=nodetoroot(root,q);
        int p1=l1.size()-1,p2=l2.size()-1;
        while((p1>=0 && p2>=0) && l1.get(p1)==l2.get(p2))
        {
            p1--;
            p2--;
        }
        return l1.get(p1+1);
    }
    public List<TreeNode> nodetoroot(TreeNode root,TreeNode p)
    {
        if(root==null)
        {
            return new ArrayList<>();
        }
        if(root==p)
        {
            List<TreeNode> base=new ArrayList<>();
            base.add(root);
            return base;
        }
        List<TreeNode> left=nodetoroot(root.left,p);
        if(left.size()>0)
        {
            left.add(root);
            return left;
        }
        List<TreeNode> right=nodetoroot(root.right,p);
        if(right.size()>0)
        {
            right.add(root);
            return right;
        }
        return new ArrayList<>();
    }
}
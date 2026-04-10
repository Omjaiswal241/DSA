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
        ArrayList<TreeNode> a=nodetoroot(root,p);
        ArrayList<TreeNode> b=nodetoroot(root,q);
        int x=a.size()-1;
        int y=b.size()-1;
        while(x>=0 && y>=0)
        {
            if(a.get(x).val==b.get(y).val)
            {
                x--;
                y--;
            }
            else
            {
                break;
            }
        }
        x++;
        y++;
        return a.get(x);
    }
    public ArrayList<TreeNode> nodetoroot(TreeNode root,TreeNode tar)
    {
        if(root==null)
        {
            return new ArrayList<>();
        }
        if(root==tar)
        {
            ArrayList<TreeNode> base=new ArrayList<>();
            base.add(root);
            return base;
        }
        ArrayList<TreeNode> left=nodetoroot(root.left,tar);
        if(left.size()!=0)
        {
            left.add(root);
            return left;
        }
        ArrayList<TreeNode> right=nodetoroot(root.right,tar);
        if(right.size()!=0)
        {
            right.add(root);
            return right;
        }
        return new ArrayList<>();
    }
}
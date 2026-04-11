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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> res=new ArrayList<>();
        if(root==null)
        {
            return res;
        }
        ArrayList<TreeNode> temp=nodetoroot(root,target);
        for(int i=0;i<temp.size();i++)
        {
            TreeNode curr=temp.get(i);
            if(i==0)
            {
                kdistfar(curr,k,res);
            }
            else
            {
                int dac=i;
                int rd=k-i;
                if(rd==0)
                {
                    res.add(curr.val);
                }
                else
                {
                TreeNode prev=temp.get(i-1);
                if(prev==curr.left)
                {
                    kdistfar(curr.right,rd-1,res);
                }
                else
                {
                    kdistfar(curr.left,rd-1,res);
                }
                }
            }
        }
        return res;
    }
    public void kdistfar(TreeNode root,int k,List<Integer> res)
    {
        if(root==null || k<0)
        {
            return;
        }
        if(k==0)
        {
            res.add(root.val);
            return;
        }
        kdistfar(root.left,k-1,res);
        kdistfar(root.right,k-1,res);
    }
    public ArrayList<TreeNode> nodetoroot(TreeNode root,TreeNode tar)
    {
        if(root==null)
        {
            return new ArrayList<>();
        }
        if(root.val==tar.val)
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
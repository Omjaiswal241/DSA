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
        List<Integer> li=new ArrayList<Integer>();
        if(root==null)
        {
            return li;
        }
        List<TreeNode> temp=nodetoroot(root,target.val);
        for(int idx=0;idx<temp.size();idx++)
        {
            TreeNode curr=temp.get(idx);
            if(idx==0)
            {
                kleveldown(curr,k,li);
            }
            else
            {
                int dac=idx;
                int rdist=k-dac;
                if(rdist==0)
                {
                    li.add(curr.val);
                }
                else
                {
                    TreeNode prev=temp.get(idx-1);
                    if(curr.left==prev)
                    {
                        kleveldown(curr.right,rdist-1,li);
                    }
                    else
                    {
                        kleveldown(curr.left,rdist-1,li);
                    }
                }
            }
        }
        return li;
    }
    public static void kleveldown(TreeNode root,int k,List<Integer> li)
    {
        if(root==null)
        {
            return;
        }
        if(k==0)
        {
            li.add(root.val);
            return;
        }
        kleveldown(root.left,k-1,li);
        kleveldown(root.right,k-1,li);
    }
    public static List<TreeNode> nodetoroot(TreeNode root,int target)
    {
        if(root==null)
        {
            return new ArrayList<>();
        }
        if(root.val==target)
        {
            List<TreeNode> base=new ArrayList<>();
            base.add(root);
            return base;
        }
        List<TreeNode> left=nodetoroot(root.left,target);
        if(left.size()!=0)
        {
            left.add(root);
            return left;
        }
        List<TreeNode> right=nodetoroot(root.right,target);
        if(right.size()!=0)
        {
            right.add(root);
            return right;
        }
        return new ArrayList<>();
    }
}
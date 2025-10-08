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
        List<Integer> ans=new ArrayList<>();
        List<TreeNode> li=nodetorootpath(root,target.val);
        for(int i=0;i<li.size();i++)
        {
            TreeNode curr=li.get(i);
            if(i==0)
            {
                kleveldown(curr,k,ans);
            }
            else
            {
            int dac=i;
            int dreq=k-i;
            if(dreq==0)
            {
                ans.add(curr.val);
            }
            else
            {
                TreeNode prev=li.get(i-1);
                if(curr.left==prev)
                {
                    kleveldown(curr.right,dreq-1,ans);
                }
                else
                {
                    kleveldown(curr.left,dreq-1,ans);
                }
            }
            }
        }
        return ans;
    }
    public static void kleveldown(TreeNode node,int k,List<Integer> li)
    {
        if(node==null)
        {
            return;
        }
        if(k==0)
        {
            li.add(node.val);
            return;
        }
        kleveldown(node.left,k-1,li);
        kleveldown(node.right,k-1,li);
    }
    public static List<TreeNode> nodetorootpath(TreeNode node,int val)
    {
        if(node==null)
        {
            return new ArrayList<>();
        }
        if(node.val==val)
        {
            List<TreeNode> base=new ArrayList<>();
            base.add(node);
            return base;
        }
        List<TreeNode> lres=nodetorootpath(node.left,val);
        if(lres.size()>0)
        {
            lres.add(node);
            return lres;
        }
        List<TreeNode> rres=nodetorootpath(node.right,val);
        if(rres.size()>0)
        {
            rres.add(node);
            return rres;
        }
        return new ArrayList<>();
    }
}
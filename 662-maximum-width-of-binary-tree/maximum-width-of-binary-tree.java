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
    static class Pair
    {
        TreeNode node;
        int idx;
        Pair(TreeNode node,int idx)
        {
            this.node=node;
            this.idx=idx;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null)
        {
            return 0;
        }
        Queue<Pair> qu=new LinkedList<>();
        qu.add(new Pair(root,0));
        int maxwidth=0;
        while(qu.size()>0)
        {
            int minidx=qu.peek().idx;
            long size=qu.size();
            long first=0,last=0;
            for(int i=0;i<size;i++)
            {
                Pair curr=qu.poll();
                curr.idx=curr.idx-minidx;
                if(i==0)
                {
                    first=curr.idx;
                }
                if(i==size-1)
                {
                    last=curr.idx;
                }
                if(curr.node.left!=null)
                {
                    qu.add(new Pair(curr.node.left,2*curr.idx+1));
                }
                if(curr.node.right!=null)
                {
                    qu.add(new Pair(curr.node.right,2*curr.idx+2));
                }
            }
            maxwidth=Math.max(maxwidth,(int)(last-first)+1);
        }
        return maxwidth;
    }
}
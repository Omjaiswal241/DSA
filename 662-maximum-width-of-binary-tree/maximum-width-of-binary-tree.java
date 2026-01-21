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
    class Pair
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
       Queue<Pair> qu=new ArrayDeque<>();
       qu.add(new Pair(root,0));
       int mmin=Integer.MIN_VALUE;
       while(qu.size()!=0)
       {
        int size=qu.size();
        int low=0,high=0;
        for(int i=0;i<size;i++)
        {
            int curridx=qu.peek().idx;
            if(i==0)
            {
                low=curridx;
            }
            if(i==size-1)
            {
                high=curridx;
            }
            Pair curr=qu.remove();
            if(curr.node.left!=null)
            {
                qu.add(new Pair(curr.node.left,2*(curridx-low)+1));
            }
            if(curr.node.right!=null)
            {
                qu.add(new Pair(curr.node.right,2*(curridx-low)+2));
            }
        }
        mmin=Math.max(mmin,(high-low)+1);
       } 
       return mmin;
    }
}
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
        long idx;
        Pair(TreeNode node,long idx)
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
        Deque<Pair> qu=new ArrayDeque<>();
        qu.add(new Pair(root,0));
        long res=Long.MIN_VALUE;
        while(qu.size()!=0)
        {
            long low=qu.getFirst().idx;
            long high=qu.getLast().idx;
            res=Math.max(res,high-low+1);
            int n=qu.size();
            while(n-- >0)
            {
                Pair temp=qu.poll();
                TreeNode curr=temp.node;
                long idx=temp.idx;
                if(curr.left!=null)
                {
                    qu.add(new Pair(curr.left,(long)(2*idx+1)));
                } 
                if(curr.right!=null)
                {
                    qu.add(new Pair(curr.right,(long)(2*idx+2)));
                }
            }
        }
        return (int)res;
    }
}
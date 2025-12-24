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
        int maxwidth=Integer.MIN_VALUE;
        qu.add(new Pair(root,0));
        while(qu.size()!=0)
        {
            int size=qu.size();
            int low=0,high=0;
            int mmin=qu.peek().idx;
            for(int i=0;i<size;i++)
            {
                int curridx=qu.peek().idx;
                if(i==0) low=qu.peek().idx;
                if(i==size-1) high=qu.peek().idx;
                Pair front=qu.remove();
                if(front.node.left!=null)
                {
                    qu.add(new Pair(front.node.left,2*(curridx-mmin)+1));
                }
                if(front.node.right!=null)
                {
                    qu.add(new Pair(front.node.right,2*(curridx-mmin)+2));
                }
            }
            maxwidth=Math.max(maxwidth,high-low+1);
        }
        return maxwidth;
    }
}
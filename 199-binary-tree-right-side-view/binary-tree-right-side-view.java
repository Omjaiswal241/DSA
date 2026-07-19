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
        int row;
        Pair(TreeNode node,int row)
        {
            this.node=node;
            this.row=row;
        }
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        if(root==null)
        {
            return res;
        }
        TreeMap<Integer,Integer> tm=new TreeMap<>();
        Queue<Pair> qu=new ArrayDeque<>();
        qu.add(new Pair(root,0));
        while(qu.size()>0)
        {
            Pair curr=qu.poll();
            tm.putIfAbsent(curr.row,curr.node.val);
            if(curr.node.right!=null)
            {
                qu.add(new Pair(curr.node.right,curr.row+1));
            }
            if(curr.node.left!=null)
            {
                qu.add(new Pair(curr.node.left,curr.row+1));
            }
        }
        for(int key:tm.keySet())
        {
            res.add(tm.get(key));
        }
        return res;
    }
}
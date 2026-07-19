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
    class Nodeinfo
    {
        int row,col,val;
        Nodeinfo(int row,int col,int val)
        {
            this.row=row;
            this.col=col;
            this.val=val;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        List<Nodeinfo> li=new ArrayList<>();
        dfs(0,0,root,li);
        Collections.sort(li,(a,b)->
        {
            if(a.col!=b.col) return a.col-b.col;
            if(a.row!=b.row) return a.row-b.row;
            return a.val-b.val;
        });
        int prevcol=Integer.MIN_VALUE;
        for(Nodeinfo i:li)
        {
            if(i.col!=prevcol)
            {
                res.add(new ArrayList<>());
                prevcol=i.col;
            }
            res.get(res.size()-1).add(i.val);
        }
        return res;
    }
    public void dfs(int row,int col,TreeNode root,List<Nodeinfo> li)
    {
        if(root==null)
        {
            return;
        }
        li.add(new Nodeinfo(row,col,root.val));
        dfs(row+1,col-1,root.left,li);
        dfs(row+1,col+1,root.right,li);
    }
}
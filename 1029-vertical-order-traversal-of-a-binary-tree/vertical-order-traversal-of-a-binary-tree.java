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
        int col,row,val;
        Nodeinfo(int col,int row,int val)
        {
            this.col=col;
            this.row=row;
            this.val=val;
        }
    }
    List<Nodeinfo> li=new ArrayList<>();
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        dfs(0,0,root);
        Collections.sort(li,(a,b)->
        {
            if(a.col!=b.col) return a.col-b.col;
            if(a.row!=b.row) return a.row-b.row;
            return a.val-b.val;
        });
        List<List<Integer>> res=new ArrayList<>();
        int prevcol=Integer.MIN_VALUE;
        for(Nodeinfo n:li)
        {
            if(n.col!=prevcol)
            {
                res.add(new ArrayList<>());
                prevcol=n.col;
            }
            res.get(res.size()-1).add(n.val);
        }
        return res;
    }
    void dfs(int col,int row,TreeNode root)
    {
        if(root==null)
        {
            return;
        }
        li.add(new Nodeinfo(col,row,root.val));
        dfs(col-1,row+1,root.left);
        dfs(col+1,row+1,root.right);
    }
}
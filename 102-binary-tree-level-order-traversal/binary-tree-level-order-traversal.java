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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> qu=new ArrayDeque<>();
        List<List<Integer>> res=new ArrayList<>();
        if(root==null)
        {
            return res;
        } 
        qu.add(root);
        while(qu.size()!=0)
        {
            int size=qu.size();
            List<Integer> li=new ArrayList<>();
            for(int i=0;i<size;i++)
            {
                if(qu.peek().left!=null)
                {
                    qu.add(qu.peek().left);
                }
                if(qu.peek().right!=null)
                {
                    qu.add(qu.peek().right);
                }
                li.add(qu.remove().val);
            }
            res.add(li);
        }
        return res;
    }
}
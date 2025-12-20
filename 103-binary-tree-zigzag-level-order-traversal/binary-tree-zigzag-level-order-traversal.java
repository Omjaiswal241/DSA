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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        Queue<TreeNode> qu=new ArrayDeque<>();
        if(root==null)
        {
            return res;
        }
        qu.add(root);
        boolean lTOr=true;
        while(qu.size()!=0)
        {
            int size=qu.size();
            List<Integer> li=new ArrayList<>();
            for(int i=0;i<size;i++)
            {
                TreeNode front=qu.remove();
                if(lTOr==true)
                {
                    li.addLast(front.val);
                }
                else
                {
                    li.addFirst(front.val);
                }
                if(front.left!=null)
                {
                    qu.add(front.left);
                }
                if(front.right!=null)
                {
                    qu.add(front.right);
                }
            }
            res.add(li);
            lTOr=!lTOr;
        }
        return res;
    }
}
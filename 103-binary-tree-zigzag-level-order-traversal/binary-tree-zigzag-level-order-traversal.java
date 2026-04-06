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
        boolean lTOr=true;
        if(root==null)
        {
            return res;
        }
        Queue<TreeNode> qu=new ArrayDeque<>();
        qu.add(root);
        while(qu.size()!=0)
        {
            List<Integer> li=new ArrayList<>();
            int size=qu.size();
            for(int i=0;i<size;i++)
            {
                TreeNode front=qu.remove();
                if(front.left!=null)
                {
                    qu.add(front.left);
                }
                if(front.right!=null)
                {
                    qu.add(front.right);
                }
                li.add(front.val);
            }
            if(lTOr==true)
            {
                res.add(li);
                lTOr=false;
            }
            else
            {
                Collections.reverse(li);
                res.add(li);
                lTOr=true;
            }
        }
        return res;
    }
}
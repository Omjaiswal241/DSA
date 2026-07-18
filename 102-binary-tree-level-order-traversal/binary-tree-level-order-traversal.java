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
        List<List<Integer>> res=new ArrayList<>();
        if(root==null)
        {
            return res;
        }
        Queue<TreeNode> qu=new ArrayDeque<>();
        qu.add(root);
        while(qu.size()!=0)
        {
            int size=qu.size();
            List<Integer> li=new ArrayList<>();
            for(int i=0;i<size;i++)
            {
                TreeNode curr=qu.remove();
                if(curr.left!=null)
                {
                    qu.add(curr.left);
                }
                if(curr.right!=null)
                {
                    qu.add(curr.right);
                }
                li.add(curr.val);
            }
            res.add(new ArrayList<>(li));
        }
        return res;
    }
}
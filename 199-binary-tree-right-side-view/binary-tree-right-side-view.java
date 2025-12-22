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
    class NodePair
    {
        TreeNode node;
        int level;
        NodePair(TreeNode node,int level)
        {
            this.node=node;
            this.level=level;
        }
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> li=new ArrayList<>();
        if(root==null)
        {
            return li;
        }
        TreeMap<Integer,Integer> tm=new TreeMap<>();
        Queue<NodePair> qu=new ArrayDeque<>();
        qu.add(new NodePair(root,0));
        while(qu.size()!=0)
        {
            NodePair front=qu.remove();
            tm.putIfAbsent(front.level,front.node.val);
            if(front.node.right!=null)
            {
                qu.add(new NodePair(front.node.right,front.level+1));
            }
            if(front.node.left!=null)
            {
                qu.add(new NodePair(front.node.left,front.level+1));
            }
        }
        for(int val:tm.values())
        {
            li.add(val);
        }
        return li;
    }
}
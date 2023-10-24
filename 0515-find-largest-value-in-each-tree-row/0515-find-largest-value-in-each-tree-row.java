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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer>res=new ArrayList<>();
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        // res.add(root.val);
        if(root==null)
        {
            return res;
        }
        while(!q.isEmpty())
        {
            int max=Integer.MIN_VALUE;
            int count=q.size();
            for(int i=0;i<count;i++)
            {
                TreeNode  curr=q.poll();
                max=Math.max(max,curr.val);
                if(curr.left!=null)
                {
                    q.add(curr.left);
                }
                if(curr.right!=null)
                {
                    q.add(curr.right);
                }
            }
            res.add(max);
        }
        return res;
    }
}
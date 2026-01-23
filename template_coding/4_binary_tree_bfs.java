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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        int l = 1;
        int mx = Integer.MIN_VALUE;
        int mxl = -1;
        while(q.size()>0){
            int sm = 0;
            while(q.peek()!=null){
                var node = q.poll();
                sm+=node.val;
                if(node.left!=null)
                q.add(node.left);
                if(node.right!=null)
                q.add(node.right);
            }
            q.poll();
            if(q.size()>0){
                q.add(null);
            }
            if(mx < sm){
                mx = sm;
                mxl = l;
            }
            l++;
        }
        return mxl;
    }
}
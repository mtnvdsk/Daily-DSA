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
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> temp=new LinkedList<>();
        temp.add(root);
        int level=0;
        boolean flag=true;
        while(!temp.isEmpty()){
            //TreeNode a=temp.poll();
            int size=temp.size();
            List<Integer> b=new ArrayList<>();
            int prev=flag?Integer.MIN_VALUE:Integer.MAX_VALUE;
            for(int i=0;i<size;i++){
                TreeNode a=temp.poll();
                if(flag){
                    if(a.val%2==0|| a.val<=prev) return false;
                }else{
                    if(a.val%2!=0 || a.val>=prev) return false;
                }
                if(a.left!=null) temp.offer(a.left);
                if(a.right!=null) temp.offer(a.right);
                prev=a.val;
            }
            flag=!flag;
        }
        return true;
    }
}